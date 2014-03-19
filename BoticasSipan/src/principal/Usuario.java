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
        }
 }