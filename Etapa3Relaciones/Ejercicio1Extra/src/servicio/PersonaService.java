package servicio;

import entidad.Perro;
import entidad.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PersonaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ArrayList<Persona> crearPersona() {
        ArrayList<Persona> personas = new ArrayList();
        String op;
        do {
            System.out.println("Ingrese el nombre de la persona");
            String nombre = leer.next();
            System.out.println("Ingrese el apellido de la persona");
            String apellido = leer.next();
            System.out.println("Ingrese la edad de la persona");
            int edad = leer.nextInt();
            System.out.println("Ingrese el documento de la persona");
            int documento = leer.nextInt();
            Persona per = new Persona(nombre, apellido, edad, documento);
            personas.add(per);
            System.out.println("Desea seguir ingresando personas s/n");
            op = leer.next();
        } while (op.equalsIgnoreCase("s"));

        return personas;
    }

    public void adoptarPerro(ArrayList<Persona> personas, ArrayList<Perro> perros, HashMap<Persona, Perro> adoptar) {
        System.out.println("Listado de perros: ");
        for (Perro perro : perros) {
            System.out.println(perro);
        }
        System.out.println("Listado de personas: ");
        for (Persona persona : personas) {
            System.out.println(persona);
        }

        Iterator<Persona> itPer = personas.iterator();
        Iterator<Perro> itPerro = perros.iterator();
        boolean noEncontrado = true;
        while (itPer.hasNext()) {
            Persona per = personas.get(0);
            System.out.println(per.getNombre() + " ingresa el perro que desea adoptar");
            String nomPe = leer.next();
            int iteradorPerro = 0;
            while (itPerro.hasNext()) {
                Perro perro = perros.get(iteradorPerro);
                iteradorPerro++;
                System.out.println(perro.getNombre());
                if (nomPe.equalsIgnoreCase(perro.getNombre())) {
                    adoptar.put(per, perro);
                    personas.remove(per);
                    perros.remove(perro);
                    noEncontrado = false;
                    break;
                } else {
                    noEncontrado = true;
                }
            }
            if (noEncontrado) {
                System.out.println("El perro elegido no se encuentra en la lista o ya fue adoptado");
            }
        }

        for (Map.Entry<Persona, Perro> entry : adoptar.entrySet()) {
            Persona persona = entry.getKey();
            Perro perro = entry.getValue();
            System.out.println("Persona: " + persona.getNombre() + " " + persona.getApellido()
                    + " adoptó al perro " + perro.getNombre() + " (" + perro.getRaza() + ")");
        }
    }
}
