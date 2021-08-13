package modelo1.dao;

//Estructura de datos
import java.util.ArrayList;

import modelo1.vo.Requerimiento_2;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util1.JDBCUtilities;

public class Requerimiento_2Dao {
    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<Requerimiento_2> requerimiento2()  throws SQLException {
        // Su código
        final String sql = "SELECT Nombre , Primer_Apellido , Ciudad_Residencia , Cargo , Salario FROM Lider WHERE ((Cargo LIKE 'Asesor') OR (Cargo LIKE 'Coordinador')) AND (Salario < 250000);";

        Connection cnt = JDBCUtilities.getConnection();
        PreparedStatement pstmt = cnt.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        ArrayList<Requerimiento_2> resultado = new ArrayList<Requerimiento_2>();

        while (rs.next()) {
            Requerimiento_2 elementoi = new Requerimiento_2(
                rs.getString("Nombre"), rs.getString("Primer_Apellido"), 
                rs.getString("Ciudad_Residencia"), rs.getString("Cargo"),
                rs.getInt("Salario"));
            resultado.add(elementoi);
        }

        rs.close();
        pstmt.close();
        cnt.close();
        return resultado;
    }
}
