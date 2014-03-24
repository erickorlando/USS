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
public class TipoMedicamento {

    public String Codigo;
    public String Descripcion;

    public static int Posicion;

    public TipoMedicamento() {

    }

    public TipoMedicamento(String codigo, String descripcion) {
        Codigo = codigo;
        Descripcion = descripcion;
    }

    private static void Agregar() {
        Helper.Escribir("Ingrese los datos del Tipo de Medicamento");
        Helper.Separador();

        TipoMedicamento tipo = new TipoMedicamento();
        Helper.Escribir("Escriba el Código");
        tipo.Codigo = Helper.LeerCadena();
        Helper.Escribir("Escriba la Descripción");
        tipo.Descripcion = Helper.LeerCadena();
        BuscarPosicionDisponible();

        BoticasSipan.listaTiposMedicamento[Posicion] = tipo;
        Helper.Escribir("Se agregó correctamente el Tipo de Medicamento");
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void Actualizar() {
        Helper.Escribir("Ingrese el código a actualizar");
        String codigo = Helper.LeerCadena();
        BuscarPorCodigo(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró el Tipo de Medicamento " + codigo);
        } else {
            TipoMedicamento tipo = new TipoMedicamento();
            Helper.Escribir("Escriba la Descripción");
            tipo.Descripcion = Helper.LeerCadena();
            BoticasSipan.listaTiposMedicamento[Posicion] = tipo;
            Helper.Escribir("Se actualizó correctamente el Tipo de Medicamento");
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void Eliminar() {
        Helper.Escribir("Ingrese el código de Tipo de Medicamento a eliminar");
        String codigo = Helper.LeerCadena();
        BuscarPorCodigo(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró el Tipo de Medicamento " + codigo);
        } else {
            Helper.EscribirJunto("Está seguro que desea eliminar? [S|N]");
            if (Helper.LeerCadena().toUpperCase().equals("S")) {
                BoticasSipan.listaTiposMedicamento[Posicion] = null;
                Helper.Escribir("Se eliminó el Tipo de Medicamento " + codigo);
            }
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void BuscarPorCodigo(String codigo) {
        Posicion = -1;
        for (int i = 0; i < BoticasSipan.listaTiposMedicamento.length; i++) {
            if (!(BoticasSipan.listaTiposMedicamento[i] == null)) {

                if (codigo.toLowerCase().equals(BoticasSipan.listaTiposMedicamento[i].Codigo.toLowerCase())) {
                    Posicion = i;
                    break; // Se encontró el registro.
                }
            }
        }
    }

    private static void BuscarPosicionDisponible() {
        for (int i = 0; i < BoticasSipan.listaTiposMedicamento.length; i++) {
            if (BoticasSipan.listaTiposMedicamento[i] == null) {
                Posicion = i;
                break;
            }
        }
    }

    private static void Listar() {
        Helper.LimpiarPantalla();
        Helper.Escribir("Lista de Tipos de Medicamento Registrados");
        Helper.Separador();
        Helper.Escribir("CODIGO    DESCRIPCION");
        Helper.Separador();

        String espacio;
        espacio = "    ";
        // Se usa bucle recomendado por NetBeans para iterar por
        // arrays de Objetos.
        for (TipoMedicamento tipo : BoticasSipan.listaTiposMedicamento) {
            if (!(tipo == null)) {
                Helper.Escribir(tipo.Codigo + espacio
                        + tipo.Descripcion);
            }
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    public static void ListarOpciones() {
        int Opcion;
        Helper.SeparadorDoble();
        Helper.Escribir("MENU ADMINISTRADOR DE TIPOS DE MEDICAMENTOS");
        Helper.SeparadorDoble();
        Helper.Escribir("[1] Listar Tipos de Medicamento");
        Helper.Escribir("[2] Agregar Tipo de Medicamento");
        Helper.Escribir("[3] Actualizar Tipo de Medicamento");
        Helper.Escribir("[4] Eliminar Tipo de Medicamento");
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
