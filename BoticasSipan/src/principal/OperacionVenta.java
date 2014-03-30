/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Date;

/**
 *
 * @author Erick Orlando
 */
public class OperacionVenta {

    public String NombreCliente;
    public Date FechaVenta;
    public float SubTotal;
    public float Impuestos;
    public float Total;
    public String UsuarioRegistrador;
    public DetalleVenta listaDetalles[] = new DetalleVenta[50];

    private static int PosicionDisponible;
    public static int Posicion;

    public static void AgregarOperacion() {
        Helper.SeparadorDoble();
        Helper.Escribir("Registro de Operación de Venta");
        Helper.SeparadorDoble();

        OperacionVenta venta = new OperacionVenta();
        venta.FechaVenta = new java.util.Date(); // Fecha actual.
        venta.UsuarioRegistrador = BoticasSipan.UsuarioLogueado; // Usuario autenticado.
        Helper.Escribir("Escriba el DNI del Cliente");
        venta.BuscarClientePorCodigo();
        Helper.Escribir("Cliente seleccionado exitosamente.");
        Helper.Separador();
        Helper.Escribir("Ingresar los medicamentos a vender");
        venta.AgregarMedicamentos();
        if (venta.listaDetalles.length == 0)
        {
            // Si al final no se agregó ningun medicamento.
            BoticasSipan.MenuOpciones();
        }
        // Una vez terminado de ingresar todos los medicamentos 
        // procedemos a hacer la suma de los items.
        float suma = 0;
        for (DetalleVenta detalle : venta.listaDetalles) {
            if (detalle != null) {
                suma = suma + detalle.ImporteTotal;
            }
        }
        venta.SubTotal = suma;
        venta.Impuestos = suma * (float) (0.18);
        venta.Total = venta.SubTotal + venta.Impuestos;
        Helper.Escribir("Operacion de Venta registrada exitosamente");
        Helper.SeparadorDoble();
        venta.MostrarBoleta();

        // Actualizamos los puntos bono del Cliente.
        Cliente cliente = BoticasSipan.listaClientes[Cliente.Posicion];
        int puntosAntesDeComprar = cliente.PuntosBono;
        cliente.PuntosBono = puntosAntesDeComprar + (int) venta.Total;
        Helper.Escribir("En esta compra el cliente ha ganado " + (int) venta.Total + " Puntos Bono.");
        Helper.Escribir("Total de Puntos Bono acumulados:\t" + cliente.PuntosBono);
        Helper.SeparadorDoble();

        Helper.EscribirJunto("El cliente desea pagar con Puntos Bono? [S/N]");
        boolean pagoConPuntos = Helper.LeerCadena().toLowerCase().equals("s");
        float montoRecaudado = 0;
        boolean ventaRealizada;
        if (pagoConPuntos) {
            montoRecaudado = cliente.PuntosBono / 100;
        }
        // Si todos los puntos del Cliente alcanzan para comprar.
        if (montoRecaudado == venta.Total) {
            ventaRealizada = true;
        } else {
            Helper.Escribir("Cliente debe abonar en efectivo la suma de " + (venta.Total - montoRecaudado) + " Nuevos Soles.");
            Helper.EscribirJunto("Finalizar Venta [S/N]");
            ventaRealizada = Helper.LeerCadena().toLowerCase().equals("s");
        }

        if (ventaRealizada) {
            venta.ActualizarStockMedicamentos();
            if (pagoConPuntos) {
                cliente.PuntosBono = 0;
            }
            BoticasSipan.listaClientes[Cliente.Posicion] = cliente;
            // Agregamos la Venta a la clase Principal.
            BuscarPosicionDisponible();
            BoticasSipan.listaOperaciones[Posicion] = venta;

            Helper.Escribir("Venta exitosa. Desea realizar otra Operación de Venta? [S/N]");
            if (Helper.LeerCadena().toLowerCase().equals("s")) {
                AgregarOperacion();
            } else {
                BoticasSipan.MenuOpciones();
            }
        } else {
            // Como se cancela la venta se regresan los puntos Bono antes de comprar.
            cliente.PuntosBono = puntosAntesDeComprar;
            BoticasSipan.MenuOpciones();
        }
    }

