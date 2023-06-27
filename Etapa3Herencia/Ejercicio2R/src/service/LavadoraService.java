//• Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
//padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
//el atributo propio de la lavadora.
//• Método precioFinal(): este método será heredado y se le sumará la siguiente
//funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
//carga es menor o igual, no se incrementará el precio. Este método debe llamar al
//método padre y añadir el código necesario. Recuerda que las condiciones que hemos
//visto en la clase Electrodoméstico también deben afectar al precio.
package service;

import entidad.Electrodomestico;
import entidad.Lavadora;

public class LavadoraService extends ElectrodomesticoService {

    public Lavadora crearLavadora() {
        Electrodomestico electro = crearElectrodomestico();
        Lavadora lavadora = new Lavadora();
        lavadora.setColor(electro.getColor());
        lavadora.setConsumoEnergetico(electro.getConsumoEnergetico());
        lavadora.setPeso(electro.getPeso());
        lavadora.setPrecio(electro.getPrecio());
        System.out.println("Ingrese la carga de la lavadora");
        int carga = leer.nextInt();
        lavadora.setCarga(carga);
        return lavadora;
    }

    public void precioFinal(Lavadora lavadora) {
        super.precioFinal(lavadora);
        if (lavadora.getCarga() > 30) {
            lavadora.setPrecio(lavadora.getPrecio() + 500);
        }
        System.out.println("El precio de la lavadora es " + lavadora.getPrecio());
    }
}
