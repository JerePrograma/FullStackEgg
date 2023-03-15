/*Dibujar un cuadrado de N elementos por lado utilizando el carácter “*”. 
Por ejemplo, si el cuadrado tiene 4 elementos por lado se deberá dibujar lo siguiente:
* * * *
*     *
*     *
* * * *
 */
package eggprojects.Guia3;

import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del cuadrado");
        int tamanio = leer.nextInt();
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (i == 0 || i == tamanio - 1 || j == 0 || j == tamanio - 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