    private void BuscarClientePorCodigo() {
        // Realizar la busqueda de Cliente por DNI
        // En caso no exista se creará.
        Cliente.BuscarPorCodigo(Helper.LeerCadena());
        if (Cliente.Posicion > -1) {
            SeleccionarCliente();
        } else {
            Helper.Escribir("No se encontró el DNI, se procederá a crear el Cliente");
            Helper.Separador();
            Cliente.Agregar();
            SeleccionarCliente();
        }
    }

    private void SeleccionarCliente() {
        NombreCliente = BoticasSipan.listaClientes[Cliente.Posicion].Nombres
                + " "
                + BoticasSipan.listaClientes[Cliente.Posicion].Apellidos;
    }

    private void AgregarMedicamentos() {
        boolean seguir;
        do {
            Helper.Escribir("Ingrese el Nombre del Medicamento que desea buscar");
            Medicamento.BuscarPorNombre(Helper.LeerCadena());
            if (Medicamento.Posicion > -1) {
                AgregaDetalle();
                Helper.EscribirJunto("Desea agregar otro medicamento? [S/N]");
                seguir = Helper.LeerCadena().toUpperCase().equals("S");
            } else {
                Helper.Escribir("No se encontró el medicamento");
                seguir = true;
            }
        } while (seguir);
    }

    private void AgregaDetalle() {
        // Buscamos una posicion disponible dentro de los Detalles.
        PosicionDisponible = -1;
        for (int i = 0; i < listaDetalles.length; i++) {
            if (listaDetalles[i] == null) {
                PosicionDisponible = i;
                break;
            }
        }

        Medicamento medicamentoEncontrado = BoticasSipan.listaMedicamentos[Medicamento.Posicion];

        if (Helper.CompararFecha(medicamentoEncontrado.FechaVencimiento)) {
            Helper.Escribir("Este medicamento se encuentra vencido!");
            return;
        }
        Helper.Escribir("Ingrese la cantidad a vender");
        int cantidad = Helper.LeerEntero();
        DetalleVenta detalle = new DetalleVenta(medicamentoEncontrado.Nombre,
                cantidad, medicamentoEncontrado.PrecioDisponible);
        // Almacenamos la posicion del medicamento, puesto que luego restaremos el Stock.
        detalle.PosicionMedicamento = Medicamento.Posicion;
        // Calculamos los Totales.
        detalle.CalcularTotales();

        // Agregamos el Detalle a la colección en la posición disponible.
        listaDetalles[PosicionDisponible] = detalle;
    }

    private void MostrarBoleta() {
        Helper.SeparadorDoble();
        Helper.Escribir("BOLETA DE VENTA");
        Helper.Separador();
        Helper.Escribir("Cliente:\t" + NombreCliente);
        Helper.Separador();
        Helper.Escribir("Fecha de Venta:\t" + Helper.LeerFecha(FechaVenta));
        Helper.Separador();
        Helper.Escribir("Medicamentos vendidos:");
        Helper.Separador();
        Helper.Escribir("Medicamento\tPrecio Unitario\tCantidad\tImporte");
        Helper.SeparadorDoble();
        for (DetalleVenta detalle : listaDetalles) {
            if (detalle != null) {
                Helper.Escribir(detalle.NombreMedicamento + "\t"
                        + detalle.PrecioUnitario + "\t"
                        + detalle.Cantidad + "\t"
                        + detalle.ImporteTotal);
            }
        }
        Helper.SeparadorDoble();
        Helper.Escribir("SubTotal:\t" + SubTotal);
        Helper.Escribir("IGV:\t" + Impuestos);
        Helper.Escribir("Total:\t" + Total);
    }

    private void ActualizarStockMedicamentos() {
        for (DetalleVenta detalle : listaDetalles) {
            if (detalle != null) {
                Medicamento seleccionado = BoticasSipan.listaMedicamentos[detalle.PosicionMedicamento];
                seleccionado.CantidadDisponible = seleccionado.CantidadDisponible - detalle.Cantidad;
            }
        }
    }

    private static void BuscarPosicionDisponible() {
        for (int i = 0; i < BoticasSipan.listaOperaciones.length; i++) {
            if (BoticasSipan.listaOperaciones[i] == null) {
                Posicion = i;
                break;
            }
        }
    }
}
