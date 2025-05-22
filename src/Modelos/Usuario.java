package Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un usuario registrado en la billetera virtual.
 * Contiene datos personales, su cuenta, historial, notificaciones y rol de acceso.
 */
public class Usuario {

    private String nombre;
    private String numeroCuenta;
    private String contraseña;
    private double saldo;
    private List<Transaccion> historial;
    private Cuenta cuenta;
    private Notificaciones notificaciones;
    private TarjetaBancaria tarjeta;
    private String rol; //  "usuario" o "admin"

    /**
     * Constructor principal con rol incluido.
     * @param nombre Nombre completo del usuario.
     * @param numeroCuenta Número de cuenta único.
     * @param contraseña Contraseña de acceso.
     * @param rol Rol del usuario (usuario/admin).
     */
    public Usuario(String nombre, String numeroCuenta, String contraseña, String rol) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.contraseña = contraseña;
        this.rol = rol;
        this.saldo = 0.0;
        this.historial = new ArrayList<>();
        this.notificaciones = new Notificaciones();
    }

    /**
     * Constructor secundario sin rol (por compatibilidad).
     * Puedes usar setRol() después de crearlo.
     */
    public Usuario(String nombre, String numeroCuenta, String contraseña) {
        this(nombre, numeroCuenta, contraseña, "usuario");
    }

    // --- Getters y Setters ---

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public List<Transaccion> getHistorial() { return historial; }
    public void setHistorial(List<Transaccion> historial) { this.historial = historial; }

    public Cuenta getCuenta() { return cuenta; }
    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }

    public Notificaciones getNotificaciones() { return notificaciones; }
    public void setNotificaciones(Notificaciones notificaciones) { this.notificaciones = notificaciones; }

    public TarjetaBancaria getTarjeta() { return tarjeta; }
    public void setTarjeta(TarjetaBancaria tarjeta) { this.tarjeta = tarjeta; }

    public String getRol() { return rol; } // ✅ Nuevo getter
    public void setRol(String rol) { this.rol = rol; } // ✅ Nuevo setter
}
