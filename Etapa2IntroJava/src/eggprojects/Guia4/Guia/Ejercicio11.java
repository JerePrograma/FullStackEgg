/*Escribir un programa que procese una secuencia de caracteres ingresada por teclado y terminada en punto, 
y luego codifique la palabra o frase ingresada de la siguiente manera:
cada vocal se reemplaza por el carácter que se indica en la tabla y el resto de los caracteres
(incluyendo a las vocales acentuadas) se mantienen sin cambios.
 */
package eggprojects.Guia4.Guia;

import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese una palabra o frase");
        cambiarLetras(leer.next());
    }

    public static void cambiarLetras(String palabra) {
        //a = @ - e = # - i = $ - o = % - u = *
        String palabraAuxiliar = "";
        for (int i = 0; i < palabra.length(); i++) {
            switch (palabra.substring(i, i + 1)) {
                case "a":
                case "A":
                    palabraAuxiliar += "@";
                    break;
                case "e":
                case "E":
                    palabraAuxiliar += "#";
                    break;
                case "i":
                case "I":
                    palabraAuxiliar += "$";
                    break;
                case "o":
                case "O":
                    palabraAuxiliar += "%";
                    break;
                case "u":
                case "U":
                    palabraAuxiliar += "*";
                    break;
                default:
                    palabraAuxiliar += palabra.substring(i, i + 1);
            }
        }
        System.out.println("La palabra cambiada es: " + palabraAuxiliar);
    }
}
