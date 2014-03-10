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
public class EdadesYNombres {
    
    public static void Calcular()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el primer nombre");
        String Nombre1 = sc.next();
        System.out.println("Ingrese la edad del primero");
        int Edad1 = sc.nextInt();
        System.out.println("Ingrese el segundo nombre");
        String Nombre2 = sc.next();
        System.out.println("Ingrese la edad del segundo");
        int Edad2 = sc.nextInt();
        
        String mensaje = (Edad1 > Edad2) ? Nombre1 : Nombre2;
        System.out.println("El mayor es " + mensaje);
    }
}
