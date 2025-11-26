package Logica;


import java.io.Serializable;
import java.util.List;
import Modelos.Usuario;
import Modelos.Administrador;
import Modelos.Configuracion;


/**
* Clase que representa el estado completo de la billetera
* para poder guardarlo y cargarlo desde disco.
*/
public class EstadoSistema implements Serializable {


private static final long serialVersionUID = 1L; // Esto es como un número de identificación para guardar y cargar la información


private List<Usuario> usuarios; // Aquí se guarda una lista con todos los usuarios
private Administrador administrador; // Aquí se guarda al administrador del sistema
private Configuracion configuracion; // Aquí se guarda la configuración general del sistema


public EstadoSistema(List<Usuario> usuarios, Administrador administrador, Configuracion configuracion) {
this.usuarios = usuarios; // Se guarda la lista de usuarios
this.administrador = administrador; // Se guarda el administrador
this.configuracion = configuracion; // Se guarda la configuración
}


public List<Usuario> getUsuarios() {
return usuarios; // Devuelve la lista de usuarios
}


public Administrador getAdministrador() {
return administrador; // Devuelve al administrador
}


public Configuracion getConfiguracion() {
return configuracion; // Devuelve la configuración
}
}