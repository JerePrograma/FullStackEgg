package servicio;

import entidad.Ahorcado;
import java.util.Scanner;

/*Definir los siguientes métodos en AhorcadoService:
Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima. 
Con la palabra del usuario, pone la longitud de la palabra, como la longitud del vector. 
Después ingresa la palabra en el vector, letra por letra, quedando cada letra de la palabra en un índice del vector.
Y también, guarda la cantidad de jugadas máximas y el valor que ingresó el usuario.
Método longitud(): muestra la longitud de la palabra que se debe encontrar. 
Nota: buscar como se usa el vector.length.
Método buscar(letra):  este método recibe una letra dada por el usuario 
y busca si la letra ingresada es parte de la palabra o no. También informará si la letra estaba o no.
 */
public class AhorcadoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearJuego() {
        Ahorcado ahorcado = new Ahorcado();
        System.out.println("Ingrese la palabra a adivinar");
        String palabraABuscar = leer.next();
        char[] palabra = new char[longitud(palabraABuscar)];
        for (int i = 0; i < palabra.length; i++) {
            palabra[i] = palabraABuscar.charAt(i);
        }
        ahorcado.setPalabraABuscar(palabra);
        System.out.println("Ingrese la cantidad de jugadas máxima");
        ahorcado.setCantidadDeJugadas(leer.nextInt());
        boolean finDeIntentos;
        boolean palabraEncontrada;
        do {
            System.out.println("Ingrese la letra a buscar");
            char letra = leer.next().charAt(0);
            encontradas(letra, ahorcado);
            finDeIntentos = ahorcado.getCantidadDeJugadas() > 0;
            palabraEncontrada = palabraEncontrada = ahorcado.getLetrasEncontradas() == ahorcado.getPalabraABuscar().length;
            if (palabraEncontrada) {
                System.out.println("----------------------------------");
                System.out.println("----------------------------------");
                System.out.println("Felicidades!! Ganaste");
                System.out.println("----------------------------------");
                System.out.println("----------------------------------");
                break;
            } else if (!finDeIntentos) {
                System.out.println("----------------------------------");
                System.out.println("----------------------------------");
                System.out.println("Perdiste!! :c");
                System.out.println("----------------------------------");
                System.out.println("----------------------------------");
                break;
            }
        } while (true);
    }

    public int longitud(String palabra) {
        return palabra.length();
    }

    public boolean buscarLetra(char letra, Ahorcado ahorcado) {

        boolean letraEncontrada = false;
        char[] palabra = ahorcado.getPalabraABuscar();
        for (int i = 0; i < ahorcado.getPalabraABuscar().length; i++) {
            if (letra == palabra[i]) {
                letraEncontrada = true;
                break;
            }
        }
        if (letraEncontrada) {
            System.out.println("La letra pertenece a la palabra");
        } else {
            System.out.println("La letra NO pertenece a la palabra");
        }
        return letraEncontrada;
    }

    /*Método encontradas(letra):  que reciba una letra ingresada por el usuario 
y muestre cuantas letras han sido encontradas y cuántas le faltan. 
Este método además deberá devolver true si la letra estaba y false si la letra no estaba, ya que, 
cada vez que se busque una letra que no esté, se le restará uno a sus oportunidades.
Método intentos(): para mostrar cuántas oportunidades le queda al jugador.
Método juego(): el método juego se encargará de llamar todos los métodos previamente mencionados 
e informará cuando el usuario descubra toda la palabra o se quede sin intentos. 
Este método se llamará en el main.
     */
    public boolean encontradas(char letra, Ahorcado ahorcado) {
        boolean letraEncontrada = buscarLetra(letra, ahorcado);
        char[] palabra = ahorcado.getPalabraABuscar();
        if (letraEncontrada) {
            for (int i = 0; i < ahorcado.getPalabraABuscar().length; i++) {
                if (letra == palabra[i]) {
                    letraEncontrada = true;
                    ahorcado.setLetrasEncontradas(ahorcado.getLetrasEncontradas() + 1);
                }
            }
        } else {
            ahorcado.setCantidadDeJugadas(ahorcado.getCantidadDeJugadas() - 1);
            intentos(ahorcado);
        }
        int faltantes = ahorcado.getPalabraABuscar().length - ahorcado.getLetrasEncontradas();
        System.out.println("Faltan " + faltantes + " letras");
        return letraEncontrada;
    }

    public void intentos(Ahorcado ahorcado) {
        System.out.println("Te quedan " + ahorcado.getCantidadDeJugadas() + " intentos campeón");
    }

    public void juego() {
        crearJuego();
    }
}
