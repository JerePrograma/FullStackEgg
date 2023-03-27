package Repaso;

/*Simular la división usando solamente restas. Dados dos números enteros mayores que uno, 
realizar un algoritmo que calcule el cociente y el residuo usando sólo restas. Método: 
Restar el dividendo del divisor hasta obtener un resultado menor que el divisor, 
este resultado es el residuo, y el número de restas realizadas es el cociente.
Por ejemplo: 50 / 13:
50 – 13 = 37     una resta realizada
37 – 13 = 24     dos restas realizadas
24 – 13 = 11     tres restas realizadas
dado que 11 es menor que 13, entonces: el residuo es 11 y el cociente es 3.*/
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaNombres {

    // Cargar nombres en el arreglo
    public static void cargarNombres(ArrayList<String> nombres, int N) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            System.out.println("Ingrese el nombre " + (i + 1) + ": ");
            nombres.add(scanner.nextLine());
        }
    }

    // Encontrar la primera posición del nombre buscado
    public static int encontrarPrimero(ArrayList<String> nombres, String nombreBuscado) {
        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).equalsIgnoreCase(nombreBuscado)) {
                return i;
            }
        }
        return -1;
    }

    // Copiar todos los índices del nombre buscado en otro arreglo
    public static ArrayList<Integer> copiarTodos(ArrayList<String> nombres, String nombreBuscado) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).equalsIgnoreCase(nombreBuscado)) {
                indices.add(i);
            }
        }
        return indices;
    }// Mostrar nombres de ambos arreglos

    public static void mostrarNombres(ArrayList<String> nombres, ArrayList<Integer> indices) {
        System.out.println("Nombres:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        System.out.println("Índices:");
        for (Integer indice : indices) {
            System.out.println(indice);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del arreglo:");
        int N = scanner.nextInt();
        scanner.nextLine(); // Para consumir el salto de línea pendiente

        ArrayList<String> nombres = new ArrayList<>();
        cargarNombres(nombres, N);

        String opcion = "";
        while (!opcion.equalsIgnoreCase("salir")) {
            System.out.println("Opciones:");
            System.out.println("1. Encontrar primero");
            System.out.println("2. Copiar todos");
            System.out.println("3. Mostrar datos");
            System.out.println("Escriba 'salir' para terminar");

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el nombre a buscar:");
                    String nombreBuscado = scanner.nextLine();
                    int posicion = encontrarPrimero(nombres, nombreBuscado);
                    if (posicion == -1) {
                        System.out.println("Nombre no encontrado.");
                    } else {
                        System.out.println("El nombre fue encontrado en la posición: " + posicion);
                    }
                    break;
                case "2":
                    System.out.println("Ingrese el nombre a buscar:");
                    nombreBuscado = scanner.nextLine();
                    ArrayList<Integer> indices = copiarTodos(nombres, nombreBuscado);
                    System.out.println("Índices copiados.");
                    break;
                case "3":
                    mostrarNombres(nombres, indices);
                    break;
                default:
                    if (!opcion.equalsIgnoreCase("salir")) {
                        System.out.println("Opción no válida, intente de nuevo.");
                    }
            }
        }
    }
}
