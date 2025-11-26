package Modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un usuario registrado en la billetera virtual.
 *
 * Explicado como para un niño:
 * Imagina que este "Usuario" es como una ficha de una persona que usa una
 * billetera digital. En esta ficha se guarda:
 *  - su nombre,
 *  - su cuenta de dinero,
 *  - su contraseña para entrar,
 *  - cuánto dinero tiene,
 *  - una lista con todas las cosas que ha hecho con su dinero (historial),
 *  - mensajes que recibe,
 *  - una tarjeta guardada,
 *  - y si es un usuario normal o un administrador.
 *
 * Es como una carpeta donde se guarda toda la información importante de esa persona.
 */
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Nombre del usuario (como su nombre real).
    private String nombre;

    // Número único que identifica su cuenta en el sistema.
    private String numeroCuenta;

    // Contraseña para que solo él pueda entrar.
    private String contraseña;

    // Dinero que el usuario tiene guardado.
    private double saldo;

    // Lista con todas las transacciones que ha hecho (como un historial).
    private List<Transaccion> historial;

    // Su cuenta bancaria asociada.
    private Cuenta cuenta;

    // Aquí se guardan los mensajes y avisos que recibe el usuario.
    private Notificaciones notificaciones;

    // Una tarjeta bancaria que el usuario puede tener guardada.
    private TarjetaBancaria tarjeta;

    // Rol del usuario: puede ser "usuario" normal o "admin".
    private String rol;

    // Documento del usuario (como su identificación).
    private String documento;

    // Documento de identidad más específico.
    private String documentoIdentidad;

    /**
     * Constructor principal con rol incluido.
     *
     * Explicado como para un niño:
     * Cuando creamos un usuario nuevo, le decimos:
     * - cuál es su nombre,
     * - cuál es su número de cuenta,
     * - cuál será su contraseña,
     * - y si será un usuario normal o administrador.
     *
     * Al principio empieza con saldo en 0,
     * con un historial vacío,
     * y con sus notificaciones listas para usarse.
     *
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
        this.saldo = 0.0;                // El dinero empieza en cero
        this.historial = new ArrayList<>(); // Historial vacío
        this.notificaciones = new Notificaciones(); // Sistema de mensajes listo
    }

    /**
     * Constructor secundario sin rol (por compatibilidad).
     *
     * Explicado como para un niño:
     * Si no decimos qué rol tendrá el usuario,
     * automáticamente será un usuario normal.
     */
    public Usuario(String nombre, String numeroCuenta, String contraseña) {
        this(nombre, numeroCuenta, contraseña, "usuario");
    }

    // --- Getters y Setters ---
    // Explicado como para un niño:
    // Estas son como ventanitas para ver y cambiar la información del usuario.

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

    public String getRol() { return rol; } // Devuelve si es usuario o admin
    public void setRol(String rol) { this.rol = rol; } // Permite cambiar el rol

    public String getDocumento() {
        return documento;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
