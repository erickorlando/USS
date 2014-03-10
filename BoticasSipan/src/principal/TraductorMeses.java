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
public class TraductorMeses{
    
    public static void Calcular()
    {
        System.out.println("Ingrese el número de mes que desee visualizar");
        Scanner sc = new Scanner(System.in);
        
        int mesIngresado = sc.nextInt();
        String mesEnCadena;
        boolean valido = true;
        switch (mesIngresado)
        {
            case 1:
                mesEnCadena = "Enero";
                break;
            case 2:
                mesEnCadena = "Febrero";
                break;
            case 3:
                mesEnCadena = "Marzo";
                break;
            case 4:
                mesEnCadena = "Abril";
                break;
            case 5:
                mesEnCadena = "Mayo";
                break;
            case 6:
                mesEnCadena = "Junio";
                break;
            case 7:
                mesEnCadena = "Julio";
                break;
            case 8:
                mesEnCadena = "Agosto";
                break;
            case 9:
                mesEnCadena = "Setiembre";
                break;
            case 10:
                mesEnCadena = "Octubre";
                break;
            case 11:
                mesEnCadena = "Noviembre";
                break;
             case 12:
                mesEnCadena = "Diciembre";
                break;
             default:
                 mesEnCadena = "Número de mes no válido";
                 valido = false;
                 break;
        }
        
        if (!valido)
            System.out.println(mesEnCadena);
        else
            System.out.println("El mes ingresado es " + mesEnCadena);
    }
}

