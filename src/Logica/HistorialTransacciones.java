package Logica;


import Modelos.Transaccion; // Importamos la clase Transaccion para poder usarla aquí
import java.util.ArrayList; // Importamos ArrayList para crear listas que pueden crecer
import java.util.List; // Importamos List, que es una interfaz para manejar listas


/**
* Clase auxiliar que permite agrupar y manejar un historial de transacciones.
* Piensa en esto como una libreta donde se anotan todos los movimientos de dinero.
*/
public class HistorialTransacciones {


private List<Transaccion> transacciones; // Aquí guardamos todas las transacciones como si fuera una lista de registros


/**
* Constructor que inicializa una lista vacía de transacciones.
* Es como empezar con una libreta totalmente en blanco.
*/
public HistorialTransacciones() {
this.transacciones = new ArrayList<>(); // Creamos la lista donde guardaremos las transacciones
}


/**
* Agrega una transacción al historial.
* @param transaccion La transacción a agregar.
* Esto es como escribir un nuevo movimiento en nuestra libreta.
*/
public void agregarTransaccion(Transaccion transaccion) {
transacciones.add(transaccion); // Añadimos la transacción a la lista
}


/**
* Retorna la lista completa de transacciones registradas.
* @return Lista de transacciones.
* Esto devuelve toda la libreta con cada movimiento registrado.
*/
public List<Transaccion> obtenerHistorial() {
return transacciones; // Devolvemos todas las transacciones guardadas
}
}
