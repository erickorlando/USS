/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Equipo de Trabajo N° 1
 */
public class BoticasSipan {

    public static Usuario listaUsuarios[] = new Usuario[20];
    public static Medicamento listaMedicamentos[] = new Medicamento[20];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuOpciones();
    }

    public static void MenuOpciones() {
        int Opcion = 0;
        Helper.Escribir("SISTEMA DE FARMACIA");
        Helper.Escribir("+=================================+");
        Helper.Escribir("******** MENU DE OPCIONES *******");
        Helper.Escribir("[1] Administrar Usuarios del sistema ");
        Helper.Escribir("[2] Administrar tipos de medicamentos ");
        Helper.Escribir("[3] Administrar formas de presentación de medicamentos");
        Helper.Escribir("[4] Administrar medicamentos. ");
        Helper.Escribir("[5] Administrar datos de cliente. ");
        Helper.Escribir("[6] Operaciones de venta ");
        Helper.Escribir("[7] Reporte: Caja ");
        Helper.Escribir("[8] Reporte: Clientes ");
        Helper.Escribir("[9] Reporte: Compras ");
        Helper.Escribir("[10] Reporte: Venta de usuario ");
        Helper.Escribir("[11] Reporte: Ranking de ventas. ");
        Helper.Escribir("[12] Salir.");
        Helper.Escribir("****************************************************");
        System.out.print("Opción: ");
        
        Opcion = Helper.LeerEntero();
        
        switch(Opcion)
        {
            case 0: 
                Usuario.AgregarUsuario();
                break;
            default:
                break;
        }
    }

}
