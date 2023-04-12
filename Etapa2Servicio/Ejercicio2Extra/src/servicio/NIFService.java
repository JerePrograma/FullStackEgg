package servicio;

import entidad.NIF;
import java.util.Scanner;

public class NIFService {

    Scanner scanner = new Scanner(System.in);

    public void crearNIF(NIF nif) {
        System.out.print("Introduce el número de DNI: ");
        long dni = scanner.nextLong();
        nif.setDni(dni);
        nif.setLetra(calcularLetra(dni));
    }

    private char calcularLetra(long dni) {
        int resto = (int) (dni % 23);
        return NIF.LETRAS_DNI[resto];
    }

    public void mostrar(NIF nif) {
        System.out.println(nif.mostrar());
    }
}
