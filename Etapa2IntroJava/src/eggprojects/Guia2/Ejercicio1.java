package eggprojects.Guia2;

import java.util.Scanner;


/*Escribir un programa que pida dos números enteros por teclado y calcule la suma de los dos
El programa deberá después mostrar el resultado de la suma*/
public class Ejercicio1 {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ingrese dos números");
        int num1 = leer.nextInt();
        //Definir num Como Entero;
        //Leer num;
        //inicialización.
        int num2 = leer.nextInt();
        int suma = num1 + num2;
        
        System.out.println("La suma de los números es: " + suma);
    }
}