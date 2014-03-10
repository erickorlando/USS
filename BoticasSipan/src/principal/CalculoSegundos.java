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
public class CalculoSegundos {
    
    public static void Calcular()
    {
        System.out.println("Ingrese la cantidad de Segundos que quiere calcular");
        Scanner sc = new Scanner(System.in);
        int segundos = sc.nextInt();
        
        double horas = segundos/3600;
        double minutos = segundos/60;
        
        System.out.println("Ud. ingresó " + segundos +
                " segundos que equivalen a " + horas + 
                " horas y " + minutos + " minutos.");
    }
}
