package modelo1.dao;

//Estructura de datos
import java.util.ArrayList;

import modelo1.vo.Requerimiento_1;

//Bibliotecas para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util1.JDBCUtilities;

public class Requerimiento_1Dao {   

    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<Requerimiento_1> requerimiento1()  throws SQLException {
        // Su código

        final String sql = "SELECT Ciudad , Acabados , Clasificacion , Banco_Vinculado , Constructora FROM Proyecto WHERE Ciudad LIKE 'Bogota';";

        Connection cnt = JDBCUtilities.getConnection();
        PreparedStatement pstmt = cnt.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        ArrayList<Requerimiento_1> resultado = new ArrayList<Requerimiento_1>();

        while (rs.next()) {
            Requerimiento_1 elementoi = new Requerimiento_1(
                rs.getString("Ciudad"), rs.getString("Acabados"),
                rs.getString("Clasificacion"), rs.getString("Banco_Vinculado"),
                rs.getString("Constructora"));
            resultado.add(elementoi);
        }
        
        rs.close();
        pstmt.close();
        cnt.close();
        return resultado;
    }
}
