package Modelos;

import java.io.Serializable;
/**
 * Representa una tarjeta bancaria asociada al usuario en la billetera virtual.
 *
 * Explicado como para un niño:
 * Imagina que esta clase es como una tarjeta que usas para sacar dinero,
 * pagar cosas o poner dinero en tu alcancía digital.
 * La tarjeta tiene un número, una fecha de vencimiento y un código secreto.
 */
public class TarjetaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;

    // Aquí guardamos el número de la tarjeta, como los 16 dígitos que ves en una real.
    private String numero;

    // Aquí guardamos cuándo deja de servir la tarjeta (su fecha de expiración).
    private String fechaExpiracion;

    // Aquí está el código secreto que normalmente tiene 3 números (el CVV).
    private String cvv;

    /**
     * Constructor de tarjeta bancaria.
     *
     * Explicado como para un niño:
     * Cuando creamos una tarjeta, tenemos que decirle:
     *  - cuál es su número,
     *  - cuándo se vence,
     *  - y cuál es su código secreto.
     *
     * @param numero Número de la tarjeta (normalmente 16 dígitos).
     * @param fechaExpiracion Fecha de vencimiento en formato MM/AA.
     * @param cvv Código de seguridad (normalmente 3 dígitos).
     */
    public TarjetaBancaria(String numero, String fechaExpiracion, String cvv) {
        this.numero = numero;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }

    // Getters y Setters
    // Explicado como para un niño:
    // Estos son como pequeñas puertas que te dejan ver o cambiar la información
    // de la tarjeta sin tocarla directamente.

    public String getNumero() {
        // Devuelve el número de la tarjeta.
        return numero;
    }

    public void setNumero(String numero) {
        // Permite cambiar el número de la tarjeta por otro.
        this.numero = numero;
    }

    public String getFechaExpiracion() {
        // Devuelve la fecha de vencimiento.
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        // Permite cambiar la fecha de vencimiento.
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCvv() {
        // Devuelve el código secreto de la tarjeta.
        return cvv;
    }

    public void setCvv(String cvv) {
        // Permite cambiar el código secreto.
        this.cvv = cvv;
    }
}
