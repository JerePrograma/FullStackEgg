package eggprojects.guia5.Ejercicios;

import java.util.Random;

/*Un cuadrado mágico 3 x 3 es una matriz 3 x 3 formada por números del 1 al 9 donde la suma de sus filas, 
sus columnas y sus diagonales son idénticas. 
Crear un programa que permita introducir un cuadrado por teclado y determine si este cuadrado es mágico o no. 
 El programa deberá comprobar que los números introducidos son correctos, es decir, están entre el 1 y el 9.*/
public class Ejercicio6 {

    public static void main(String[] args) {
        int[][] matrizMagica = new int[3][3];

        

        while (true) {
            llenarMatriz(matrizMagica);
            mostrarMatriz(matrizMagica);
            System.out.println("");
            if (esMagica(matrizMagica)) {
                break;
            }
        }
    }

    public static void llenarMatriz(int[][] matriz) {
        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = random.nextInt(9 - 1 + 1) + 1;
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean esMagica(int[][] matriz) {
        int sumaFila = 0;
        int comparacion = 0;
        for (int i = 0; i < matriz.length; i++) {
            sumaFila = 0;
            for (int j = 0; j < matriz.length; j++) {
                sumaFila += matriz[i][j];
            }
            if (i == 0) {
                comparacion = sumaFila;
                continue;
            }
            if (sumaFila != comparacion) {
                return false;
            }
        }
        int sumaColumna = 0;
        for (int j = 0; j < matriz.length; j++) {
            sumaColumna = 0;
            for (int i = 0; i < matriz.length; i++) {
                sumaColumna += matriz[i][j];
            }
            if (j == 0) {
                comparacion = sumaColumna;
                continue;
            }
            if (sumaColumna != comparacion) {
                return false;
            }
        }
        int sumaDiagonal = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (j == i) {
                    sumaDiagonal += matriz[i][j];
                }
            }
        }
        int sumaDiagonalInversa = 0;
        int j = 2;
        for (int i = 0; i < matriz.length; i++) {
            sumaDiagonalInversa += matriz[i][j];
            j--;
        }
        return !(sumaDiagonalInversa != sumaDiagonal || sumaDiagonalInversa != sumaColumna || sumaDiagonalInversa != sumaFila);
    }

}
