package ejercicios;
//Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
//alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer

import entidad.Alumno;
import java.util.ArrayList;
import servicio.AlumnoServicio;

//con sus 3 notas.
//En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
//toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
//pregunta al usuario si quiere crear otro Alumno o no.
//Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
//Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
//final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
//del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
//promedio final, devuelto por el método y mostrado en el main.
public class Ejercicio3 {

    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList();
        AlumnoServicio.cargarAlumno(alumnos);
        System.out.println("La nota final del alumno es: " + AlumnoServicio.notaFinal(alumnos));
        System.out.println(alumnos);
        System.out.println("------------------------");
        for (Alumno alumno : alumnos) {
               System.out.println(alumno);
        }
    }

}
