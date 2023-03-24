package eggprojects.Guia2;

import java.util.Scanner;

/*Dada una cantidad de grados centígrados se debe mostrar su equivalente 
en grados Fahrenheit. La fórmula correspondiente es: F = 32 + (9 * C / 5).*/
public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de grados centígrados que hace");
        double centigrados = leer.nextDouble();
        double F = 32 + (9 * centigrados / 5);
        System.out.println("Los grados convetidos a Fahrenheit " + F);
    }
}
