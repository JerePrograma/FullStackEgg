package servicio;

import entidad.Perro;
import java.util.ArrayList;

public class PerroServicio {

    private ArrayList<Perro> perros = new ArrayList<>();

    public void agregarPerro(Perro perro) {
        perros.add(perro);
    }

    public void mostrarPerros() {
        System.out.println("Perros guardados:");
        for (Perro perro : perros) {
            System.out.println(perro);
        }
    }
}
