package Logica;

import java.io.File; // Permite manejar archivos en la computadora
import java.io.FileInputStream; // Permite leer datos de un archivo
import java.io.FileOutputStream; // Permite escribir datos en un archivo
import java.io.ObjectInputStream; // Permite leer objetos completos desde un archivo
import java.io.ObjectOutputStream; // Permite guardar objetos completos en un archivo
import java.util.ArrayList; // Lista que puede crecer
import java.util.List; // Representa listas en general

import Modelos.Usuario; // Importamos la clase Usuario
import Modelos.Cuenta; // Importamos la clase Cuenta
import Modelos.Transaccion; // Importamos Transacción
import Modelos.Administrador; // Importamos Administrador
import Modelos.Configuracion; // Importamos Configuración

/**
 * Clase que maneja la lógica principal de la billetera virtual.
 * Ahora incluye persistencia total del sistema.
 * 
 * Piensa en esto como el "cerebro" de la billetera. Aquí se guardan usuarios,
 * se manejan transacciones y también se guarda TODO en un archivo para no perder nada.
 */
public class LogicaBilletera {

    private List<Usuario> usuarios; // Lista de todos los usuarios registrados
    private Administrador administrador; // El administrador del sistema
    private Configuracion configuracion; // Configuración general (límites, etc.)

    // Archivo donde se guardará TODO
    private static final String ARCHIVO_ESTADO = "estado_billetera.dat"; // Nombre del archivo donde guardamos todo

    /**
     * Constructor
     * Carga el estado si existe, si no crea un sistema por defecto.
     */
    public LogicaBilletera() {
        cargarEstado();  // Intentamos recuperar todo desde el archivo

        if (usuarios == null) { // Si no había archivo o falló la carga
            inicializarSistemaPorDefecto(); // Creamos todo desde cero
        }
    }

    /**
     * Inicializa el sistema si nunca ha sido guardado.
     * Es como crear el mundo desde cero.
     */
    private void inicializarSistemaPorDefecto() {
        this.usuarios = new ArrayList<>(); // Creamos una lista vacía de usuarios
        this.configuracion = new Configuracion(1000.0, 30); // Configuración por defecto
        this.administrador = new Administrador("admin", "admin123"); // Administrador por defecto

        // Usuario demo (opcional)
        Usuario userDemo = new Usuario("Demo User", "demo", "demo123", "usuario");
        userDemo.setCuenta(new Cuenta("demo", 50000.0, "Ahorros")); // Le damos cuenta y saldo
        usuarios.add(userDemo);

        guardarEstado(); // Guardamos este mundo inicial
    }

    /**
     * Carga el estado del sistema desde archivo.
     * Es como abrir un "guardado" del videojuego.
     */
    private void cargarEstado() {
        File archivo = new File(ARCHIVO_ESTADO); // Apuntamos al archivo

        if (!archivo.exists()) { // Si no existe, no hay estado previo
            usuarios = null;
            return;
        }
            // Se crea el archivo en esta parte:
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            EstadoSistema estado = (EstadoSistema) ois.readObject(); // Lo leemos
            this.usuarios = estado.getUsuarios(); // Recuperamos usuarios
            this.administrador = estado.getAdministrador(); // Recuperamos admin
            this.configuracion = estado.getConfiguracion(); // Recuperamos config
        } catch (Exception e) {
            e.printStackTrace(); // Mostramos error
            usuarios = null; // Si falla, dejamos vacío
        }
    }

    /**
     * Guarda el estado completo del sistema (usuarios, admin, config).
     * Es como darle "Guardar partida".
     */
    private void guardarEstado() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ESTADO))) {
            EstadoSistema estado = new EstadoSistema(usuarios, administrador, configuracion); // Empaquetamos todo
            oos.writeObject(estado); // Lo guardamos en el archivo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Método público para que los frames puedan forzar guardado
    public void guardarEstadoSistema() {
        guardarEstado(); // Permite que otras partes del programa lo llamen
    }

    /**
     * Registrar un usuario en la billetera.
     * Aquí revisamos que no existan duplicados y luego lo agregamos.
     */
    public boolean registrarUsuario(Usuario nuevoUsuario) {
        for (Usuario u : usuarios) {
            // Validar que no se repita el número de cuenta
            if (u.getNumeroCuenta().equals(nuevoUsuario.getNumeroCuenta())) {
                return false; // Ya existe
            }
            // Validar que no se repita el DOCUMENTO
            if (u.getDocumentoIdentidad() != null 
                    && nuevoUsuario.getDocumentoIdentidad() != null
                    && u.getDocumentoIdentidad().equals(nuevoUsuario.getDocumentoIdentidad())) {
                return false; // Documento ya registrado
            }
        }

        Cuenta cuenta = new Cuenta(nuevoUsuario.getNumeroCuenta(), 0.0, "Ahorros"); // Le creamos cuenta
        nuevoUsuario.setCuenta(cuenta);

        usuarios.add(nuevoUsuario); // Lo agregamos

        administrador.registrarNuevoUsuario(); // El admin suma uno más

        guardarEstado(); // Guardamos todo

        return true; // Registro exitoso
    }

    /**
     * Busca usuario por documento.
     */
    public Usuario buscarUsuarioPorDocumento(String documento) {
        for (Usuario u : usuarios) {
            if (u.getDocumentoIdentidad() != null
                    && u.getDocumentoIdentidad().equals(documento)) {
                return u;
            }
        }
        return null; // No lo encontramos
    }

    /**
     * Login de usuarios y administrador.
     */
    public Usuario login(String identificador, String clave) throws UsuarioNoEncontradoException {
        // 1. Primero verificamos si es el ADMIN
        if (administrador.getNombre().equals(identificador) && administrador.getClave().equals(clave)) {
            Usuario adminTemp = new Usuario("Administrador", "admin", "admin123", "admin");
            return adminTemp; // Login correcto como admin
        }

        // 2. Si no es admin, se asume que es DOCUMENTO DE IDENTIDAD
        for (Usuario u : usuarios) {
            if (u.getDocumentoIdentidad() != null
                    && u.getDocumentoIdentidad().equals(identificador)
                    && u.getContraseña().equals(clave)) {
                return u; // Login correcto como usuario
            }
        }

        throw new UsuarioNoEncontradoException("Documento o contraseña incorrectos"); // Error
    }

    /**
     * Recarga de saldo.
     * Es como poner dinero en la alcancía.
     */
    public void recargarSaldo(Usuario usuario, double monto) {
        if (usuario.getCuenta() != null) {
            double saldoActual = usuario.getCuenta().getSaldo(); // Tomamos el saldo actual
            usuario.getCuenta().setSaldo(saldoActual + monto); // Le sumamos el nuevo dinero

            usuario.getHistorial().add(new Transaccion("Recarga", monto, "Recarga de saldo")); // Guardamos registro

            administrador.registrarTransaccion(); // Admin registra actividad
            administrador.agregarSaldoGlobal(monto); // Suma al total del sistema

            guardarEstado();  // Guardamos todo
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

    public List<Usuario> obtenerUsuariosParaAdmin() {
        return new ArrayList<>(usuarios); // Devolvemos copia de la lista
    }
}
