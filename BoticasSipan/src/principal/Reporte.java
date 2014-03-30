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
public class Reporte {
    
    
   public static void ReporteCaja() {
        Helper.Escribir("Ingrese una fecha para emitir el Reporte");
        java.util.Date fecha = Helper.LeerFecha(Helper.LeerCadena());

        Helper.SeparadorDoble();
        Helper.EscribirJunto("Reporte de Ventas del: " + Helper.LeerFecha(fecha));
        Helper.EscribirJunto("Usuario: " + BoticasSipan.UsuarioLogueado);
        Helper.Escribir("");
        Helper.SeparadorDoble();
        Helper.Escribir("Medicamento\t\tMonto Recaudado");
        Helper.Separador();
        String medicamento[] = new String[100];
        
        float montoRecaudado = 0;
        int contador=0;
        for (OperacionVenta venta : BoticasSipan.listaOperaciones) {
            if (venta != null) {
                contador ++;
                for (DetalleVenta detalle : venta.listaDetalles) {
                    if (detalle != null) {
                        medicamento[contador] = detalle.NombreMedicamento;
                        montoRecaudado = montoRecaudado + detalle.ImporteTotal;
                    }
                }
            }
        }
    }
}
