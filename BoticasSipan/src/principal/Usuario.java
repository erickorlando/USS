package principal;

/**
 *
 * @author Equipo de Trabajo N° 1
 */
public class Usuario {

    public String codigoUsuario;
    public String Nombres;
    public String Apellidos;
    public String Clave;
    public String DNI;

    private static int Posicion;

    public Usuario() {
    }

    public Usuario(String codigo, String nombres, String apellidos, String clave, String dni) {
        codigoUsuario = codigo;
        Nombres = nombres;
        Apellidos = apellidos;
        Clave = clave;
        DNI = dni;
    }

    public static void AgregarUsuario() {
        Helper.Escribir("Ingrese los datos del Usuario");
        Helper.Separador();

        Usuario usuario = new Usuario();

        PedirDatos(usuario);

        BuscarPosicionDisponible();

        BoticasSipan.listaUsuarios[Posicion] = usuario;
        Helper.Escribir("Se agregó correctamente el usuario");
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void PedirDatos(Usuario usuario) {
        Helper.Escribir("Escriba el Código de Usuario");
        usuario.codigoUsuario = Helper.LeerCadena();
        Helper.Escribir("Escriba los Nombres");
        usuario.Nombres = Helper.LeerCadena();
        Helper.Escribir("Escriba los Apellidos");
        usuario.Apellidos = Helper.LeerCadena();
        Helper.Escribir("Escriba el DNI");
        usuario.DNI = Helper.LeerCadena();
        Helper.Escribir("Escriba la clave");
        usuario.Clave = Helper.LeerCadena();
    }

    private static void ActualizarUsuario() {
        Helper.Escribir("Ingrese el código de Usuario a actualizar");
        String codigo = Helper.LeerCadena();
        BuscarUsuario(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró el usuario " + codigo);
        } else {
            Usuario usuario = new Usuario();
            PedirDatos(usuario);
            BoticasSipan.listaUsuarios[Posicion] = usuario;
            Helper.Escribir("Se actualizó correctamente el usuario");
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void EliminarUsuario() {
        Helper.Escribir("Ingrese el código de Usuario a eliminar");
        String codigo = Helper.LeerCadena();
        BuscarUsuario(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró el usuario " + codigo);
        } else {
            Helper.EscribirJunto("Está seguro que desea eliminar? [S|N]");
            if (Helper.LeerCadena().toUpperCase().equals("S")) {
                BoticasSipan.listaUsuarios[Posicion] = null;
                Helper.Escribir("Se eliminó el usuario " + codigo);
            }
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void BuscarUsuario(String codigo) {
        Posicion = -1;
        for (int i = 0; i < BoticasSipan.listaUsuarios.length; i++) {
            if (!(BoticasSipan.listaUsuarios[i] == null)) {

                if (codigo.toLowerCase().equals(BoticasSipan.listaUsuarios[i].codigoUsuario.toLowerCase())) {
                    Posicion = i;
                    break; // Se encontró el registro.
                }
            }
        }
    }

    private static void BuscarPosicionDisponible() {
        for (int i = 0; i < BoticasSipan.listaUsuarios.length; i++) {
            if (BoticasSipan.listaUsuarios[i] == null) {
                Posicion = i;
                break;
            }
        }
    }

    private static void ListarUsuarios() {
        Helper.LimpiarPantalla();
        Helper.Escribir("Lista de Usuarios Registrados");
        Helper.Separador();
        Helper.Escribir("CODIGO    NOMBRES    APELLIDOS    DNI");
        Helper.Separador();

        String espacio;
        espacio = "    ";
        // Se usa bucle recomendado por NetBeans para iterar por
        // arrays de Objetos.
        for (Usuario usuario : BoticasSipan.listaUsuarios) {
            if (!(usuario == null)) {
                Helper.Escribir(usuario.codigoUsuario + espacio
                        + usuario.Nombres + espacio
                        + usuario.Apellidos + espacio
                        + usuario.DNI);
            }
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    public static void ListarOpciones() {
        int Opcion;
        Helper.SeparadorDoble();
        Helper.Escribir("MENU ADMINISTRADOR DE USUARIOS");
        Helper.SeparadorDoble();
        Helper.Escribir("[1] Listar Usuarios");
        Helper.Escribir("[2] Agregar Usuario");
        Helper.Escribir("[3] Actualizar Usuario");
        Helper.Escribir("[4] Eliminar Usuario");
        Helper.Escribir("[5] Regresar");
        Helper.EscribirJunto("Opción: ");
        Opcion = Helper.LeerEntero();

        switch (Opcion) {
            case 1:
                ListarUsuarios();
                break;
            case 2:
                AgregarUsuario();
                break;
            case 3:
                ActualizarUsuario();
                break;
            case 4:
                EliminarUsuario();
                break;
            default:
                BoticasSipan.MenuOpciones();
                break;
        }
    }
}
