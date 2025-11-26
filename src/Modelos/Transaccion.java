package Modelos;

import java.io.Serializable;
import java.util.Date;

/**
 * Representa una transacción dentro de la billetera virtual.
 *
 * Explicado como para un niño:
 * Una transacción es como cuando haces un movimiento de dinero.
 * Por ejemplo: poner dinero en tu alcancía digital, mandar dinero a un amigo,
 * o pagar algo. Cada vez que haces uno de esos movimientos, se guarda
 * una "tarjeta de recuerdo" llamada Transacción que dice:
 *  - qué tipo de movimiento fue,
 *  - cuánto dinero moviste,
 *  - por qué lo hiciste,
 *  - y en qué fecha ocurrió.
 */
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Aquí guardamos qué tipo de movimiento fue (por ejemplo, "Recarga" o "Envío").
    private String tipo;

    // Aquí guardamos cuánto dinero se usó en el movimiento.
    private double monto;

    // Aquí guardamos una explicación de por qué se hizo la transacción.
    private String descripcion;

    // Aquí guardamos la fecha exacta en la que ocurrió la transacción.
    private Date fecha;

    /**
     * Constructor completo para registrar una transacción.
     *
     * Explicado como para un niño:
     * Cuando creamos una transacción nueva, le decimos:
     *  - qué tipo de movimiento fue,
     *  - cuánta plata se movió,
     *  - y una descripción de qué pasó.
     *
     * La fecha se pone sola con la fecha del momento actual.
     *
     * @param tipo Tipo de transacción.
     * @param monto Monto involucrado.
     * @param descripcion Texto descriptivo de la transacción.
     */
    public Transaccion(String tipo, double monto, String descripcion) {
        this.tipo = tipo;           // Guardamos el tipo de movimiento
        this.monto = monto;         // Guardamos cuánto dinero se movió
        this.descripcion = descripcion; // Guardamos la explicación
        this.fecha = new Date();    // Guardamos la fecha de hoy automáticamente
    }

    // Getters y Setters
    // Explicado como para un niño:
    // Estas son como pequeñas puertas para ver o cambiar los datos
    // de la transacción sin tocar los valores directamente.

    public String getTipo() {
        // Devuelve el tipo de movimiento.
        return tipo;
    }

    public void setTipo(String tipo) {
        // Permite cambiar el tipo de movimiento.
        this.tipo = tipo;
    }

    public double getMonto() {
        // Devuelve cuánto dinero se movió.
        return monto;
    }

    public void setMonto(double monto) {
        // Permite cambiar el monto del movimiento.
        this.monto = monto;
    }

    public String getDescripcion() {
        // Devuelve la explicación de la transacción.
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        // Permite cambiar la descripción.
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        // Devuelve la fecha en la que se hizo el movimiento.
        return fecha;
    }

    public void setFecha(Date fecha) {
        // Permite cambiar la fecha (por si se necesita corregir).
        this.fecha = fecha;
    }
}
