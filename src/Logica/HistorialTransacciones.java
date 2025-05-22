package Logica;

import Modelos.Transaccion;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase auxiliar que permite agrupar y manejar un historial de transacciones.
 */
public class HistorialTransacciones {

    private List<Transaccion> transacciones;

    /**
     * Constructor que inicializa una lista vacía de transacciones.
     */
    public HistorialTransacciones() {
        this.transacciones = new ArrayList<>();
    }

    /**
     * Agrega una transacción al historial.
     * @param transaccion La transacción a agregar.
     */
    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    /**
     * Retorna la lista completa de transacciones registradas.
     * @return Lista de transacciones.
     */
    public List<Transaccion> obtenerHistorial() {
        return transacciones;
    }
}
