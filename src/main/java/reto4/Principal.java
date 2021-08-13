package reto4;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import vista1.VistaRequerimiento1;
import vista1.VistaRequerimiento2;
import vista1.VistaRequerimiento3;

/**
 * Esta clase solo se debe usar para hacer pruebas locales, no se debe subir en
 * iMaster
 */
public class Principal {
    public static void main(String[] args) {
        // Setting the desire look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No such look and feel");
        }

        System.out.println("Requerimiento 1");
        // VistaRequerimientos.requerimiento1();
        VistaRequerimiento1 uno = new VistaRequerimiento1();

        System.out.println("\nRequerimiento 2");
        VistaRequerimiento2 dos = new VistaRequerimiento2();

        System.out.println("\nRequerimiento 3");
        // VistaRequerimientos.requerimiento3();
        VistaRequerimiento3 tres = new VistaRequerimiento3();

    }
}
