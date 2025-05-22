package Modelos;

import java.util.Date;

/**
 * Representa una transacción dentro de la billetera virtual.
 * Puede ser de tipo "Recarga", "Envío", "Pago", entre otros.
 */
public class Transaccion {

    private String tipo;          // Tipo de transacción (Ej: "Recarga", "Envío")
    private double monto;         // Monto de dinero involucrado
    private String descripcion;   // Descripción o motivo
    private Date fecha;           // Fecha en que se registró la transacción

    /**
     * Constructor completo para registrar una transacción.
     * @param tipo Tipo de transacción.
     * @param monto Monto involucrado.
     * @param descripcion Texto descriptivo de la transacción.
     */
    public Transaccion(String tipo, double monto, String descripcion) {
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = new Date(); // Fecha actual por defecto
    }

    // Getters y Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
