/*Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)
 */
package servicio;

import entidad.RevolverDeAgua;

public class RevolverDeAguaServicio {

    public RevolverDeAgua llenarRevolver() {
        return new RevolverDeAgua();
    }

    public boolean mojar(RevolverDeAgua revolver) {
        return revolver.getPosicionActual() == revolver.getPosicionAgua();
    }

    public void siguienteChorro(RevolverDeAgua revolver) {
        if (revolver.getPosicionActual() == 6) {
            revolver.setPosicionActual(1);
        } else {
            revolver.setPosicionActual(revolver.getPosicionActual() + 1);
        }
    }
}
