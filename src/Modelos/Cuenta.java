package Modelos;

/**
 * Representa una cuenta bancaria dentro de la billetera virtual.
 * Está asociada a un usuario y tiene un número, saldo y tipo.
 */
public class Cuenta {

    private String numeroCuenta;
    private double saldo;
    private String tipo; // Ej: "Ahorros", "Corriente"

    /**
     * Constructor de cuenta bancaria.
     * @param numeroCuenta Identificador único de la cuenta.
     * @param saldo Saldo inicial.
     * @param tipo Tipo de cuenta (Ahorros, Corriente, etc.).
     */
    public Cuenta(String numeroCuenta, double saldo, String tipo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    // Getters y Setters

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
