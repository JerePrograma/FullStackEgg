package servicio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Jerem
 */
public class PaisesServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void cargarPaises(HashSet<String> paises) {
        boolean bucle = true;
        do {
            System.out.println("Ingrese el pais");
            paises.add(leer.next());
            System.out.println("Desea ingresar otro país? S/N");
            if (leer.next().equalsIgnoreCase("N")) {
                bucle = false;
            }
        } while (bucle);
        System.out.println("Lista de países");
        for (String pais : paises) {
            System.out.println(pais);
        }
    }

    public void ordenar(HashSet<String> paises) {

        TreeSet<String> paisesOrdenados = new TreeSet(paises);
        System.out.println("Lista de países ordenados");
        for (String paisOrdenado : paisesOrdenados) {
            System.out.println(paisOrdenado);
        }
    }

    public void eliminarPais(HashSet<String> paises) {
        boolean noEncontrado = true;
        Iterator it = paises.iterator();
        System.out.println("Ingrese el país a eliminar");
        String paisEliminar = leer.next();
        while (it.hasNext()) {
            if (it.next().equals(paisEliminar)) {
                it.remove();
                noEncontrado = false;
                break;
            }
        }
        if (noEncontrado) {
            System.out.println("NO se encontró el país que deseaba eliminar :c");
        }
        System.out.println("Lista de países");
        for (String pais : paises) {
            System.out.println(pais);
        }
    }

}
