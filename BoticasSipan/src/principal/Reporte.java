/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Erick Orlando
 */
public class Reporte {

    public static void ReporteCaja() {
        Helper.Escribir("Ingrese una fecha para emitir el Reporte");
        java.util.Date fecha = Helper.LeerFecha(Helper.LeerCadena());

        Helper.SeparadorDoble();
        Helper.Escribir(String.format("Reporte de Ventas del: %s \tUsuario: %s",
                Helper.LeerFecha(fecha), BoticasSipan.UsuarioLogueado));
        Helper.SeparadorDoble();
        Helper.Escribir("Medicamento\t\tMonto Recaudado");
        Helper.Separador();

        String[][] lstMedicamentos = new String[100][2];
        int contador = 0;

        for (Medicamento medicamento : BoticasSipan.listaMedicamentos) {
            if (medicamento != null) {
                for (OperacionVenta venta : BoticasSipan.listaOperaciones) {
                    if (venta != null && Helper.LeerFecha(venta.FechaVenta).equalsIgnoreCase(Helper.LeerFecha(fecha))) {
                        for (DetalleVenta detalle : venta.listaDetalles) {
                            if (detalle != null) {
                                if (medicamento.Nombre.equalsIgnoreCase(detalle.NombreMedicamento)) {
                                    if (lstMedicamentos[contador][0] == null) {
                                        lstMedicamentos[contador][0] = medicamento.Nombre;
                                        lstMedicamentos[contador][1] = Float.toString(detalle.ImporteTotal);
                                    } else {
                                        if (lstMedicamentos[contador][0].equalsIgnoreCase(medicamento.Nombre)) {
                                            float valor = Float.parseFloat(lstMedicamentos[contador][1]);
                                            lstMedicamentos[contador][1] = Float.toString(valor + detalle.ImporteTotal);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            contador = contador + 1;
        }

        // Ahora recorremos la lista de los medicamentos acumulados.
        float sumatoriaTotal = 0;
        for (String[] medicamento : lstMedicamentos) {
            if (medicamento[0] != null) {
                Helper.Escribir(String.format("%s\t\t\tS/.%s", medicamento[0], medicamento[1]));
                // Vamos acumulando el total.
                sumatoriaTotal = sumatoriaTotal + Float.parseFloat(medicamento[1]);
            }
        }
        Helper.Separador();
        Helper.Escribir(String.format("Total S/. %f", sumatoriaTotal));
        Helper.SeparadorDoble();
        Helper.EscribirJunto("Desea volver al menú principal? [S/N]");
        if (Helper.LeerCadena().equalsIgnoreCase("s")) {
            BoticasSipan.MenuOpciones();
        }
    }

    public static void ReporteClientes() {
        Helper.Escribir("Ingrese el DNI del cliente para emitir el Reporte");
        Cliente.BuscarPorCodigo(Helper.LeerCadena());
        Cliente clienteSeleccionado;
        String NombreCliente;
        if (Cliente.Posicion > -1) {
            clienteSeleccionado = BoticasSipan.listaClientes[Cliente.Posicion];
            NombreCliente = String.format("%s %s", clienteSeleccionado.Nombres, clienteSeleccionado.Apellidos);
        } else {
            Helper.Escribir("No se encontró el DNI del Cliente.");
            return;
        }
        Helper.SeparadorDoble();
        Helper.Escribir(String.format("Reporte de Compras\tCliente: %s\tUsuario:%s",
                NombreCliente, BoticasSipan.UsuarioLogueado));
        Helper.Escribir(String.format("Puntos Bono: %d. Equivalencia Monetaria: %f Soles",
                clienteSeleccionado.PuntosBono, (float) (clienteSeleccionado.PuntosBono / 100)));
        Helper.Separador();
        Helper.Escribir("Medicamento\tCantidad\tMonto Recaudado\tFecha");
        Helper.Separador();
        String[][] lstMedicamentos = new String[100][4];
        int contador = 0;

        for (Medicamento medicamento : BoticasSipan.listaMedicamentos) {
            if (medicamento != null) {
                for (OperacionVenta venta : BoticasSipan.listaOperaciones) {
                    if (venta != null && venta.NombreCliente.equalsIgnoreCase(NombreCliente)) {
                        for (DetalleVenta detalle : venta.listaDetalles) {
                            if (detalle != null) {
                                if (medicamento.Nombre.equalsIgnoreCase(detalle.NombreMedicamento)) {
                                    if (lstMedicamentos[contador][0] == null) {
                                        lstMedicamentos[contador][0] = medicamento.Nombre;
                                        lstMedicamentos[contador][1] = Integer.toString(detalle.Cantidad);
                                        lstMedicamentos[contador][2] = Float.toString(detalle.ImporteTotal);
                                        lstMedicamentos[contador][3] = Helper.LeerFecha(venta.FechaVenta);
                                    } else {
                                        if (lstMedicamentos[contador][0].equalsIgnoreCase(medicamento.Nombre)) {
                                            int cantidad = Integer.parseInt(lstMedicamentos[contador][1]);
                                            float valor = Float.parseFloat(lstMedicamentos[contador][2]);
                                            lstMedicamentos[contador][1] = Integer.toString(cantidad + detalle.Cantidad);
                                            lstMedicamentos[contador][2] = Float.toString(valor + detalle.ImporteTotal);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            contador = contador + 1;
        }

        // Realizamos la sumatoria.
        float sumatoriaTotal = 0;
        for (String[] medicamento : lstMedicamentos) {
            if (medicamento[0] != null) {
                Helper.Escribir(String.format("%s\t%s\tS/.%s\t%s",
                        medicamento[0],
                        medicamento[1],
                        medicamento[2],
                        medicamento[3]));
                // Vamos acumulando el total.
                sumatoriaTotal = sumatoriaTotal + Float.parseFloat(medicamento[2]);
            }
        }
        Helper.Separador();
        Helper.Escribir(String.format("Total \t\tS/. %f", sumatoriaTotal));
        Helper.SeparadorDoble();
        Helper.EscribirJunto("Desea volver al menú principal? [S/N]");
        if (Helper.LeerCadena().equalsIgnoreCase("s")) {
            BoticasSipan.MenuOpciones();
        }
    }
}
