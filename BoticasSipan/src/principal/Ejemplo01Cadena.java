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
public class Ejemplo01Cadena {
    
    public static void Saludar(String Nombres)
    {
        if (Nombres.equals(""))
            System.out.println("Debe ingresar un nombre");
        else
            System.out.println("Hola " + Nombres);
    }
}
