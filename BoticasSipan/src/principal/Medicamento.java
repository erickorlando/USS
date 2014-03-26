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
public class Medicamento {

    public String Codigo;
    public String TipoMedicamento;
    public String PresentacionMedicamento;
    public String Nombre;
    public String CompuestoQuimico;
    public int CantidadDisponible;
    public float PrecioDisponible;
    public Date FechaVencimiento;

    public static int Posicion;

    public Medicamento() {

    }

    public Medicamento(String codigo, String tipoMedicamento,
            String presentacion, String nombre, String compuesto,
            int cantidad, float precio, Date fechaVencimiento) {
        Codigo = codigo;
        TipoMedicamento = tipoMedicamento;
        PresentacionMedicamento = presentacion;
        Nombre = nombre;
        CompuestoQuimico = compuesto;
        CantidadDisponible = cantidad;
        PrecioDisponible = precio;
        FechaVencimiento = fechaVencimiento;
    }

    private static void Agregar() {
        Helper.Escribir("Ingrese los datos de la Presentación");
        Helper.Separador();

        Medicamento medicamento = new Medicamento();
        Helper.Escribir("Escriba el Código del Medicamento");
        medicamento.Codigo = Helper.LeerCadena();
        PedirDatos(medicamento);
        BuscarPosicionDisponible();

        BoticasSipan.listaMedicamentos[Posicion] = medicamento;
        Helper.Escribir("Se agregó correctamente la Presentación");
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void PedirDatos(Medicamento medicamento) {
        Helper.Escribir("Escriba El Tipo de Medicamento");
        Helper.Separador();
        medicamento.EscogerTipo();
        Helper.Escribir("Escriba la Presentacion");
        Helper.Separador();
        medicamento.EscogerPresentacion();
        Helper.Escribir("Escriba el Nombre del Medicamanto");
        medicamento.Nombre = Helper.LeerCadena();
        Helper.Escribir("Escriba el Compuesto Quimico");
        medicamento.CompuestoQuimico = Helper.LeerCadena();
        Helper.Escribir("Escriba la Cantidad Disponible");
        medicamento.CantidadDisponible = Helper.LeerEntero();
        Helper.Escribir("Escriba el Precio");
        medicamento.PrecioDisponible = Helper.LeerFloat();
        Helper.Escribir("Escriba la Fecha de Vencimiento (DD/MM/AAAA)");
        medicamento.FechaVencimiento = Helper.LeerFecha();
    }

    private void EscogerTipo() {
        principal.TipoMedicamento.limpiarPantalla = false;
        principal.TipoMedicamento.Listar();
        do {
            Helper.EscribirJunto("Seleccione un código: ");
            principal.TipoMedicamento.BuscarPorCodigo(Helper.LeerCadena());
        } while (principal.TipoMedicamento.Posicion < 0);

        if (principal.TipoMedicamento.Posicion < 0) {
            Helper.Escribir("Codigo de Tipo de Medicamento incorrecto, se escogerá el primero de la lista");
            principal.TipoMedicamento.Posicion = 0;
        }

        this.TipoMedicamento = BoticasSipan.listaTiposMedicamento[principal.TipoMedicamento.Posicion].Descripcion;

    }

    private void EscogerPresentacion() {
        principal.PresentacionMedicamento.limpiarPantalla = false;
        principal.PresentacionMedicamento.Listar();
        do {
            Helper.EscribirJunto("Seleccione un código: ");
            principal.PresentacionMedicamento.BuscarPorCodigo(Helper.LeerCadena());
        } while (principal.PresentacionMedicamento.Posicion < 0);
        
         if (principal.PresentacionMedicamento.Posicion < 0) {
            Helper.Escribir("Codigo de Presentacion de Medicamento incorrecto, se escogerá el primero de la lista");
            principal.PresentacionMedicamento.Posicion = 0;
        }

        this.PresentacionMedicamento = BoticasSipan.listaPresentaciones[principal.PresentacionMedicamento.Posicion].Descripcion;
    }

    private static void Actualizar() {
        Helper.Escribir("Ingrese el código a actualizar");
        String codigo = Helper.LeerCadena();
        BuscarPorCodigo(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró el Medicamento " + codigo);
        } else {
            Medicamento medicamento = new Medicamento();
            medicamento.Codigo = codigo;
            PedirDatos(medicamento);
            BoticasSipan.listaMedicamentos[Posicion] = medicamento;
            Helper.Escribir("Se actualizó correctamente el Medicamento");
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void Eliminar() {
        Helper.Escribir("Ingrese el código del Medicamento");
        String codigo = Helper.LeerCadena();
        BuscarPorCodigo(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró el Medicamento " + codigo);
        } else {
            Helper.EscribirJunto("Está seguro que desea eliminar? [S|N]");
            if (Helper.LeerCadena().toUpperCase().equals("S")) {
                BoticasSipan.listaMedicamentos[Posicion] = null;
                Helper.Escribir("Se eliminó el Medicamento " + codigo);
            }
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void BuscarPorCodigo(String codigo) {
        Posicion = -1;
        for (int i = 0; i < BoticasSipan.listaMedicamentos.length; i++) {
            if (!(BoticasSipan.listaMedicamentos[i] == null)) {

                if (codigo.toLowerCase().equals(BoticasSipan.listaMedicamentos[i].Codigo.toLowerCase())) {
                    Posicion = i;
                    break; // Se encontró el registro.
                }
            }
        }
    }

    private static void BuscarPosicionDisponible() {
        for (int i = 0; i < BoticasSipan.listaMedicamentos.length; i++) {
            if (BoticasSipan.listaMedicamentos[i] == null) {
                Posicion = i;
                break;
            }
        }
    }

    private static void Listar() {
        Helper.LimpiarPantalla();
        Helper.Escribir("Lista de Medicamentos Registrados");
        Helper.Separador();
        Helper.Escribir("CODIGO    TIPO    PRESENTACION     NOMBRE     COMPUESTO QUIMICO     CANTIDAD     PRECIO     FECHA VENCIMIENTO");
        Helper.Separador();

        String espacio;
        espacio = "    ";
        // Se usa bucle recomendado por NetBeans para iterar por
        // arrays de Objetos.
        for (Medicamento medicamento : BoticasSipan.listaMedicamentos) {
            if (!(medicamento == null)) {
                Helper.Escribir(medicamento.Codigo + espacio
                        + medicamento.TipoMedicamento + espacio
                        + medicamento.PresentacionMedicamento + espacio
                        + medicamento.Nombre + espacio
                        + medicamento.CompuestoQuimico + espacio
                        + medicamento.CantidadDisponible + espacio
                        + medicamento.PrecioDisponible + espacio
                        + Helper.LeerFecha(medicamento.FechaVencimiento));
            }
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    public static void ListarOpciones() {
        int Opcion;
        Helper.SeparadorDoble();
        Helper.Escribir("MENU ADMINISTRADOR DE MEDICAMENTOS");
        Helper.SeparadorDoble();
        Helper.Escribir("[1] Listar Medicamentos");
        Helper.Escribir("[2] Agregar Medicamento");
        Helper.Escribir("[3] Actualizar Medicamento");
        Helper.Escribir("[4] Eliminar Medicamento");
        Helper.Escribir("[5] Regresar");
        Helper.EscribirJunto("Opción: ");
        Opcion = Helper.LeerEntero();

        switch (Opcion) {
            case 1:
                Listar();
                break;
            case 2:
                Agregar();
                break;
            case 3:
                Actualizar();
                break;
            case 4:
                Eliminar();
                break;
            default:
                BoticasSipan.MenuOpciones();
                break;
        }
    }
}
