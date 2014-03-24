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
public class Cliente {
    
    public String DNI;
    public String Nombres;
    public String Apellidos;
    public int PuntosBono;
    
    public static int Posicion;
    
    public Cliente()
    {
        
    }
    
    public Cliente(String dni, String nombres, String apellidos, int puntos)
    {
        DNI = dni;
        Nombres = nombres;
        Apellidos = apellidos;
        PuntosBono = puntos; 
    }
    
    private static void Agregar() {
        Helper.Escribir("Ingrese los datos del Cliente");
        Helper.Separador();

        Cliente cliente = new Cliente();
        Helper.Escribir("Escriba el DNI");
        cliente.DNI = Helper.LeerCadena();
        PedirDatos(cliente);
        BuscarPosicionDisponible();

        BoticasSipan.listaClientes[Posicion] = cliente;
        Helper.Escribir("Se agregó correctamente el Cliente");
        Helper.SeparadorDoble();
        ListarOpciones();
    }
    
    private static void PedirDatos(Cliente cliente)
    {
        Helper.Escribir("Escriba los Apellidos");
        cliente.Apellidos = Helper.LeerCadena();
        Helper.Escribir("Escriba los Nombres");
        cliente.Nombres = Helper.LeerCadena();
    }

    private static void Actualizar() {
        Helper.Escribir("Ingrese el DNI a actualizar");
        String codigo = Helper.LeerCadena();
        BuscarPorCodigo(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró el Cliente con DNI " + codigo);
        } else {
            Cliente cliente = new Cliente();
            PedirDatos(cliente);
            BoticasSipan.listaClientes[Posicion] = cliente;
            Helper.Escribir("Se actualizó correctamente el Cliente");
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void Eliminar() {
        Helper.Escribir("Ingrese el DNI del Cliente");
        String codigo = Helper.LeerCadena();
        BuscarPorCodigo(codigo);
        if (Posicion == -1) {
            Helper.Escribir("No se encontró el Cliente " + codigo);
        } else {
            Helper.EscribirJunto("Está seguro que desea eliminar? [S|N]");
            if (Helper.LeerCadena().toUpperCase().equals("S")) {
                BoticasSipan.listaClientes[Posicion] = null;
                Helper.Escribir("Se eliminó el Cliente " + codigo);
            }
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    private static void BuscarPorCodigo(String codigo) {
        Posicion = -1;
        for (int i = 0; i < BoticasSipan.listaClientes.length; i++) {
            if (!(BoticasSipan.listaClientes[i] == null)) {

                if (codigo.toLowerCase().equals(BoticasSipan.listaClientes[i].DNI.toLowerCase())) {
                    Posicion = i;
                    break; // Se encontró el registro.
                }
            }
        }
    }

    private static void BuscarPosicionDisponible() {
        for (int i = 0; i < BoticasSipan.listaClientes.length; i++) {
            if (BoticasSipan.listaClientes[i] == null) {
                Posicion = i;
                break;
            }
        }
    }

    private static void Listar() {
        Helper.LimpiarPantalla();
        Helper.Escribir("Lista de Clientes Registrados");
        Helper.Separador();
        Helper.Escribir("DNI    APELLIDOS    NOMBRES    PUNTOS BONO");
        Helper.Separador();

        String espacio;
        espacio = "    ";
        // Se usa bucle recomendado por NetBeans para iterar por
        // arrays de Objetos.
        for (Cliente cliente : BoticasSipan.listaClientes) {
            if (!(cliente == null)) {
                Helper.Escribir(cliente.DNI + espacio
                        + cliente.Apellidos + espacio
                        + cliente.Nombres + espacio
                        + cliente.PuntosBono);
            }
        }
        Helper.SeparadorDoble();
        ListarOpciones();
    }

    public static void ListarOpciones() {
        int Opcion;
        Helper.SeparadorDoble();
        Helper.Escribir("MENU ADMINISTRADOR DE CLIENTES");
        Helper.SeparadorDoble();
        Helper.Escribir("[1] Listar Clientes");
        Helper.Escribir("[2] Agregar Cliente");
        Helper.Escribir("[3] Actualizar Cliente");
        Helper.Escribir("[4] Eliminar Cliente");
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
