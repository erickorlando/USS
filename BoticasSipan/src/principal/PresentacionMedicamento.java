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
public class PresentacionMedicamento {

    public String Codigo;
    public String Descripcion;

    public static int Posicion;
    public static boolean limpiarPantalla = true;

    public PresentacionMedicamento() {

    }

    public PresentacionMedicamento(String codigo, String descripcion) {
        Codigo = codigo;
        Descripcion = descripcion;
    }

    private static void Agregar() {
        Helper.Escribir("Ingrese los datos de la Presentación");
        Helper.Separador();

        PresentacionMedicamento tipo = new PresentacionMedicamento();
        Helper.Escribir("Escriba el Código");
        tipo.Codigo = Helper.LeerCadena();
        Helper.Escribir("Escriba la Descripción");
        tipo.Descripcion = Helper.LeerCadena();
        BuscarPosicionDisponible();

        BoticasSipan.listaPresentaciones[Posicion] = tipo;
        Helper.Escribir("Se agregó correctamente la Presentación");
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void Actualizar() {
        Helper.Escribir("Ingrese el código a actualizar");
        String codigo = Helper.LeerCadena();
        BuscarPorCodigo(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró la Presentación " + codigo);
        } else {
            PresentacionMedicamento tipo = new PresentacionMedicamento();
            Helper.Escribir("Escriba la Descripción");
            tipo.Descripcion = Helper.LeerCadena();
            BoticasSipan.listaPresentaciones[Posicion] = tipo;
            Helper.Escribir("Se actualizó correctamente la Presentación");
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void Eliminar() {
        Helper.Escribir("Ingrese el código de la Presentación a eliminar");
        String codigo = Helper.LeerCadena();
        BuscarPorCodigo(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró la Presentación " + codigo);
        } else {
            Helper.EscribirJunto("Está seguro que desea eliminar? [S|N]");
            if (Helper.LeerCadena().toUpperCase().equals("S")) {
                BoticasSipan.listaPresentaciones[Posicion] = null;
                Helper.Escribir("Se eliminó la Presentación " + codigo);
            }
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    public static void BuscarPorCodigo(String codigo) {
        Posicion = -1;
        for (int i = 0; i < BoticasSipan.listaPresentaciones.length; i++) {
            if (!(BoticasSipan.listaPresentaciones[i] == null)) {

                if (codigo.toLowerCase().equals(BoticasSipan.listaPresentaciones[i].Codigo.toLowerCase())) {
                    Posicion = i;
                    break; // Se encontró el registro.
                }
            }
        }
    }

    private static void BuscarPosicionDisponible() {
        for (int i = 0; i < BoticasSipan.listaPresentaciones.length; i++) {
            if (BoticasSipan.listaTiposMedicamento[i] == null) {
                Posicion = i;
                break;
            }
        }
    }

    public static void Listar() {
        if (limpiarPantalla) {
            Helper.LimpiarPantalla();
        }
        Helper.Escribir("Lista de Formas de Presentación Registrados");
        Helper.Separador();
        Helper.Escribir("CODIGO    DESCRIPCION");
        Helper.Separador();

        String espacio;
        espacio = "    ";
        // Se usa bucle recomendado por NetBeans para iterar por
        // arrays de Objetos.
        for (PresentacionMedicamento tipo : BoticasSipan.listaPresentaciones) {
            if (!(tipo == null)) {
                Helper.Escribir(tipo.Codigo + espacio
                        + tipo.Descripcion);
            }
        }
        Helper.SeparadorDoble();
    }

    public static void ListarOpciones() {
        int Opcion;
        Helper.SeparadorDoble();
        Helper.Escribir("MENU ADMINISTRADOR DE FORMAS DE PRESENTACIONES");
        Helper.SeparadorDoble();
        Helper.Escribir("[1] Listar Presentaciones");
        Helper.Escribir("[2] Agregar Presentación");
        Helper.Escribir("[3] Actualizar Presentación");
        Helper.Escribir("[4] Eliminar Presentación");
        Helper.Escribir("[5] Regresar");
        Helper.EscribirJunto("Opción: ");
        Opcion = Helper.LeerEntero();

        switch (Opcion) {
            case 1:
                Listar();
                ListarOpciones();
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
