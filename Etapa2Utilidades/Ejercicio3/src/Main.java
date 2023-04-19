
import servicio.ArregloService;

/*En el Main nuevamente: inicializar A, mostrar A, ordenar A, inicializar B, mostrar A y B.
 */
public class Main {

    public static void main(String[] args) {
        ArregloService arrS = new ArregloService();
        double[] A = new double[50];
        double[] B = new double[20];

        arrS.inicializarA(A);
        arrS.mostrarArreglo(A);
        arrS.mostrarArregloMayorAMenor(A);
        arrS.inicializarB(A, B);
        arrS.mostrarArreglo(A);
        arrS.mostrarArreglo(B);
    }
}
