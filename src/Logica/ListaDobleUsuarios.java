package Logica;

import java.util.List;
import Modelos.Usuario;

/**
 * Implementación de una lista doblemente enlazada diseñada para recorrer
 * usuarios desde el panel de administrador.
 *  
 * Esta estructura permite navegar hacia adelante y hacia atrás entre los
 * elementos, manteniendo un nodo actual que representa el usuario que se está
 * visualizando en un momento dado.
 */
public class ListaDobleUsuarios {

    /**
     * Clase interna que representa cada nodo de la lista.
     * Cada nodo contiene:
     * - Un objeto Usuario.
     * - Una referencia al nodo anterior.
     * - Una referencia al nodo siguiente.
     */
    private static class Nodo {
        Usuario dato;
        Nodo anterior;
        Nodo siguiente;

        /**
         * Constructor del nodo.
         * @param dato usuario almacenado en el nodo.
         */
        Nodo(Usuario dato) {
            this.dato = dato;
        }
    }

    /** Primer nodo de la lista. */
    private Nodo cabeza;

    /** Último nodo de la lista. */
    private Nodo cola;

    /** Nodo actualmente seleccionado en la navegación. */
    private Nodo actual;

    /** Cantidad de usuarios almacenados en la lista. */
    private int tamaño;

    /**
     * Constructor de la lista doblemente enlazada.
     * Inicializa punteros en nulo y tamaño en cero.
     */
    public ListaDobleUsuarios() {
        cabeza = null;
        cola = null;
        actual = null;
        tamaño = 0;
    }

    /**
     * Construye la lista doblemente enlazada a partir de una lista de usuarios.
     * Cada vez que se llama, elimina toda la estructura previa y la reconstruye.
     *
     * @param usuarios lista de usuarios cargada desde LogicaBilletera.
     */
    public void construirDesdeLista(List<Usuario> usuarios) {
        // Reinicia toda la lista para evitar valores residuales
        cabeza = null;
        cola = null;
        actual = null;
        tamaño = 0;

        // Si la lista recibida es nula o vacía, se deja la lista enlazada vacía
        if (usuarios == null || usuarios.isEmpty()) {
            return;
        }

        // Inserta cada usuario como nodo al final de la lista
        for (Usuario u : usuarios) {
            insertarAlFinal(u);
        }

        // Una vez construida la lista, el nodo actual se ubica en el primero
        actual = cabeza;
    }

    /**
     * Inserta un nuevo nodo al final de la lista.
     *
     * @param usuario el usuario que se quiere agregar como nodo.
     */
    private void insertarAlFinal(Usuario usuario) {
        Nodo nuevo = new Nodo(usuario);

        // Si la lista está vacía, el nuevo nodo es cabeza y cola
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            // Conexión con el último nodo y actualización de cola
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }

        tamaño++;
    }

    /**
     * Indica si la lista está vacía.
     *
     * @return true si no contiene elementos, false si tiene al menos uno.
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }

    /**
     * Retorna el tamaño actual de la lista.
     *
     * @return cantidad de usuarios almacenados.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Obtiene el usuario correspondiente al nodo actual.
     *
     * @return usuario del nodo actual, o null si no hay nodo posicionado.
     */
    public Usuario getActual() {
        return (actual != null) ? actual.dato : null;
    }

    /**
     * Verifica si existe un nodo siguiente al actual.
     *
     * @return true si hay un siguiente, false si el actual es el último.
     */
    public boolean haySiguiente() {
        return actual != null && actual.siguiente != null;
    }

    /**
     * Verifica si existe un nodo anterior al actual.
     *
     * @return true si hay anterior, false si el actual es el primero.
     */
    public boolean hayAnterior() {
        return actual != null && actual.anterior != null;
    }

    /**
     * Avanza el nodo actual hacia el siguiente en la lista.
     *
     * @return el usuario del nuevo nodo actual, o null si no hay siguiente.
     */
    public Usuario irSiguiente() {
        if (haySiguiente()) {
            actual = actual.siguiente;
            return actual.dato;
        }
        return null;
    }

    /**
     * Retrocede el nodo actual hacia el anterior en la lista.
     *
     * @return el usuario del nuevo nodo actual, o null si no hay anterior.
     */
    public Usuario irAnterior() {
        if (hayAnterior()) {
            actual = actual.anterior;
            return actual.dato;
        }
        return null;
    }

    /**
     * Posiciona el nodo actual en la cabeza de la lista.
     * Útil para reiniciar la navegación.
     */
    public void irAlPrimero() {
        actual = cabeza;
    }

    /**
     * Posiciona el nodo actual en la cola de la lista.
     * Permite acceder directamente al último usuario.
     */
    public void irAlUltimo() {
        actual = cola;
    }
}
