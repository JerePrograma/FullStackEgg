package servicio;

//• Método crearTelevisor(): este método llama a crearElectrodomestico() de la clase
import entidad.Electrodomestico;
import entidad.Televisor;

//padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
//los atributos del televisor.
//• Método precioFinal(): este método será heredado y se le sumará la siguiente
//funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
//incrementará el precio un 30% y si tiene un sintonizador TDT incorporado, aumentará
//$500. Recuerda que las condiciones que hemos visto en la clase Electrodomestico
//también deben afectar al precio.
public class TelevisorServicio extends ElectrodomesticoServicio {

    public Televisor crearTelevisor() {
        Electrodomestico elec = crearElectrodomestico();
        System.out.println("Ingresa la resolución (en pulgadas) del televisor");
        int pulgadas = leer.nextInt();
        System.out.println("Tiene sintonizador? (S/N)");
        boolean sintonizador = false;
        if (leer.next().equalsIgnoreCase("S")) {
            sintonizador = true;
        }
        return new Televisor(elec.getPrecio(), elec.getColor(), elec.getConsumoEnergetico(), elec.getPeso(), pulgadas, sintonizador);
    }

    public double precioFinal(Televisor televisor) {
        super.precioFinal(televisor);
        if (televisor.getResolucion() > 40) {
            televisor.setPrecio(televisor.getPrecio() * 1.3);
        }
        if (televisor.isSintonizadorTDT()) {
            televisor.setPrecio(televisor.getPrecio() + 500);
        }

        return televisor.getPrecio();
    }
}
