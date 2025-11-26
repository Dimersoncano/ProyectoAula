package Logica;


/**
* Clase base para excepciones personalizadas dentro del sistema de la billetera virtual.
* Puede ser usada como superclase de otras excepciones específicas.
*/
public class Excepcion extends Exception {


/**
* Constructor que permite definir un mensaje personalizado para la excepción.
* @param mensaje Descripción del error.
*/
public Excepcion(String mensaje) {
super(mensaje); // Llama al constructor de la clase Exception y guarda el mensaje de error
}
}
