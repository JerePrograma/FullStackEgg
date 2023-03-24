package eggprojects.guia5.Ejercicios;

public class Ejercicio5VBing {

    public static void main(String[] args) {
        int[][] matriz = {{0, 1, -2}, {-1, 0, -3}, {2, 3, 0}};
        boolean esAntisimetrica = true;
        // Comprobar si la matriz es antisimétrica
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != -matriz[j][i]) {
                    esAntisimetrica = false;
                    break;
                }
            }
            if (!esAntisimetrica) {
                break;
            }
        }
        // Mostrar el resultado
        if (esAntisimetrica) {
            System.out.println("La matriz es antisimétrica.");
        } else {
            System.out.println("La matriz no es antisimétrica.");
        }
    }
}
