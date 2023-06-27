package servicio;

import entidad.Poliza;
import enums.FormaPago;
import enums.TipoCobertura;
import java.time.LocalDate;
import java.util.Scanner;

public class PolizaServicio {

    public Poliza contratarSeguro() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PersonaServicio ps = new PersonaServicio();
        VehiculoServicio vs = new VehiculoServicio();
        Poliza poliza = new Poliza();
        poliza.setPersona(ps.registrarPersona());
        poliza.setVehiculo(vs.registrarVehiculo());
        System.out.println("Ingrese el numero de poliza");
        poliza.setNumeroPoliza(leer.nextInt());
        System.out.println("Ingrese el inicio de la poliza");
        poliza.setFechaInicio(LocalDate.now());
        System.out.println("Ingrese la finalizacion de la poliza");
        poliza.setFinPoliza(LocalDate.of(2024, 6, 4));
        System.out.println("Elija el método de pago");
        int formaPago = leer.nextInt();
        poliza.setPago(FormaPago.values()[formaPago]);
        System.out.println("Ingrese la cantidad de cuotas");
        poliza.setCantidadCuotas(poliza.getFinPoliza(), poliza.getFechaInicio(), FormaPago.values()[formaPago]);
        System.out.println("Ingrese el monto total que cubre");
        poliza.setMontoTotal(leer.nextDouble());
        System.out.println("Cubre granizo? S/N");
        poliza.setGranizo(false);
        if (leer.next().charAt(0) == 'S') {
            poliza.setGranizo(true);
            if (poliza.isGranizo()) {
                System.out.println("Ingrese el monto de cobertura por granizo");
                poliza.setMontoGranizo(leer.nextDouble());
            }
        }
        System.out.println("Seleccione el tipo de cobertura");
        int cobertura = leer.nextInt();
        poliza.setTipoCobertura(TipoCobertura.values()[cobertura]);
        return poliza;
    }

}
