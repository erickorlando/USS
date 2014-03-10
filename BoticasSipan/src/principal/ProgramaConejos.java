/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;
import java.util.*;
/**
 *
 * @author Erick Orlando
 */
public class ProgramaConejos {
    
    public static void ImprimirVenta()
    {
        int X;
        int Y;
        float P1;
        float P2;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de Conejos Blancos");
        X = sc.nextInt();
        System.out.println("Ingrese la cantidad de Conejos Negros");
        Y = sc.nextInt();
        int N = X + Y;
        
        // Recibimos el precio.
        System.out.println("Ingrese el precio de los Conejos Blancos");
        P1 = sc.nextFloat();
        System.out.println("Ingrese el precio de los Conejos Negros");
        P2 = sc.nextFloat();
        
        float conejosBlancos = P1 * X;
        float conejosNegros = P2 * Y;
        
        System.out.println("La cantidad de conejos vendidos es " + N);
        String mensaje = (conejosBlancos > conejosNegros) ? "Blancos" : "Negros";
        System.out.println("Se vendieron más conejos " + mensaje);
        
    }
    
}
