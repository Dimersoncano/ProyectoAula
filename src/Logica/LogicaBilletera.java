package Logica;

import java.util.ArrayList;
import java.util.List;
import Modelos.Usuario;
import Modelos.Cuenta;
import Modelos.Transaccion;
import Modelos.Administrador;
import Modelos.Configuracion;

/**
 * Clase que maneja la lógica principal de la billetera virtual.
 */
public class LogicaBilletera {

    private List<Usuario> usuarios;
    private Administrador administrador;
    private Configuracion configuracion;

    public LogicaBilletera() {
        this.usuarios = new ArrayList<>();
        this.configuracion = new Configuracion(1000.0, 30);
        this.administrador = new Administrador("admin", "admin123");

        // Carga inicial de prueba
        Usuario userDemo = new Usuario("Demo User", "demo", "demo123", "cliente");
        userDemo.setCuenta(new Cuenta("demo", 50000.0, "Ahorros"));
        usuarios.add(userDemo);
    }

    public boolean registrarUsuario(Usuario nuevoUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNumeroCuenta().equals(nuevoUsuario.getNumeroCuenta())) {
                return false; // Ya existe
            }
        }
        Cuenta cuenta = new Cuenta(nuevoUsuario.getNumeroCuenta(), 0.0, "Ahorros");
        nuevoUsuario.setCuenta(cuenta);
        usuarios.add(nuevoUsuario);
        return true;
    }

    public Usuario login(String usuario, String clave) throws UsuarioNoEncontradoException {
        for (Usuario u : usuarios) {
            if (u.getNumeroCuenta().equals(usuario) && u.getContraseña().equals(clave)) {
                return u;
            }
        }
        if (administrador.getNombre().equals(usuario) && administrador.getClave().equals(clave)) {

            return new Usuario("Administrador", "admin", "admin123", "admin");
        }
        throw new UsuarioNoEncontradoException("Usuario no encontrado o credenciales incorrectas");
    }

    public void recargarSaldo(Usuario usuario, double monto) {
        if (usuario.getCuenta() != null) {
            double saldoActual = usuario.getCuenta().getSaldo();
            usuario.getCuenta().setSaldo(saldoActual + monto);
            usuario.getHistorial().add(new Transaccion("Recarga", monto, "Recarga de saldo"));
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Administrador getAdministrador() {
        return administrador;
    }
}
