package deteccionerrores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class DeteccionErrores {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("LISTA");
        ArrayList<String> bebidas = new ArrayList();
        bebidas.add("café");
        bebidas.add("té");
        System.out.println(bebidas);
        Iterator<String> it = bebidas.iterator();
        while (it.hasNext()) {
            if (it.next().equals("café")) {
                it.remove();
            }
        }
        for (String bebida : bebidas) {

        }
        //-------------------------------------------
        System.out.println("SET");
        HashSet<Integer> numerosB = new HashSet();
        for (int i = 0; i < 5; i++) {
            numerosB.add(i);
        }
        System.out.println(numerosB.size());
        numerosB.remove(3);
        System.out.println(numerosB.size());
        //-------------------------------------------
        System.out.println("MAP");
        HashMap<Integer, String> alumnos = new HashMap();
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingresa el nombre del alumno");
            String nombre = leer.next();
            alumnos.put(i, nombre);
        }
        System.out.println(alumnos);
        System.out.println(alumnos.size());
        alumnos.remove(3);
        System.out.println(alumnos.size());
        //-------------------------------------------
        System.out.println("MAP");
        HashMap<Integer, String> personas = new HashMap();
        String n1 = "Albus";
        String n2 = "Severus";
        personas.put(1, n1);
        personas.put(2, n2);
        for (Map.Entry<Integer, String> entry : personas.entrySet()) {
            System.out.println("nombre: " + entry.getValue());
        }
        //-------------------------------------------
    }

}
