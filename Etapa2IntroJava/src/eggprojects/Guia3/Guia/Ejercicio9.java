/*Escriba un programa que lea 20 números. Si el número leído es igual a cero se debe salir del bucle y mostrar el mensaje "Se capturó el numero cero".  
El programa deberá calcular y mostrar el resultado de la suma de los números leídos,
 pero si el número es negativo no debe sumarse. Nota: recordar el uso de la sentencia break.*/
package eggprojects.Guia3.Guia;

import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int contador = 0;
        int num;
        int sumador = 0;
        do {
            System.out.println("Ingresa un número");
            num = leer.nextInt();
            contador++;
            if(num<0){
                continue;
            }
            sumador += num;
            if (num == 0) {
                System.out.println("Se capturó un 0");
                break;
            }
        } while (contador < 20);
        System.out.println(sumador);
    }
}