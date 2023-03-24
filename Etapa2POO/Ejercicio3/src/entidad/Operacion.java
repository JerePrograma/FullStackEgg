package entidad;

import java.util.Scanner;

/*Crear una clase llamada Operacion que tenga como atributos privados numero1 y numero2. A continuación, se deben crear los siguientes métodos:
Método constructor con todos los atributos pasados por parámetro.
Método constructor sin los atributos pasados por parámetro.
Métodos get y set.
Método para crearOperacion(): que le pide al usuario los dos números y los guarda en los atributos del objeto.
Método sumar(): calcular la suma de los números y devolver el resultado al main.
Método restar(): calcular la resta de los números y devolver el resultado al main
Método multiplicar(): primero valida que no se haga una multiplicación por cero, si fuera a multiplicar por cero, el método devuelve 0 y se le informa al usuario el error.
Si no, se hace la multiplicación y se devuelve el resultado al main
Método dividir(): primero valida que no se haga una división por cero, si fuera a pasar una división por cero, el método devuelve 0 y se le informa al usuario el error se le informa al usuario. 
Si no, se hace la división y se devuelve el resultado al main.*/
public class Operacion {

    private int numero1;
    private int numero2;

    public Operacion(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public Operacion() {
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public static void crearOperacion(Operacion operacion) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el primer número");
        operacion.setNumero1(leer.nextInt());
        System.out.println("Ingrese el segundo número");
        operacion.setNumero2(leer.nextInt());
    }

    public static int sumar(Operacion operacion) {
        int suma = operacion.getNumero1() + operacion.getNumero2();
        System.out.println("La suma de los números es: " + suma);
        return suma;
    }

    public static int restar(Operacion operacion) {
        int resta = operacion.getNumero1() - operacion.getNumero2();
        System.out.println("La resta de los números es: " + resta);
        return resta;
    }

    public static int multiplicar(Operacion operacion) {
        int multiplicacion = 0;
        if (operacion.getNumero1() == 0 || operacion.getNumero2() == 0) {
            System.out.println("Se multiplicó por 0, por lo que el resultado es " + 0);
        } else {
            multiplicacion = operacion.getNumero1() * operacion.getNumero2();
            System.out.println("La multiplicacion de los números es: " + multiplicacion);
        }
        return multiplicacion;
    }

    public static double dividir(Operacion operacion) {
        double numero1 = operacion.getNumero1();
        double numero2 = operacion.getNumero2();
        double division = 0;
        if (operacion.getNumero2() == 0) {
            System.out.println("Se dividió por 0, por lo que el resultado es " + 0 + ". Error en la operación.");
        } else {
            division = numero1 / numero2;
            System.out.println("La multiplicacion de los números es: " + division);
        }
        return division;
    }
}
