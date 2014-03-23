package principal;

/**
 *
 * @author Equipo de Trabajo N° 1
 */
 public class Usuario
 {
	public String codigoUsuario;
	public String Nombres;
        public String Apellidos;
	public String Clave;
        public String DNI;
        
        
        public static void AgregarUsuario()
        {
            Helper.Escribir("Ingrese los datos del Usuario");
            
            Usuario usuario = new Usuario();
            Helper.Escribir("Escriba los Nombres");
            usuario.Nombres = Helper.LeerCadena();
            Helper.Escribir("Escriba los Apellidos");
            usuario.Apellidos = Helper.LeerCadena();
            Helper.Escribir("Escriba el DNI");
            usuario.DNI = Helper.LeerCadena();
            Helper.Escribir("Escriba la clave");
            usuario.Clave = Helper.LeerCadena();
            
            int posicionDisponible = 0;
            // Empezamos a buscar una posición disponible.
            for (int i = 0; i < BoticasSipan.listaUsuarios.length; i++)
            {
                if (BoticasSipan.listaUsuarios[i] == null)
                    posicionDisponible = i; break;
            }
            BoticasSipan.listaUsuarios[posicionDisponible] = usuario;
            
            Helper.Escribir("Se agregó correctamente el usuario");
        }
        
        public static void ListarUsuarios()
        {
            
        }
 }