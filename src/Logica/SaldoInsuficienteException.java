package Logica;

/**
 * Esta es una "excepción", que es como una alarma especial
 * que se prende cuando ocurre un problema.
 *
 * Aquí la alarma se usa cuando un usuario quiere hacer algo
 * como enviar dinero, pero no tiene suficiente. Es como cuando
 * quieres comprar algo en la tienda pero tu alcancía no tiene
 * monedas suficientes: el sistema dice "¡No puedes!".
 */
public class SaldoInsuficienteException extends Excepcion {

    /**
     * Este es el constructor. Es como crear la alarma y ponerle
     * un mensaje para explicar qué salió mal.
     * @param mensaje Un texto que explica el error.
     */
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje); // Llama al constructor del papá (Excepcion) para guardar el mensaje.
    }
}
