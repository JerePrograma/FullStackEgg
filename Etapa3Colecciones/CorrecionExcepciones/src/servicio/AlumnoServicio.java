//En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
//toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
//pregunta al usuario si quiere crear otro Alumno o no.
//Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
package servicio;

import entidad.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlumnoServicio {

    static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void cargarAlumno(ArrayList<Alumno> alumnos) {
        String respuesta;
        do {
            Alumno alumno = new Alumno();
            System.out.println("Ingrese el nombre del alumno");
            alumno.setNombre(leer.next());
            System.out.println("Ingrese las 3 notas del alumno");
            ArrayList<Integer> notas = new ArrayList();
            for (int i = 0; i < 3; i++) {
                notas.add(leer.nextInt());
            }
            alumno.setNotas(notas);
            alumnos.add(alumno);
            System.out.println("Desea cargar otro alumno? S/N");
            respuesta = leer.next();
        } while (!respuesta.equalsIgnoreCase("N"));
    }

    //Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
//final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
//del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
//promedio final, devuelto por el método y mostrado en el main.
    public static double notaFinal(ArrayList<Alumno> alumnos) {
        System.out.println("Ingrese el nombre del alumno que desea calcular su nota final");
        String nombreAlumno = leer.next();
        double sumaNota = 0;

        /*for (Alumno alumno : alumnos) {
            Alumno alumnoAuxiliar = alumno;
            if (alumnoAuxiliar.equals(alumno.getNombre())) {
                for (Integer notas : alumnoAuxiliar.getNotas()) {
                    sumaNota += notas;
                }
            }
        }*/
        double promedio = 0;
        Iterator<Alumno> iterador = alumnos.iterator();
        while (iterador.hasNext()) {
            Alumno alumnoAuxiliar = iterador.next();
            if (alumnoAuxiliar.getNombre().equals(nombreAlumno)) {
                for (Integer notas : alumnoAuxiliar.getNotas()) {
                    sumaNota += notas;
                }
                promedio = sumaNota / alumnoAuxiliar.getNotas().size();

            }
        }
        return promedio;
    }
}
