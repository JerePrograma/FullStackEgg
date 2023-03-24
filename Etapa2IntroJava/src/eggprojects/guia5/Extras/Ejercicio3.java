package eggprojects.guia5.Extras;

/*Crear una función rellene un vector con números aleatorios, pasándole un arreglo por parámetro. 
Después haremos otra función o procedimiento que imprima el vector.*/
public class Ejercicio3 {

    public static void main(String[] args) {
        int[] vec = new int[5];
        rellenarVector(vec);
        imprimirVector(vec);
    }

    public static void rellenarVector(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            vec[i] = (int) (Math.random() * 10);
        }
    }

    public static void imprimirVector(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " - ");
        }
    }
}
