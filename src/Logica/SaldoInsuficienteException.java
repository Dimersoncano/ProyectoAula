package Logica;

/**
 * Excepción personalizada que se lanza cuando un usuario intenta realizar
 * una operación (como enviar dinero) sin tener saldo suficiente.
 */
public class SaldoInsuficienteException extends Excepcion {

    /**
     * Constructor que recibe un mensaje específico sobre el error.
     * @param mensaje Mensaje descriptivo del error.
     */
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
