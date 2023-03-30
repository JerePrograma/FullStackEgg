package main;

import entidad.Cocina;
import entidad.Receta;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Cocina cocina = new Cocina();

        Set<String> ingredientesPizza = new HashSet<>();
        ingredientesPizza.add("harina");
        ingredientesPizza.add("levadura");
        ingredientesPizza.add("agua");
        ingredientesPizza.add("sal");
        ingredientesPizza.add("aceite");
        ingredientesPizza.add("salsa de tomate");
        ingredientesPizza.add("queso");

        Receta pizza = new Receta("Pizza", ingredientesPizza);
        cocina.agregarReceta(pizza);

        // Agregar más recetas aquí
        Set<String> ingredientesDisponibles = new HashSet<>();
        ingredientesDisponibles.add("harina");
        ingredientesDisponibles.add("levadura");
        ingredientesDisponibles.add("agua");
        ingredientesDisponibles.add("sal");
        ingredientesDisponibles.add("aceite");
        ingredientesDisponibles.add("salsa de tomate");
        ingredientesDisponibles.add("queso");

        List<Receta> recetasPreparables = cocina.recetasConIngredientesDisponibles(ingredientesDisponibles);
        recetasPreparables.forEach((recetaPreparable) -> {
            System.out.println("Se puede preparar: " + recetaPreparable.getNombre());
        });
    }
}
