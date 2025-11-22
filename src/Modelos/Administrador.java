package Modelos;


import java.io.Serializable;
/**
 * Clase que representa al administrador del sistema de la billetera virtual.
 * Puede consultar estadísticas y configurar parámetros del sistema.
 */
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String clave; // ← NUEVO
    private int totalUsuarios;
    private int totalTransacciones;
    private double saldoTotalSistema;
    private double comisionFija;
    private double saldoMaximo;

    /**
     * Constructor con nombre y clave.
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

    public void registrarNuevoUsuario() {
        totalUsuarios++;
    }

    public void registrarTransaccion() {
        totalTransacciones++;
    }

    public void agregarSaldoGlobal(double monto) {
        saldoTotalSistema += monto;
    }

    public void descontarSaldoGlobal(double monto) {
        saldoTotalSistema -= monto;
    }
}
