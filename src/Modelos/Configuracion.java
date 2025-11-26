package Modelos;

import java.io.Serializable;
/**
 * Esta clase representa la "Configuración" del sistema de la billetera.
 *
 * Explicado como para un niño:
 * Imagina que la billetera virtual es como un juego.
 * Y este juego necesita reglas, por ejemplo:
 *   - ¿Cuál es el monto máximo que un usuario puede mover?
 *   - ¿Cuántos días debe esperar para hacer algo especial?
 *
 * Esta clase guarda justamente esas reglas.
 * También se puede guardar en un archivo (por eso usa Serializable),
 * como si se tomara una foto de las reglas para recordarlas luego.
 */

public class Configuracion implements Serializable {

    private static final long serialVersionUID = 1L;

    // El máximo de dinero que se puede usar en una operación o en un usuario.
    private double montoMaximo;

    // Cuántos días hay que esperar para algunas acciones especiales.
    private int diasEspera;

    /**
     * Constructor para establecer los valores iniciales de configuración.
     *
     * Explicado como para un niño:
     * Cuando creamos la configuración, le decimos:
     * "Estas son las reglas del juego: este es el límite de dinero,
     * y estos son los días que hay que esperar".
     *
     * @param montoMaximo Monto máximo permitido por operación o usuario.
     * @param diasEspera Días de espera para ciertos procesos (ej. validaciones).
     */
    public Configuracion(double montoMaximo, int diasEspera) {
        this.montoMaximo = montoMaximo;
        this.diasEspera = diasEspera;
    }

    // Getters y Setters
    // Son como puertas pequeñas que permiten ver o cambiar los valores guardados.

    public double getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(double montoMaximo) {
        this.montoMaximo = montoMaximo;
    }

    public int getDiasEspera() {
        return diasEspera;
    }

    public void setDiasEspera(int diasEspera) {
        this.diasEspera = diasEspera;
    }
}
