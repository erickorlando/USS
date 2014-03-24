/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Scanner;

/**
 *
 * @author Erick Orlando
 */
public class Helper {

    private static final Scanner sc = new Scanner(System.in);

    public static void Escribir(String Mensaje) {
        System.out.println(Mensaje);
    }

    public static void EscribirJunto(String mensaje) {
        System.out.print(mensaje);
    }

    public static void Separador() {
        Escribir("---------------------------------------------");
    }

    public static void SeparadorDoble() {
        Escribir("=============================================");
    }

    public static String LeerCadena() {
        return sc.next();
    }

    public static int LeerEntero() {
        return sc.nextInt();
    }

    public static float LeerFloat() {
        return sc.nextFloat();
    }

    public static void LimpiarPantalla() {
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
    }
}
