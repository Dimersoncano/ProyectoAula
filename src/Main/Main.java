package Main;

import Logica.LogicaBilletera;
import Vistas.LoginFrame;

/**
 * Clase principal que lanza la aplicación de la billetera virtual.
 */
public class Main {
    public static void main(String[] args) {
        // Crear instancia única de la lógica de negocio
        LogicaBilletera logica = new LogicaBilletera();

        // Ejecutar en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginFrame login = new LoginFrame(logica); // Pasar la lógica
            login.setVisible(true);
        });
    }
}