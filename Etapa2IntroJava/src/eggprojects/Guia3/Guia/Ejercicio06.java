package eggprojects.Guia3.Guia;

import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int num1, num2, numAPasar;
        numAPasar = 25;
        System.out.println("Ingrese el primer número");
        num1 = leer.nextInt();
        System.out.println("Ingrese el segundo número");
        num2 = leer.nextInt();

        if (num1 > numAPasar && num2 > numAPasar) {
            System.out.println("Los dos números son mayores");
        } else if (num1 > numAPasar) {
            System.out.println("El primer número es mayor");
        } else if (num2 > numAPasar) {
            System.out.println("El segundo número es mayor");
        } else {
            System.out.println("Ninguno de los números es mayor!");
        }
    }
}
