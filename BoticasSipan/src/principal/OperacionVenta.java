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
public class OperacionVenta {

    public String NombreCliente;
    public Date FechaVenta;
    public float SubTotal;
    public float Impuestos;
    public float Total;
    public String UsuarioRegistrador;
    public DetalleVenta listaDetalles[] = new DetalleVenta[50];

    public static void AgregarOperacion() {
        Helper.SeparadorDoble();
        Helper.Escribir("Registro de Operación de Venta");
        Helper.SeparadorDoble();
        
        OperacionVenta venta = new OperacionVenta();
        Helper.Escribir("Escriba el DNI del Cliente");
        venta.BuscarClientePorCodigo();
        Helper.Escribir("Ingresar los medicamentos a vender");
    }

    private void BuscarClientePorCodigo() {
        // Realizar la busqueda de Cliente por DNI
        // En caso no exista se creará.
        Cliente.BuscarPorCodigo(Helper.LeerCadena());
        if (Cliente.Posicion > -1)
        {
            NombreCliente = BoticasSipan.listaClientes[Cliente.Posicion].Nombres 
                    + " " 
                    + BoticasSipan.listaClientes[Cliente.Posicion].Apellidos;
        }
        else
        {
            Helper.Escribir("No se encontró el DNI, se procederá a crear el Cliente");
            Helper.Separador();
            Cliente.Agregar();
        }
    }
}
