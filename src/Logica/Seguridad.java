package Logica;

/**
 * Clase de utilidades para validar contraseñas u otras reglas de seguridad.
 */
public class Seguridad {

    /**
     * Verifica si una contraseña cumple con una longitud mínima.
     * @param contraseña Contraseña a verificar.
     * @return true si la contraseña es válida, false en caso contrario.
     */
    public static boolean validarContraseña(String contraseña) {
        return contraseña != null && contraseña.length() >= 6;
    }

    /**
     * Verifica si dos contraseñas coinciden.
     * @param c1 Primera contraseña.
     * @param c2 Segunda contraseña.
     * @return true si son iguales, false si no coinciden.
     */
    public static boolean coinciden(String c1, String c2) {
        return c1 != null && c1.equals(c2);
    }
}
