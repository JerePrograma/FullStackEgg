package entidad;

import enums.FormaPago;
import enums.TipoCobertura;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;

public class Poliza {

    private Vehiculo vehiculo;
    private Persona persona;
    private ArrayList<Cuota> cantidadCuotas;
    private int numeroPoliza;
    private LocalDate fechaInicio;
    private LocalDate finPoliza;
    private FormaPago pago;
    private double montoTotal;
    private boolean granizo;
    private double montoGranizo;
    private TipoCobertura tipoCobertura;

    public Poliza(Vehiculo vehiculo, Persona persona, ArrayList<Cuota> cantidadCuotas, int numeroPoliza, LocalDate fechaInicio, LocalDate finPoliza, FormaPago pago, double montoTotal, boolean granizo, double montoGranizo, TipoCobertura tipoCobertura) {
        this.vehiculo = vehiculo;
        this.persona = persona;
        this.cantidadCuotas = cantidadCuotas;
        this.numeroPoliza = numeroPoliza;
        this.fechaInicio = fechaInicio;
        this.finPoliza = finPoliza;
        this.pago = pago;
        this.montoTotal = montoTotal;
        this.granizo = granizo;
        this.montoGranizo = montoGranizo;
        this.tipoCobertura = tipoCobertura;
    }

    public Poliza() {
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ArrayList<Cuota> getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(LocalDate fin, LocalDate inicio, FormaPago formaPago) {
        ArrayList<Cuota> cuotas = new ArrayList();
        int meses = Period.between(fin, inicio).getMonths();
        for (int i = 0; i < meses; i++) {
            Cuota cuota = new Cuota();
            cuota.setNumeroCuota(i + 1);
            cuota.setFechaVecimiento(inicio.plusMonths(i + 1));
            cuota.setFormaPago(formaPago);
            cuota.setMontoCuota(1000);
            cuota.setPagado(false);
        }
    }

    public int getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(int numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFinPoliza() {
        return finPoliza;
    }

    public void setFinPoliza(LocalDate finPoliza) {
        this.finPoliza = finPoliza;
    }

    public FormaPago getPago() {
        return pago;
    }

    public void setPago(FormaPago pago) {
        this.pago = pago;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public boolean isGranizo() {
        return granizo;
    }

    public void setGranizo(boolean granizo) {
        this.granizo = granizo;
    }

    public double getMontoGranizo() {
        return montoGranizo;
    }

    public void setMontoGranizo(double montoGranizo) {
        this.montoGranizo = montoGranizo;
    }

    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

}
