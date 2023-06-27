package entidad;

import enums.FormaPago;
import java.time.LocalDate;
import java.util.Date;

public class Cuota {

    private int numeroCuota;
    private double montoCuota;
    private boolean pagado;
    private LocalDate fechaVecimiento;
    private FormaPago formaPago;

    public Cuota(int numeroCuota, double montoCuota, boolean pagado, LocalDate fechaVecimiento, FormaPago formaPago) {
        this.numeroCuota = numeroCuota;
        this.montoCuota = montoCuota;
        this.pagado = pagado;
        this.fechaVecimiento = fechaVecimiento;
        this.formaPago = formaPago;
    }

    public Cuota() {
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(double montoCuota) {
        this.montoCuota = montoCuota;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public LocalDate getFechaVecimiento() {
        return fechaVecimiento;
    }

    public void setFechaVecimiento(LocalDate fechaVecimiento) {
        this.fechaVecimiento = fechaVecimiento;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

}
