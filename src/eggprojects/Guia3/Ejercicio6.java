/*Realizar un programa que pida dos números enteros positivos por teclado y muestre por pantalla el siguiente menú:
El usuario deberá elegir una opción y el programa deberá mostrar el resultado por pantalla y luego volver al menú. 
El programa deberá ejecutarse hasta que se elija la opción 5. 
Tener en cuenta que, si el usuario selecciona la opción 5, en vez de salir del programa directamente, 
se debe mostrar el siguiente mensaje de confirmación: ¿Está seguro que desea salir del programa (S/N)? 
Si el usuario selecciona el carácter ‘S’ se sale del programa, caso contrario se vuelve a mostrar el menú.*/
package eggprojects.Guia3;

import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese dos números enteros positivos");
        int num1 = leer.nextInt();
        int num2 = leer.nextInt();
        String opcion;
        do {
            System.out.println("Seleccione una opción"
                    + "\n1. Sumar"
                    + "\n2. Restar"
                    + "\n3. Multiplicar"
                    + "\n4. Dividir"
                    + "\n5. Salir"
                    + "\nElija opción");
            opcion = leer.next();
            switch (opcion) {
                case "1":
                    System.out.println("La suma de " + num1 + " con " + num2 + " es de: " + (num1 + num2));
                    break;
                case "2":
                    System.out.println("La resta de " + num1 + " con " + num2 + " es de: " + (num1 - num2));
                    break;
                case "3":
                    System.out.println("La multiplicacion de " + num1 + " con " + num2 + " es de: " + (num1 * num2));
                    break;

                case "4":
                    System.out.println("La división de " + num1 + " con " + num2 + " es de: " + (num1 / num2));
                    break;
                case "5":
                    System.out.println("Seguro desea salir?");
                    opcion = leer.next();
            }
        } while (!"S".equalsIgnoreCase(opcion));
    }
}