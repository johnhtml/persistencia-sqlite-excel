package controlador1;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportToExcel {
    public static void exportDataToExcel(JFrame parent, JTable table) {

        FileOutputStream excelFos = null;
        XSSFWorkbook excelJTableExport = null;
        BufferedOutputStream excelBos = null;
        // String excelImagePath = "";

        try {

            // Choosing Saving Location
            // Set default location to C:\Users\Authentic\Desktop or your preferred location
            JFileChooser excelFileChooser = new JFileChooser("C:\\");
            // Dialog box title
            excelFileChooser.setDialogTitle("Save As ..");
            // Filter only xls, xlsx, xlsm files
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "xls", "xlsx", "xlsm");
            // Setting extension for selected file names
            excelFileChooser.setFileFilter(fnef);
            int chooser = excelFileChooser.showSaveDialog(parent);
            // Check if save button has been clicked
            if (chooser == JFileChooser.APPROVE_OPTION) {
                // If button is clicked execute this code
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Información Exportada");
                // Loop through the jtable columns and rows to get its values
                for (int i = 0; i < table.getModel().getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < table.getModel().getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(new XSSFRichTextString(table.getModel().getValueAt(i, j).toString()));
                    }
                }

                if (!excelFileChooser.getSelectedFile().getName().endsWith(".xlsx")) {
                    excelFos = new FileOutputStream((excelFileChooser.getSelectedFile()) + ".xlsx");
                } else {
                    excelFos = new FileOutputStream((excelFileChooser.getSelectedFile()));
                }
                
                excelBos = new BufferedOutputStream(excelFos);
                excelJTableExport.write(excelBos);
                excelBos.close();
                excelFos.close();
                JOptionPane.showMessageDialog(null, "Datos exportados de manera exitosa");
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(parent, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(parent, ex);
        } catch (java.lang.NullPointerException ex) {
            JOptionPane.showMessageDialog(parent, "No hay datos para exportar\n" + ex);
        } finally {
            try {
                if (excelFos != null) {
                    excelFos.close();
                }
                if (excelBos != null) {
                    excelBos.close();
                }
                if (excelJTableExport != null) {
                    excelJTableExport.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
