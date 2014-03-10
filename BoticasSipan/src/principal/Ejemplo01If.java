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
public class Ejemplo01If {
    public static void Main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese nota");
        int nota = sc.nextInt();
        if (nota >= 5)
        {
            System.out.println("Enhorabuena!");
            System.out.println("Has aprobado");
        }
        else
            System.out.println("Lo sentimos");
    }
}
