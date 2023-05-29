/*Métodos:
• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false. */
package servicio;

import entidad.Jugador;
import entidad.RevolverDeAgua;

public class JugadorServicio {

    RevolverDeAguaServicio rs = new RevolverDeAguaServicio();

    public boolean disparo(Jugador jugador, RevolverDeAgua r) {
        boolean mojar = rs.mojar(r);
        if (mojar) {
            jugador.setMojado(true);
        }
        rs.siguienteChorro(r);
        return mojar;
    }
}
