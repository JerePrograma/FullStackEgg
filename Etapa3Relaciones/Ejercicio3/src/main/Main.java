package main;

import entidad.Baraja;
import java.util.Scanner;
import servicio.BarajaServicio;

/*Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número entre 1
y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta clase debe
contener un método toString() que retorne el número de carta y el palo. La baraja estará
compuesta por un conjunto de cartas, 40 exactamente.
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
se haya llegado al final, se indica al usuario que no hay más cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
luego se llama al método, este no mostrara esa primera carta.*/
public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        BarajaServicio bs = new BarajaServicio();
        Baraja baraja1 = bs.crearBaraja();
        boolean bucle = true;
        do {
            System.out.println("1- Barajar");
            System.out.println("2- Ver cartas disponible");
            System.out.println("3- Dar cartas");
            System.out.println("4- Cartas desechadas");
            System.out.println("5- Mostrar baraja");
            System.out.println("Cualquier número para salir");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    bs.barajar(baraja1);
                    break;
                case 2:
                    bs.cartasDisponibles(baraja1);
                    break;
                case 3:
                    bs.darCartas(baraja1);
                    break;
                case 4:
                    bs.cartasMonton(baraja1);
                    break;
                case 5:
                    bs.mostrarBaraja(baraja1);
                    break;
                default:
                    bucle = false;
            }
        } while (bucle);
    }
}
