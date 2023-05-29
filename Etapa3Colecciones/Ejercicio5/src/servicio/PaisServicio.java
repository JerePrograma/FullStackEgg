/*El programa pedirá un país en un bucle, se guardará el país en el
//conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
//si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
//los servicios en la clase correspondiente)
//Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
//cómo se ordena un conjunto.
//Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
//buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
//usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
//al usuario.
 */
package servicio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class PaisServicio {

    public HashSet<String> cargarPaises(Scanner leer) {
        HashSet<String> paises = new HashSet();
        boolean bucle = true;
        String respuesta;
        do {
            System.out.println("Ingrese un país");
            paises.add(leer.next().toUpperCase());
            System.out.println("Desea ingresar otro país?");
            respuesta = leer.next();
            if (respuesta.equalsIgnoreCase("N")) {
                bucle = false;
            }
        } while (bucle);
        mostrarPaises(paises);
        return paises;
    }

    public void mostrarPaises(HashSet<String> paises) {
        for (String pais : paises) {
            System.out.println(pais);
        }
    }

    public void ordernarYmostrar(HashSet<String> paises) {
        TreeSet<String> paisesOrdenados = new TreeSet(paises);
//      ArrayList<String> paisesLista = new ArrayList(paises);
//      Collections.sort(paisesLista);
        for (String paisOrdenado : paisesOrdenados) {
            System.out.println(paisOrdenado);
        }
    }

    public void eliminarPais(HashSet<String> paises, Scanner leer) {
        Iterator<String> it = paises.iterator();
        System.out.println("Ingrese el país que desea eliminar");
        String paisRemover = leer.next().toUpperCase();
        boolean noEncontrado = true;
        while (it.hasNext()) {
            if (it.next().equals(paisRemover)) {
                it.remove();
                noEncontrado = false;
            }
        }
        if (noEncontrado) {
            System.out.println("NO se encontró el país que desea eliminar");
        }
    }
}
