/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Date;

/**
 *
 * @author Equipo de Trabajo N° 1
 */
public class BoticasSipan {

    static int Intentos = 0;
    public static String UsuarioLogueado;
    public static Usuario listaUsuarios[] = new Usuario[20];
    public static Medicamento listaMedicamentos[] = new Medicamento[20];
    public static TipoMedicamento listaTiposMedicamento[] = new TipoMedicamento[20];
    public static PresentacionMedicamento listaPresentaciones[] = new PresentacionMedicamento[20];
    public static Cliente listaClientes[] = new Cliente[20];
    public static OperacionVenta listaOperaciones[] = new OperacionVenta[20];

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
            case 2:
                TipoMedicamento.limpiarPantalla = true;
                TipoMedicamento.ListarOpciones();
                break;
            case 3:
                PresentacionMedicamento.limpiarPantalla = true;
                PresentacionMedicamento.ListarOpciones();
                break;
            case 4:
                Medicamento.ListarOpciones();
                break;
            case 5:
                Cliente.ListarOpciones();
                break;
            case 6:
                OperacionVenta.AgregarOperacion();
                break;
            case 7:
                Reporte.ReporteCaja();
                break;
            case 8:
                Reporte.ReporteClientes();
                break;
            case 12:
                Login();
                break;
            default:
                break;
        }
    }

    public static void CargaInicial() {
        listaUsuarios[0] = new Usuario("SUPERUSUARIO", "Super", "Usuario", "SUPERUSUARIO", "12345678");
        listaUsuarios[1] = new Usuario("pepito", "Jose Manuel", "Santos Chocano", "pepito", "09846812");
        listaUsuarios[2] = new Usuario("fulano", "Fulano", "de Tal", "fulano", "65141682");
        listaUsuarios[3] = new Usuario("mengano", "Mengano", "Sutano", "mengano", "41859670");

        listaTiposMedicamento[0] = new TipoMedicamento("001", "Antipirético");
        listaTiposMedicamento[1] = new TipoMedicamento("002", "Antifúngico");
        listaTiposMedicamento[2] = new TipoMedicamento("003", "Analgésico");
        listaTiposMedicamento[3] = new TipoMedicamento("004", "Antibiótico");
        listaTiposMedicamento[4] = new TipoMedicamento("005", "Vacunas");
        listaTiposMedicamento[5] = new TipoMedicamento("006", "Antisépticos");
        listaTiposMedicamento[6] = new TipoMedicamento("007", "Antinflamatorio");
        listaTiposMedicamento[7] = new TipoMedicamento("008", "Antihistamínico");
        listaTiposMedicamento[8] = new TipoMedicamento("009", "Anestésico");
        listaTiposMedicamento[9] = new TipoMedicamento("010", "Antidepresivo");
        listaTiposMedicamento[10] = new TipoMedicamento("011", "Diurético");
        listaTiposMedicamento[11] = new TipoMedicamento("012", "Laxante");
        listaTiposMedicamento[12] = new TipoMedicamento("013", "Broncodilatador.");
        listaTiposMedicamento[13] = new TipoMedicamento("014", "Multivitamínico.");

        listaPresentaciones[0] = new PresentacionMedicamento("001", "Pastilla");
        listaPresentaciones[1] = new PresentacionMedicamento("002", "Capsula");
        listaPresentaciones[2] = new PresentacionMedicamento("003", "Polvo");
        listaPresentaciones[3] = new PresentacionMedicamento("004", "Granulado");
        listaPresentaciones[4] = new PresentacionMedicamento("005", "Trocisco");
        listaPresentaciones[5] = new PresentacionMedicamento("006", "Preparados");
        listaPresentaciones[6] = new PresentacionMedicamento("007", "Crema");
        listaPresentaciones[7] = new PresentacionMedicamento("008", "Emplasto");
        listaPresentaciones[8] = new PresentacionMedicamento("009", "Linimentos");
        listaPresentaciones[9] = new PresentacionMedicamento("010", "Suspensión");
        listaPresentaciones[10] = new PresentacionMedicamento("011", "Soluciones");
        listaPresentaciones[11] = new PresentacionMedicamento("012", "Lociones");
        listaPresentaciones[12] = new PresentacionMedicamento("013", "Inhalaciones");
        listaPresentaciones[13] = new PresentacionMedicamento("014", "Jarabes");
        listaPresentaciones[14] = new PresentacionMedicamento("015", "Ampolla");
        listaPresentaciones[15] = new PresentacionMedicamento("016", "Tintura");
        listaPresentaciones[16] = new PresentacionMedicamento("017", "Mucílago");

        listaMedicamentos[0] = new Medicamento("0001", "Broncodilatador", "Inhalaciones", "Bentolin", "Salbutamol", 20, 9.5f, "15/01/2015");
        listaMedicamentos[1] = new Medicamento("0002", "Analgésico", "Pastilla", "Panadol", "Paracetamol", 20, 1.2f, "29/03/2014");
        listaMedicamentos[2] = new Medicamento("0003", "Antinflamatorio", "Pastilla", "Amoxil", "Amoxicilina", 20, 0.5f, "16/04/2014");
        listaMedicamentos[3] = new Medicamento("0004", "Antihistamínico", "Pastilla", "Nastizol", "Clorfeniramina", 20, 1f, "21/02/2014");
        listaMedicamentos[4] = new Medicamento("0005", "Laxante", "Jarabes", "Limonada Markos", "Emuliken", 20, 16.2f, "15/12/2015");
        listaMedicamentos[5] = new Medicamento("0006", "Multivitamínico", "Polvo", "Ensure", "Maltodextrina", 20, 99.9f, "7/04/2014");

        listaClientes[0] = new Cliente("12345678", "Juan", "Pérez", 990);
        listaClientes[1] = new Cliente("87654321", "Miguel", "Coloma Huapaya", 1420);
        listaClientes[2] = new Cliente("43153894", "Erick Orlando", "Velasco Martinez", 1420);
        listaClientes[3] = new Cliente("07812345", "Jhon", "Chumpitazi Fuñoli", 7434);
        listaClientes[4] = new Cliente("06954321", "Vives Garnique", "Luis Alberto", 726);

        OperacionVenta operacion = new OperacionVenta();
        operacion.FechaVenta = new Date();
        operacion.NombreCliente = "Juan Pérez";
        operacion.UsuarioRegistrador = "SUPERUSUARIO";
        DetalleVenta detalle = new DetalleVenta("Bentolin", 5, 9.5f);
        detalle.CalcularTotales();
        operacion.listaDetalles[0] = detalle;
        detalle = new DetalleVenta("Limonada Markos", 2, 16.2f);
        detalle.CalcularTotales();
        operacion.listaDetalles[1] = detalle;
        operacion.CalcularTotales();

        listaOperaciones[0] = operacion;

        operacion = new OperacionVenta();
        operacion.FechaVenta = new Date();
        operacion.NombreCliente = "Erick Orlando Velasco Martinez";
        operacion.UsuarioRegistrador = "SUPERUSUARIO";
        detalle = new DetalleVenta("Bentolin", 2, 9.5f);
        detalle.CalcularTotales();
        operacion.listaDetalles[0] = detalle;
        detalle = new DetalleVenta("Limonada Markos", 1, 16.2f);
        detalle.CalcularTotales();
        operacion.listaDetalles[1] = detalle;
        detalle = new DetalleVenta("Ensure", 3, 99.9f);
        detalle.CalcularTotales();
        operacion.listaDetalles[2] = detalle;
        operacion.CalcularTotales();

        listaOperaciones[1] = operacion;
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
                if (user.CodigoUsuario.toUpperCase().equals(usuario.toUpperCase())
                        && user.Clave.toUpperCase().equals(clave.toUpperCase())) {
                    usuarioEncontrado = user;
                    break;
                }
            }
        }

        if (usuarioEncontrado != null) {
            UsuarioLogueado = usuarioEncontrado.Nombres + " "
                    + usuarioEncontrado.Apellidos;
            Helper.Escribir("Bienvenido al Sistema " + UsuarioLogueado);
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
