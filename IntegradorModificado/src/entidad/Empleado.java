//Para hacer esto, debes crear un objeto de tipo Empleado, cuyos atributos serán
//el nombre y el salario (que representa el salario mensual del empleado). La
//empresa cuenta con solamente 6 empleados, por lo que deberás crear los 6
//objetos Empleado con sus respectivos salarios.
//Una vez creados los empleados, deberás guardarlos en un arreglo de objetos
//tipo Empleado. Utilizando ese arreglo, tendrás que realizar las dos tareas que
//te piden:
//1. Calcular y mostrar el salario promedio de todos los empleados.
//2. Retornar otro arreglo con los nombres de los empleados que tienen un
//salario mayor al promedio.
//Finalmente, debes mostrar todos los empleados con un salario superior al
//promedio.
package entidad;

public class Empleado {

    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
