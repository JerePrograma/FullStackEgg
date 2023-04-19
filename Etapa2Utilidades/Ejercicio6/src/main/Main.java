package main;

import entidad.Curso;
import servicio.CursoServicio;

public class Main {

    public static void main(String[] args) {
        CursoServicio cs = new CursoServicio();
        Curso curso = cs.crearCurso();

        cs.mostrarAlumnos(curso);
        cs.calcularGananciaSemanal(curso);
    }
}
