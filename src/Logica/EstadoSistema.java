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

    private static final long serialVersionUID = 1L;

    private List<Usuario> usuarios;
    private Administrador administrador;
    private Configuracion configuracion;

    public EstadoSistema(List<Usuario> usuarios, Administrador administrador, Configuracion configuracion) {
        this.usuarios = usuarios;
        this.administrador = administrador;
        this.configuracion = configuracion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }
}

