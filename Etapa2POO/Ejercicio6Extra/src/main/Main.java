package main;

import entidad.Empleado;

/*Crea una clase "Empleado" que tenga atributos como "nombre", "edad" y "salario". 
Luego, crea un método "calcular_aumento" que calcule el aumento salarial de un empleado en función de su edad y salario actual. 
El aumento salarial debe ser del 10% si el empleado tiene más de 30 años o del 5% si tiene menos de 30 años.
 */
public class Main {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Jeremias", 28, 20000);
        Empleado empleado2 = new Empleado("Juan", 33, 20000);

        System.out.println("El sueldo del empleado 1 es: " + empleado1.getSalario());
        System.out.println("El sueldo del empleado 2 es: " + empleado2.getSalario());
        empleado1.calcular_aumento();
        empleado2.calcular_aumento();
        System.out.println("El sueldo del empleado 1 es: " + empleado1.getSalario());
        System.out.println("El sueldo del empleado 2 es: " + empleado2.getSalario());

    }
}
