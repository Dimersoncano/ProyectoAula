package Logica;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un usuario
 * con las credenciales proporcionadas durante el inicio de sesión.
 */
public class UsuarioNoEncontradoException extends Excepcion {

    /**
     * Constructor que permite pasar un mensaje personalizado de error.
     * @param mensaje Mensaje explicativo.
     */
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
