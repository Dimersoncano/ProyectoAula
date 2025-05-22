package Modelos;

/**
 * Representa una tarjeta bancaria asociada al usuario en la billetera virtual.
 * Puede usarse para recargar saldo, verificar identidad o realizar pagos.
 */
public class TarjetaBancaria {

    private String numero;
    private String fechaExpiracion;
    private String cvv;

    /**
     * Constructor de tarjeta bancaria.
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
