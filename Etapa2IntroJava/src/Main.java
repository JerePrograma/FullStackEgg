import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String contrasenia;
        do {
            System.out.println("Ingrese la contraseña");
            contrasenia = leer.next();
        } while (!contrasenia.equals("eureka"));
    }
}
