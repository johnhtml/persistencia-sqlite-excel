package modelo1.dao;

//Estructura de datos
import java.util.ArrayList;

import modelo1.vo.Requerimiento_3;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util1.JDBCUtilities;

public class Requerimiento_3Dao {
    // Obtener los 10 proyectos rankeados según las compras
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        // Su código
        final String sql = "SELECT Proveedor , Pagado , Constructora from Compra INNER JOIN Proyecto ON (Compra.Proveedor = 'JUMBO' AND Compra.Pagado = 'No') AND (Compra.ID_Proyecto = Proyecto.ID_Proyecto);";

        Connection cnt = JDBCUtilities.getConnection();
        PreparedStatement pstmt = cnt.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        ArrayList<Requerimiento_3> resultado = new ArrayList<Requerimiento_3>();

        while (rs.next()) {
            Requerimiento_3 elementoi = new Requerimiento_3(
                rs.getString("Proveedor"), rs.getString("Pagado"),
                rs.getString("Constructora"));
            resultado.add(elementoi);
        }

        rs.close();
        pstmt.close();
        cnt.close();
        return resultado;
    }
}
