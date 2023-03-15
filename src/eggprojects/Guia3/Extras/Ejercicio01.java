/*Dado un tiempo en minutos, calcular su equivalente en días y horas. 
Por ejemplo, si el usuario ingresa 1600 minutos, el sistema debe calcular su equivalente: 1 día, 2 horas.

 */
package eggprojects.Guia3.Extras;

import java.util.Scanner;

public class Ejercicio01 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa un tiempo en minutos");
        int minutos = leer.nextInt();
        int horas = minutos / 60;
        int dias = 0;
        while (horas >= 24) {
            horas -= 24;
            dias++;
        }
        System.out.println("Su equivalente en días es " + dias + " y horas " + horas);
    }
}
