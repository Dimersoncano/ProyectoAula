package Modelos;

import java.io.Serializable;
/**
 * Esta clase representa una CUENTA BANCARIA dentro de la billetera virtual.
 *
 * Explicado como para un niño:
 * Imagina que cada usuario tiene una alcancía especial.
 * Esa alcancía tiene:
 *   - un número que la identifica (como un nombre único),
 *   - una cantidad de dinero guardada (saldo),
 *   - y un tipo (por ejemplo: "Ahorros" o "Corriente").
 *
 * Esta clase guarda esa información. También se puede guardar en un archivo,
 * como si le sacáramos una foto para que no se pierda.
 */
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Número de la cuenta, como el nombre especial de la alcancía.
    private String numeroCuenta;

    // El dinero que tiene guardado la cuenta.
    private double saldo;

    // El tipo de cuenta, por ejemplo "Ahorros" o "Corriente".
    private String tipo;

    /**
     * Constructor de cuenta bancaria.
     *
     * Explicado como para un niño:
     * Cuando se crea una alcancía nueva, le decimos:
     *   - cuál será su número,
     *   - cuánto dinero empieza teniendo,
     *   - y qué tipo de alcancía es.
     *
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
    // Son como pequeñas ventanitas para ver o cambiar los datos guardados.

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
