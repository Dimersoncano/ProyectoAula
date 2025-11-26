package Logica;

import java.util.List; // Importamos la lista para poder recibir usuarios
import Modelos.Usuario; // Importamos la clase Usuario

/**
 * Implementación de una lista doblemente enlazada diseñada para recorrer
 * usuarios desde el panel de administrador.
 *  
 * Esta estructura permite navegar hacia adelante y hacia atrás entre los
 * elementos, manteniendo un nodo actual que representa el usuario que se está
 * visualizando en un momento dado.
 * Piensa en esto como una fila de personas tomadas de las manos: puedes ir hacia
 * adelante o hacia atrás.
 */
public class ListaDobleUsuarios {

    /**
     * Clase interna que representa cada nodo de la lista.
     * Cada nodo contiene:
     * - Un objeto Usuario.
     * - Una referencia al nodo anterior.
     * - Una referencia al nodo siguiente.
     * Es como si cada persona tuviera una mano agarrada a quien está adelante
     * y otra a quien está atrás.
     */
    private static class Nodo {
        Usuario dato; // Aquí guardamos al usuario
        Nodo anterior; // Quién está antes en la fila
        Nodo siguiente; // Quién está después en la fila

        /**
         * Constructor del nodo.
         * @param dato usuario almacenado en el nodo.
         */
        Nodo(Usuario dato) {
            this.dato = dato; // Guardamos al usuario en este nodo
        }
    }

    /** Primer nodo de la lista. */
    private Nodo cabeza; // Es como el primero de la fila

    /** Último nodo de la lista. */
    private Nodo cola; // El último de la fila

    /** Nodo actualmente seleccionado en la navegación. */
    private Nodo actual; // Usuario que estamos viendo ahora

    /** Cantidad de usuarios almacenados en la lista. */
    private int tamaño; // Cuántos nodos tiene la lista

    /**
     * Constructor de la lista doblemente enlazada.
     * Inicializa punteros en nulo y tamaño en cero.
     * Es como empezar una fila completamente vacía.
     */
    public ListaDobleUsuarios() {
        cabeza = null; // No hay primero
        cola = null;   // No hay último
        actual = null; // No estamos mirando a nadie
        tamaño = 0;    // No hay usuarios
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
            return; // No hay nada que construir
        }

        // Inserta cada usuario como nodo al final de la lista
        for (Usuario u : usuarios) {
            insertarAlFinal(u); // Los vamos agregando al final
        }

        // Una vez construida la lista, el nodo actual se ubica en el primero
        actual = cabeza; // Comenzamos mirando al primero
    }

    /**
     * Inserta un nuevo nodo al final de la lista.
     *
     * @param usuario el usuario que se quiere agregar como nodo.
     */
    private void insertarAlFinal(Usuario usuario) {
        Nodo nuevo = new Nodo(usuario); // Creamos el nuevo nodo

        // Si la lista está vacía, el nuevo nodo es cabeza y cola
        if (cabeza == null) {
            cabeza = nuevo; // Ahora él es el primero
            cola = nuevo;   // Y también el último
        } else {
            // Conexión con el último nodo y actualización de cola
            cola.siguiente = nuevo; // El antiguo último apunta al nuevo
            nuevo.anterior = cola;  // El nuevo sabe quién estaba antes
            cola = nuevo;           // Ahora el nuevo es el último
        }

        tamaño++; // La lista crece en uno
    }

    /**
     * Indica si la lista está vacía.
     *
     * @return true si no contiene elementos, false si tiene al menos uno.
     */
    public boolean estaVacia() {
        return tamaño == 0; // No hay nodos
    }

    /**
     * Retorna el tamaño actual de la lista.
     *
     * @return cantidad de usuarios almacenados.
     */
    public int getTamaño() {
        return tamaño; // Devolvemos cuántos hay en la fila
    }

    /**
     * Obtiene el usuario correspondiente al nodo actual.
     *
     * @return usuario del nodo actual, o null si no hay nodo posicionado.
     */
    public Usuario getActual() {
        return (actual != null) ? actual.dato : null; // Devolvemos a quien estamos mirando
    }

    /**
     * Verifica si existe un nodo siguiente al actual.
     *
     * @return true si hay un siguiente, false si el actual es el último.
     */
    public boolean haySiguiente() {
        return actual != null && actual.siguiente != null; // ¿Hay alguien adelante?
    }

    /**
     * Verifica si existe un nodo anterior al actual.
     *
     * @return true si hay anterior, false si el actual es el primero.
     */
    public boolean hayAnterior() {
        return actual != null && actual.anterior != null; // ¿Hay alguien atrás?
    }

    /**
     * Avanza el nodo actual hacia el siguiente en la lista.
     *
     * @return el usuario del nuevo nodo actual, o null si no hay siguiente.
     */
    public Usuario irSiguiente() {
        if (haySiguiente()) { // Si hay alguien adelante
            actual = actual.siguiente; // Caminamos hacia adelante
            return actual.dato; // Mostramos al nuevo usuario
        }
        return null; // No se puede avanzar
    }

    /**
     * Retrocede el nodo actual hacia el anterior en la lista.
     *
     * @return el usuario del nuevo nodo actual, o null si no hay anterior.
     */
    public Usuario irAnterior() {
        if (hayAnterior()) { // Si hay alguien atrás
            actual = actual.anterior; // Caminamos hacia atrás
            return actual.dato; // Mostramos al usuario anterior
        }
        return null; // No se puede retroceder
    }

    /**
     * Posiciona el nodo actual en la cabeza de la lista.
     * Útil para reiniciar la navegación.
     */
    public void irAlPrimero() {
        actual = cabeza; // Miramos al primero en la fila
    }

    /**
     * Posiciona el nodo actual en la cola de la lista.
     * Permite acceder directamente al último usuario.
     */
    public void irAlUltimo() {
        actual = cola; // Miramos al último
    }
}
