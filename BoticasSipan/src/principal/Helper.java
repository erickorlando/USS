/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Erick Orlando
 */
public class Helper {

    // Definimos la constante para Formato de Fecha.
    private static final String FormatoFecha = "dd/MM/yyyy";
    private static final Scanner sc = new Scanner(System.in);
    public static Date FechaActual = new Date();

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

    public static String LeerLinea() {
        String valor = LeerCadena();
        valor = valor + sc.nextLine();
        return valor;
    }

    public static Date LeerFecha(String Fecha) {
        Date resultado = new Date();
        try {
            SimpleDateFormat formato = new SimpleDateFormat(FormatoFecha, Locale.getDefault());
            formato.setLenient(false);
            resultado = formato.parse(Fecha);
            return resultado;
        } catch (ParseException e) {
            Escribir("El formato de Fecha ingresado no es válido, se usará fecha actual");
            Escribir(e.getMessage());
            return resultado;
        }
    }

    public static boolean CompararFecha(Date fecha) {
        boolean resultado;

        resultado = fecha.before(FechaActual);
        // En caso la Fecha Actual no está antes que la fecha ingresada.
        if (!resultado) {
            if (fecha == FechaActual) {
                resultado = true;
            }
        }
        return resultado;
    }

    public static String LeerFecha(Date fecha) {
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        return sqlDate.toString();
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
