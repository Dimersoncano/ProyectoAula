package Modelos;

import java.io.Serializable;    
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un sistema de notificaciones básicas para el usuario.
 * Puede utilizarse para mensajes como alertas de recarga, envíos, etc.
 */
public class Notificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<String> mensajes;

    /**
     * Constructor que inicializa la lista de mensajes vacía.
     */
    public Notificaciones() {
        mensajes = new ArrayList<>();
    }

    /**
     * Agrega un nuevo mensaje al historial de notificaciones.
     * @param mensaje Contenido de la notificación.
     */
    public void agregarNotificacion(String mensaje) {
        mensajes.add(mensaje);
    }

    /**
     * Retorna todas las notificaciones registradas.
     * @return Lista de mensajes.
     */
    public List<String> obtenerNotificaciones() {
        return mensajes;
    }

    /**
     * Borra todas las notificaciones.
     */
    public void limpiarNotificaciones() {
        mensajes.clear();
    }
}
