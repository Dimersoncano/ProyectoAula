package Logica;

/**
 * Esta clase es una "excepción", que es como una alarma especial
 * que se activa cuando algo sale mal.
 *
 * En este caso, esta alarma suena cuando alguien intenta iniciar sesión,
 * pero el sistema NO encuentra a un usuario con esos datos.
 *
 * Es como cuando buscas a un amigo en una lista y no aparece,
 * entonces dices: "¡No lo encontré!"
 */
public class UsuarioNoEncontradoException extends Excepcion {

    /**
     * Este es el constructor.
     * 
     * Para explicarlo como a un niño:
     * Aquí simplemente le decimos a la alarma (la excepción)
     * qué mensaje debe mostrar cuando se active.
     *
     * @param mensaje Un mensaje explicando qué salió mal.
     */
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje); // Llama al constructor de la clase "Excepcion" con el mensaje.
    }
}
