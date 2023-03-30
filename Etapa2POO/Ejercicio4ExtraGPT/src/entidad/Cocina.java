package entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cocina {

    private List<Receta> recetas;

    public Cocina() {
        this.recetas = new ArrayList<>();
    }

    public void agregarReceta(Receta receta) {
        recetas.add(receta);
    }

    public Receta buscarRecetaPorNombre(String nombre) {
        for (Receta receta : recetas) {
            if (receta.getNombre().equalsIgnoreCase(nombre)) {
                return receta;
            }
        }
        return null;
    }

    public List<Receta> recetasConIngredientesDisponibles(Set<String> ingredientesDisponibles) {
        List<Receta> recetasPreparables = new ArrayList<>();
        for (Receta receta : recetas) {
            if (ingredientesDisponibles.containsAll(receta.getIngredientes())) {
                recetasPreparables.add(receta);
            }
        }
        return recetasPreparables;
    }
}
