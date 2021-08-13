package vista1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador1.ElControladorDeRequerimientos;
import controlador1.ExportToExcel;
import modelo1.vo.Requerimiento_2;

public class VistaRequerimiento2 extends JFrame {
    JTable tabla;
    JScrollPane panel;
    JButton jButtonLimpiarVista;
    String[] titulo = { "Nombre", "Primer apellido", "Ciudad residencia", "Cargo", "Salario" };

    public VistaRequerimiento2() {
        super("Requerimiento 2");
        initUITable();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        setEnabled(true);
        getContentPane().setBackground(new java.awt.Color(18, 114, 116));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initUITable() {
        try {
            // setLayout
            getContentPane().setLayout(new GridBagLayout());
            // JMenu
            JMenuBar mb = new JMenuBar();
            JMenu archivo = new JMenu("Archivo");
            JMenuItem jMenuItemArchivoGuardar = new JMenuItem("Exportar a Excel");
            jMenuItemArchivoGuardar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItemArchivoGuardarActionPerformed(evt);
                }
            });
            archivo.add(jMenuItemArchivoGuardar);
            mb.add(archivo);
            setJMenuBar(mb);

            // JTable
            tabla = new JTable(obtenerResultados(), titulo);
            panel = new JScrollPane(tabla);

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0; // Columna 0, no necesita estirarse, no ponemos weigthx
            constraints.gridy = 0; // Fila 0, necesita estirarse, hay que poner weigthy
            constraints.gridwidth = 1;
            constraints.gridheight = 1; // La fila 1 debe estirarse, le ponemos 1.0
            // El area del panel debe estirarse en ambos sentidos. Ponemos el campo fill.
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 1.0;
            constraints.weighty = 1.0;
            getContentPane().add(panel, constraints);
            constraints.weightx = 0.0;
            constraints.weighty = 0.0;

            // JButton
            jButtonLimpiarVista = new JButton("Limpiar tabla");
            jButtonLimpiarVista.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonLimpiarVistaActionPerformed(evt);
                }
            });

            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            // El area del panel debe estirarse en ambos sentidos. Ponemos el campo fill.
            constraints.weightx = 0.0;
            constraints.weighty = 0.0;
            constraints.fill = GridBagConstraints.WEST;
            getContentPane().add(jButtonLimpiarVista, constraints);
            constraints.weightx = 0.0;
            constraints.weighty = 0.0;

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error: " + e);
        }
    }

    private void jButtonLimpiarVistaActionPerformed(java.awt.event.ActionEvent evt) {

        if (JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de limpiar la vista de la tabla?, no habrá cambios en los datos almacenados",
                "Limpiar Tabla", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
            tabla.setModel(new DefaultTableModel(titulo, 1));
        }
        repaint();
    }

    private void jMenuItemArchivoGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        ExportToExcel.exportDataToExcel(this, tabla);
    }

    private String[][] obtenerResultados() throws SQLException {
        final ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();
        ArrayList<Requerimiento_2> ArrListRS = controlador.consultarRequerimiento2();

        String matrizDeDatos[][] = new String[ArrListRS.size()][titulo.length];

        for (int i = 0; i < ArrListRS.size(); i++) {
            matrizDeDatos[i][0] = ArrListRS.get(i).getNombre();
            matrizDeDatos[i][1] = ArrListRS.get(i).getPrimer_Apellido();
            matrizDeDatos[i][2] = ArrListRS.get(i).getCiudad_Residencia();
            matrizDeDatos[i][3] = ArrListRS.get(i).getCargo();
            matrizDeDatos[i][4] = String.valueOf(ArrListRS.get(i).getSalario());
        }

        return matrizDeDatos;
    }
}
