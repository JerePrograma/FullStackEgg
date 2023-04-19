package servicio;

import java.util.Arrays;

/*Método inicializarA recibe un arreglo por parámetro y lo inicializa con números aleatorios.
Método mostrar recibe un arreglo por parámetro y lo muestra por pantalla.
Método ordenar recibe un arreglo por parámetro y lo ordena de mayor a menor.
Método inicializarB copia los primeros 10 números del arreglo A en el arreglo B. 
Luego llenar las últimas 10 posiciones del arreglo B con 0.5.
 */
public class ArregloService {

    public void inicializarA(double[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = Math.random() * 10;
        }
        System.out.println("-----------------------------------");
    }

    public void mostrarArreglo(double[] arreglo) {
        System.out.println(Arrays.toString(arreglo));
        System.out.println("-----------------------------------");
    }

    public void mostrarArregloMayorAMenor(double[] arreglo) {
        Arrays.sort(arreglo);
        mostrarArreglo(arreglo);
    }

///bubblesort

    /*public void ordenar(double[] arreglo) {
        Arrays.sort(arreglo);
        for (int i = 0; i < arreglo.length / 2; i++) {
            double temp = arreglo[i];
            arreglo[i] = arreglo[arreglo.length - 1 - i];
            arreglo[arreglo.length - 1 - i] = temp;
        }
    }*/
    public void inicializarB(double[] arregloA, double[] arregloB) {
        System.arraycopy(arregloA, 0, arregloB, 0, arregloB.length / 2);
        Arrays.fill(arregloB, arregloB.length / 2, arregloB.length, 0.5);
    }
}
