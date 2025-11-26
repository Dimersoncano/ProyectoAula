package Modelos;

import java.io.Serializable;    
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa un sistema de NOTIFICACIONES para el usuario.
 *
 * Explicado como para un niño:
 * Imagina que tienes una cajita donde guardas papelitos con mensajes importantes,
 * como:
 *   - "Recargaste dinero"
 *   - "Te llegó un pago"
 *   - "Enviaron dinero desde tu cuenta"
 *
 * Esta clase es esa cajita. Guarda los mensajes y te permite verlos o limpiarlos.
 */
public class Notificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Aquí guardamos todos los mensajes que se envían al usuario.
    private List<String> mensajes;

    /**
     * Constructor que inicializa la lista de mensajes vacía.
     *
     * Explicado como para un niño:
     * Cuando creamos la cajita de mensajes, empieza vacía,
     * sin ningún papelito adentro.
     */
    public Notificaciones() {
        mensajes = new ArrayList<>();
    }

    /**
     * Agrega un nuevo mensaje al historial de notificaciones.
     *
     * Explicado como para un niño:
     * Es como meter un nuevo papelito con un aviso dentro de la cajita.
     *
     * @param mensaje Contenido de la notificación.
     */
    public void agregarNotificacion(String mensaje) {
        mensajes.add(mensaje);
    }

    /**
     * Retorna todas las notificaciones registradas.
     *
     * Explicado como para un niño:
     * Si quieres ver todo lo que tienes en la cajita,
     * este método te las muestra todas.
     *
     * @return Lista de mensajes.
     */
    public List<String> obtenerNotificaciones() {
        return mensajes;
    }

    /**
     * Borra todas las notificaciones.
     *
     * Explicado como para un niño:
     * Es como vaciar la cajita y botar todos los papelitos.
     */
    public void limpiarNotificaciones() {
        mensajes.clear();
    }
}
