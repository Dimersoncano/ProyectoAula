package Logica;

/**
 * Esta clase es como un "ayudante" que revisa si las contraseñas
 * son buenas y si cumplen reglas simples de seguridad.
 * 
 * Piensa en esto como un guardia que revisa si tu clave
 * es lo suficientemente larga y si coincide con otra.
 */
public class Seguridad {

    /**
     * Este método revisa si una contraseña es válida.
     * Para explicarlo como a un niño:
     * 
     * Imagina que tienes una llave secreta (contraseña).
     * Para que sea una buena llave, debe tener al menos 6 caracteres,
     * porque una llave muy corta es fácil de adivinar.
     *
     * @param contraseña La contraseña que queremos revisar.
     * @return true si la contraseña NO está vacía y tiene 6 o más letras/números.
     */
    public static boolean validarContraseña(String contraseña) {
        return contraseña != null && contraseña.length() >= 6;
    }

    /**
     * Este método revisa si dos contraseñas son iguales.
     * 
     * Imagina que escribes tu clave dos veces para asegurarte
     * de que no te equivocaste. Este método compara ambas escrituras
     * y dice "sí, son iguales" o "no, una está distinta".
     *
     * @param c1 La primera contraseña escrita.
     * @param c2 La segunda contraseña escrita.
     * @return true si ambas contraseñas son exactamente iguales.
     */
    public static boolean coinciden(String c1, String c2) {
        return c1 != null && c1.equals(c2);
    }
}
