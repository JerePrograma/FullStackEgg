/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Empleado;
import java.util.Scanner;

/**
 *
 * @author Jerem
 */
public class EmpleadoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void cargarEmpleado(Empleado[] empleados) {
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Ingrese el nombre del empleado");
            String nombre = leer.next();
            System.out.println("Ingrese el salario del empleado");
            double salario = leer.nextDouble();
            empleados[i] = new Empleado(nombre, salario);
        }
    }

    public double sumarSalarios(Empleado[] empleados) {
        double sumaSalarios = 0;
        for (int i = 0; i < empleados.length; i++) {
            sumaSalarios += empleados[i].getSalario();
        }
        double promedioSalarios = sumaSalarios / empleados.length;
        System.out.println("El promedio de todos los salarios es de: " + promedioSalarios);
        return promedioSalarios;
    }

    public void empleadosSuperior(Empleado[] empleados) {
        int contador = 0;
        double promedioSalarios = sumarSalarios(empleados);
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].getSalario() > promedioSalarios) {
                contador++;
            }
        }
        String[] nombresEmpleados = new String[contador];
        contador = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].getSalario() > promedioSalarios) {
                nombresEmpleados[contador] = empleados[i].getNombre();
                contador++;
            }
        }

        for (String nombre : nombresEmpleados) {
            System.out.println("El empleado " + nombre + " supera el promedio del salario, que afortunado!");
        }
    }
}   
