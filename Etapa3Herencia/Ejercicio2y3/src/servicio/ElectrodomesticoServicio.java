package servicio;

import entidad.Electrodomestico;
import java.util.Scanner;

public class ElectrodomesticoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    //• Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
//sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
//objeto y no será visible.
    public char comprobarConsumoEnergetico(char letra) {
        letra = Character.toUpperCase(letra);
        if (letra >= 'A' && letra <= 'F') {
            return letra;
        } else {
            return 'F';
        }
    }
//• Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
//usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
//blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
//minúsculas. Este método se invocará al crear el objeto y no será visible.

    public String comprobarColor(String color) {
        color = color.toLowerCase();
        if (color.equals("blanco") || color.equals("negro") || color.equals("rojo") || color.equals("azul") || color.equals("gris")) {
            return color;
        } else {
            return "blanco";
        }
    }

    //• Metodo crearElectrodomestico(): le pide la información al usuario y llena el
//electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
//precio se le da un valor base de $1000.
    public Electrodomestico crearElectrodomestico() {
        System.out.println("Ingrese el precio del electrodomestico");
        double precio = leer.nextDouble() + 1000;
        System.out.println("Ingresa el color");
        String color = comprobarColor(leer.next());
        System.out.println("Ingresa el tipo de consumo");
        char consumo = comprobarConsumoEnergetico(leer.next().charAt(0));
        System.out.println("Ingresa el peso");
        int peso = leer.nextInt();
        return new Electrodomestico(precio, color, consumo, peso);
    }

//• Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
//precio. Esta es la lista de precios:
//A $1000
//B $800
//C $600
//D $500
//E $300
//F $100
//
//PESO PRECIO
//Entre 1 y 19 kg $100
//Entre 20 y 49 kg $500
//Entre 50 y 79 kg $800
//Mayor que 80 kg $1000
    public double precioFinal(Electrodomestico electrodomestico) {
        switch (electrodomestico.getConsumoEnergetico()) {
            case 'A':
                electrodomestico.setPrecio(electrodomestico.getPrecio() + 1000);
                break;
            case 'B':
                electrodomestico.setPrecio(electrodomestico.getPrecio() + 800);
                break;
            case 'C':
                electrodomestico.setPrecio(electrodomestico.getPrecio() + 600);
                break;
            case 'D':
                electrodomestico.setPrecio(electrodomestico.getPrecio() + 500);
                break;
            case 'E':
                electrodomestico.setPrecio(electrodomestico.getPrecio() + 300);
                break;
            case 'F':
                electrodomestico.setPrecio(electrodomestico.getPrecio() + 100);
                break;
        }

        if (electrodomestico.getPeso() >= 1 && electrodomestico.getPeso() <= 19) {
            electrodomestico.setPrecio(electrodomestico.getPrecio() + 100);
        } else if (electrodomestico.getPeso() >= 20 && electrodomestico.getPeso() <= 49) {
            electrodomestico.setPrecio(electrodomestico.getPrecio() + 500);
        } else if (electrodomestico.getPeso() >= 50 && electrodomestico.getPeso() <= 79) {
            electrodomestico.setPrecio(electrodomestico.getPrecio() + 800);
        } else {
            electrodomestico.setPrecio(electrodomestico.getPrecio() + 1000);
        }
        return electrodomestico.getPrecio();
    }
}
