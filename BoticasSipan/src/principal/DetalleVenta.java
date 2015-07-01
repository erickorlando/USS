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
public class DetalleVenta {

    public String NombreMedicamento;
    public int Cantidad;
    public float PrecioUnitario;
    public float ImporteTotal;
    
    public int PosicionMedicamento;
    
    public DetalleVenta()
    {
        
    }
    
    public DetalleVenta(String medicamento, int cantidad, float precioUnitario)
    {
        NombreMedicamento = medicamento;
        Cantidad= cantidad;
        PrecioUnitario = precioUnitario;
    }
    
    public void CalcularTotales()
    {
        ImporteTotal = Cantidad * PrecioUnitario;
    }
}
