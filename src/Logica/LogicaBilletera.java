package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Modelos.Usuario;
import Modelos.Cuenta;
import Modelos.Transaccion;
import Modelos.Administrador;
import Modelos.Configuracion;

/**
 * Clase que maneja la lógica principal de la billetera virtual.
 * Ahora incluye persistencia total del sistema.
 */
public class LogicaBilletera {

    private List<Usuario> usuarios;
    private Administrador administrador;
    private Configuracion configuracion;

    // Archivo donde se guardará TODO
    private static final String ARCHIVO_ESTADO = "estado_billetera.dat";

    /**
     * Constructor
     * Carga el estado si existe, si no crea un sistema por defecto.
     */
    public LogicaBilletera() {
        cargarEstado();  // 🔥 intentamos recuperar todo

        if (usuarios == null) {
            inicializarSistemaPorDefecto();
        }
    }

    /**
     * Inicializa el sistema si nunca ha sido guardado.
     */
    private void inicializarSistemaPorDefecto() {
        this.usuarios = new ArrayList<>();
        this.configuracion = new Configuracion(1000.0, 30);
        this.administrador = new Administrador("admin", "admin123");

        // Usuario demo (opcional)
        Usuario userDemo = new Usuario("Demo User", "demo", "demo123", "usuario");
        userDemo.setCuenta(new Cuenta("demo", 50000.0, "Ahorros"));
        usuarios.add(userDemo);

        guardarEstado(); // Guarda el sistema inicial
    }

    /**
     * Carga el estado del sistema desde archivo.
     */
    private void cargarEstado() {
        File archivo = new File(ARCHIVO_ESTADO);

        if (!archivo.exists()) {
            usuarios = null;
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            EstadoSistema estado = (EstadoSistema) ois.readObject();
            this.usuarios = estado.getUsuarios();
            this.administrador = estado.getAdministrador();
            this.configuracion = estado.getConfiguracion();
        } catch (Exception e) {
            e.printStackTrace();
            usuarios = null;
        }
    }

    /**
     * Guarda el estado completo del sistema (usuarios, admin, config).
     */
    private void guardarEstado() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ESTADO))) {
            EstadoSistema estado = new EstadoSistema(usuarios, administrador, configuracion);
            oos.writeObject(estado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Método público para que los frames puedan forzar guardado
    public void guardarEstadoSistema() {
        guardarEstado();
    }

    /**
     * Registrar un usuario en la billetera.
     */
    public boolean registrarUsuario(Usuario nuevoUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNumeroCuenta().equals(nuevoUsuario.getNumeroCuenta())) {
                return false; // Ya existe
            }
        }

        Cuenta cuenta = new Cuenta(nuevoUsuario.getNumeroCuenta(), 0.0, "Ahorros");
        nuevoUsuario.setCuenta(cuenta);

        usuarios.add(nuevoUsuario);

        administrador.registrarNuevoUsuario();

        guardarEstado();

        return true;
    }

    /**
     * Login: busca usuario o admin.
     */
    public Usuario login(String usuario, String clave) throws UsuarioNoEncontradoException {
        for (Usuario u : usuarios) {
            if (u.getNumeroCuenta().equals(usuario) && u.getContraseña().equals(clave)) {
                return u;
            }
        }

        // Verificar admin
        if (administrador.getNombre().equals(usuario) && administrador.getClave().equals(clave)) {
            Usuario adminTemp = new Usuario("Administrador", "admin", "admin123", "admin");
            return adminTemp;
        }

        throw new UsuarioNoEncontradoException("Usuario no encontrado o credenciales incorrectas");
    }

    /**
     * Recarga de saldo.
     */
    public void recargarSaldo(Usuario usuario, double monto) {
        if (usuario.getCuenta() != null) {
            double saldoActual = usuario.getCuenta().getSaldo();
            usuario.getCuenta().setSaldo(saldoActual + monto);

            usuario.getHistorial().add(new Transaccion("Recarga", monto, "Recarga de saldo"));

            administrador.registrarTransaccion();
            administrador.agregarSaldoGlobal(monto);

            guardarEstado();  // 🔥 Guardamos todo
        }
    }

    // Getters
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
