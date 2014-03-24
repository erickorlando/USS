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

    static int Intentos = 0;
    public static Usuario listaUsuarios[] = new Usuario[20];
    public static Medicamento listaMedicamentos[] = new Medicamento[20];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CargaInicial();
        Helper.LimpiarPantalla();
        Login();
    }

    public static void MenuOpciones() {
        int Opcion;
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
        Helper.Escribir("[12] Cerrar Sesión.");
        Helper.Escribir("[13] Salir.");
        Helper.Escribir("****************************************************");
        Helper.EscribirJunto("Opcion: ");

        Opcion = Helper.LeerEntero();

        switch (Opcion) {
            case 1:
                Usuario.ListarOpciones();
                break;
            case 12:
                Login();
                break;
            default:
                break;
        }
    }

    public static void CargaInicial() {
        Usuario objUsuario = new Usuario("SUPERUSUARIO", "Super", "Usuario", "SUPERUSUARIO", "12345678");
        listaUsuarios[0] = objUsuario;
    }

    public static void Login() {
        String usuario, clave;
        Usuario usuarioEncontrado = null;
        

        Helper.Escribir("Para utilizar el Sistema Ud. debe ingresar su usuario y clave");
        Helper.SeparadorDoble();
        Helper.Escribir("Ingrese su usuario:");
        usuario = Helper.LeerCadena();
        Helper.Escribir("Ingrese su clave:");
        clave = Helper.LeerCadena();
        for (Usuario user : listaUsuarios) {
            if (user != null) {
                if (user.codigoUsuario.toUpperCase().equals(usuario.toUpperCase())
                        && user.Clave.toUpperCase().equals(clave.toUpperCase())) {
                    usuarioEncontrado = user;
                    break;
                }
            }
        }

        if (usuarioEncontrado != null) {
            Helper.Escribir("Bienvenido al Sistema "
                    + usuarioEncontrado.Nombres + " "
                    + usuarioEncontrado.Apellidos);
            Intentos = 0;
            MenuOpciones();
        } else {
            Intentos++;
            Helper.LimpiarPantalla();
            Helper.Escribir("Ud. no está autorizado a usar el Sistema");
            Helper.SeparadorDoble();
            if (Intentos > 2) {
                Helper.Escribir("Máximo número de intentos alcanzados. Error de Seguridad");
            } else {
                Login();
            }
        }
    }

}
