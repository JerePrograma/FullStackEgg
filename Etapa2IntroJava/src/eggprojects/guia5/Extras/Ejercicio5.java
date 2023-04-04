package eggprojects.guia5.Extras;

import java.util.Scanner;

/*Realizar un programa que llene una matriz de tamaño NxM con valores aleatorios y muestre la suma de sus elementos.*/
public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la dimensión de filas y columnas de la matriz");
        int n = leer.nextInt();
        int m = leer.nextInt();

        int[][] matriz = new int[n][m];
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
                suma += matriz[i][j];
            }
        }
        for (int[] ints : matriz) {
            for (int j = 0; j < m; j++) {
                System.out.print("[" + ints[j] + "]");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("La suma de todos sus elementos es de " + suma);
    }
}
