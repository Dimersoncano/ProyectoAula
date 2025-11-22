package Modelos;

import java.io.Serializable;
/**
 * Clase que representa parámetros de configuración del sistema.
 * Por ejemplo, puede definir montos máximos o días de espera.
 */

public class Configuracion implements Serializable {

    private static final long serialVersionUID = 1L;
    private double montoMaximo;
    private int diasEspera;

    /**
     * Constructor para establecer los valores iniciales de configuración.
     * @param montoMaximo Monto máximo permitido por operación o usuario.
     * @param diasEspera Días de espera para ciertos procesos (ej. validaciones).
     */
    public Configuracion(double montoMaximo, int diasEspera) {
        this.montoMaximo = montoMaximo;
        this.diasEspera = diasEspera;
    }

    // Getters y Setters
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
