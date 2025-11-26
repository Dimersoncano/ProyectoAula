package Modelos;


import java.io.Serializable;
/**
 * Esta clase representa al "Administrador" del sistema.
 *
 * Explique como para un niño:
 * Imagina que en una billetera virtual hay un jefe o cuidador
 * que vigila todo: cuántas personas usan la billetera,
 * cuánto dinero se mueve y cuáles son las reglas del sistema.
 *
 * Esta clase es ese jefe.
 * Él puede ver estadísticas, contar usuarios, contar transacciones,
 * sumar dinero que entra y sale, y cambiar configuraciones importantes.
 *
 * También implementa Serializable, lo que significa que este "jefe"
 * puede guardarse dentro de un archivo como si fuera una foto congelada
 * del momento.
 */
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;

    // Nombre del administrador (como su usuario o identificación)
    private String nombre;

    // Su clave secreta para iniciar sesión
    private String clave; // ← NUEVO

    // Cantidad total de personas registradas en la billetera
    private int totalUsuarios;

    // Cuántas transacciones se han hecho en todo el sistema
    private int totalTransacciones;

    // Cuánto dinero hay en total dentro de la billetera de todos los usuarios
    private double saldoTotalSistema;

    // Un pequeño porcentaje que se puede cobrar como comisión por transacción
    private double comisionFija;

    // Cuánto dinero como máximo puede tener una persona en su cuenta
    private double saldoMaximo;

    /**
     * Constructor con nombre y clave.
     *
     * Explicado como para un niño:
     * Cuando creamos un administrador nuevo, le damos un nombre
     * y una clave secreta.
     *
     * También inicializamos sus contadores y las reglas por defecto,
     * como la comisión del 2% y el máximo de dinero permitido.
     */
    public Administrador(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
        this.totalUsuarios = 0;
        this.totalTransacciones = 0;
        this.saldoTotalSistema = 0.0;
        this.comisionFija = 0.02; // 2% por defecto
        this.saldoMaximo = 5000000.0; // Límite de saldo por usuario
    }

    // --- Getters y Setters ---
    // (Son como pequeñas puertas que permiten ver o cambiar datos del administrador)

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public int getTotalUsuarios() { return totalUsuarios; }
    public void setTotalUsuarios(int totalUsuarios) { this.totalUsuarios = totalUsuarios; }

    public int getTotalTransacciones() { return totalTransacciones; }
    public void setTotalTransacciones(int totalTransacciones) { this.totalTransacciones = totalTransacciones; }

    public double getSaldoTotalSistema() { return saldoTotalSistema; }
    public void setSaldoTotalSistema(double saldoTotalSistema) { this.saldoTotalSistema = saldoTotalSistema; }

    public double getComisionFija() { return comisionFija; }
    public void setComisionFija(double comisionFija) { this.comisionFija = comisionFija; }

    public double getSaldoMaximo() { return saldoMaximo; }
    public void setSaldoMaximo(double saldoMaximo) { this.saldoMaximo = saldoMaximo; }

    // --- Métodos funcionales ---
    // Son acciones que el administrador puede realizar.

    /**
     * Suma uno al contador de usuarios.
     * Explicado como para un niño:
     * Cada vez que alguien nuevo se une a la billetera,
     * el administrador dice: "¡Ahora tenemos uno más!"
     */
    public void registrarNuevoUsuario() {
        totalUsuarios++;
    }

    /**
     * Suma una transacción al total.
     * Es como si el administrador dijera:
     * "¡Se hizo otro movimiento de dinero!"
     */
    public void registrarTransaccion() {
        totalTransacciones++;
    }

    /**
     * Aumenta la cantidad de dinero que existe en todo el sistema.
     * Como cuando alguien recarga dinero.
     */
    public void agregarSaldoGlobal(double monto) {
        saldoTotalSistema += monto;
    }

    /**
     * Resta dinero del total del sistema.
     * Como cuando alguien hace un pago o saca dinero.
     */
    public void descontarSaldoGlobal(double monto) {
        saldoTotalSistema -= monto;
    }
}
