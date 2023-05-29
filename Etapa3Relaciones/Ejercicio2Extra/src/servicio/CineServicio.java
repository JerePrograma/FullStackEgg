package servicio;

//Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y se los
//ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde ya este
//ocupado el asiento).
//Los espectadores serán ubicados de uno en uno y para ubicarlos tener en cuenta que sólo se
//podrá sentar a un espectador si tiene el dinero suficiente para pagar la entrada, si hay espacio
//libre en la sala y si tiene la edad requerida para ver la película. En caso de que el asiento este
//ocupado se le debe buscar uno libre.
//Al final del programa deberemos mostrar la tabla, podemos mostrarla con la letra y numero de
//cada asiento o solo las X y espacios vacíos.
import entidad.Asiento;
import entidad.Cine;
import entidad.Espectador;
import java.util.Random;
import java.util.Scanner;

public class CineServicio {

    public Cine simulacion() {
        Cine cine = new Cine();
        Scanner leer = new Scanner(System.in);
        Random random = new Random();
        int espectadores = random.nextInt(100);
        Asiento[][] sala = cine.getSala().getAsientos();
        mostrarSala(cine);
        boolean salaLlena = false;
        for (int i = 0; i < espectadores; i++) {
            Espectador espectador = new Espectador();
            espectador.setNombre(String.valueOf(i));
            espectador.setEdad(random.nextInt(100));
            espectador.setDinero(random.nextInt(1000));
            if (espectador.getEdad() >= cine.getPelicula().getEdadMinima() && espectador.getDinero() > cine.getPrecioEntrada()) {
                int fila;
                int columna;
                int contador = 0;
                do {
                    columna = random.nextInt(6);
                    fila = random.nextInt(8);
                    contador++;
                    if (contador > 150) {
                        salaLlena = true;
                        break;
                    }
                } while (cine.getSala().getAsientos()[fila][columna].isOcupado());
                if (salaLlena) {
                    System.out.println("SE LLENÓ LA SALA, PESADO");
                    break;
                } else {
                    Asiento asiento = sala[fila][columna];
                    asiento.setNombre(asiento.getNombre() + " X");
                    asiento.setEspectador(espectador);
                    asiento.setOcupado(true);
                    sala[fila][columna] = asiento;
                }
            }
        }
        mostrarSala(cine);
        return cine;
    }

    public void mostrarSala(Cine cine) {
        for (int i = 0; i < cine.getSala().getAsientos().length; i++) {
            for (int j = 0; j < cine.getSala().getAsientos()[0].length; j++) {
                System.out.print(cine.getSala().getAsientos()[i][j] + " |");
            }
            System.out.println();
        }
    }
}
