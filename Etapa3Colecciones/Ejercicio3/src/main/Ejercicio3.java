package main;

import entidad.Alumno;
import java.util.ArrayList;
import servicio.AlumnoServicio;

public class Ejercicio3 {

    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList();
        AlumnoServicio.cargarAlumno(alumnos);
        System.out.println("La nota final del alumno es: " + AlumnoServicio.notaFinal(alumnos));
        System.out.println("------------------------");

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

}
