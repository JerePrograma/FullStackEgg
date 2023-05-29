/*En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main*/
package servicio;

import entidad.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlumnoServicio {

    public ArrayList<Alumno> crearListaAlumnos() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Alumno> alumnos = new ArrayList();
        boolean confirmacion = true;
        do {
            Alumno alumno = new Alumno();
            System.out.println("Ingrese el nombre del alumno");
            alumno.setNombre(leer.next());
            System.out.println("Ingresa las notas del alumno");
            ArrayList<Integer> notas = new ArrayList();
            for (int i = 0; i < 3; i++) {
                notas.add(leer.nextInt());
            }
            alumno.setNotas(notas);
            alumnos.add(alumno);
            System.out.println("Desea ingresar otro alumno? S/N");
            if (leer.next().equalsIgnoreCase("N")) {
                confirmacion = false;
            }
        } while (confirmacion);
        return alumnos;
    }

    public Double buscarAlumno(ArrayList<Alumno> alumnos) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del alumno que desea calcular la nota final");
        String alumnoABuscar = leer.next();
        Iterator<Alumno> it = alumnos.iterator();
        while (it.hasNext()) {
            Alumno alumnoAuxiliar = it.next();
            if (alumnoAuxiliar.getNombre().equalsIgnoreCase(alumnoABuscar)) {
                return promedioNotas(alumnoAuxiliar);
            }
        }
        System.out.println("NO se encontró el alumno");
        return null;
    }

    public double promedioNotas(Alumno alumno) {
        double sumaNotas = 0;
        for (Integer nota : alumno.getNotas()) {
            sumaNotas += nota;
        }
        return sumaNotas / alumno.getNotas().size();
    }
}
