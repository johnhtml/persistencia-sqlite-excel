package controlador1;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo1.dao.Requerimiento_1Dao;
import modelo1.dao.Requerimiento_2Dao;
import modelo1.dao.Requerimiento_3Dao;
import modelo1.vo.Requerimiento_1;
import modelo1.vo.Requerimiento_2;
import modelo1.vo.Requerimiento_3;

public class ElControladorDeRequerimientos {
    
    private final Requerimiento_1Dao requerimiento_1Dao;
    private final Requerimiento_2Dao requerimiento_2Dao;
    private final Requerimiento_3Dao requerimiento_3Dao;

    public ElControladorDeRequerimientos(){
        this.requerimiento_1Dao= new Requerimiento_1Dao();
        this.requerimiento_2Dao= new Requerimiento_2Dao();
        this.requerimiento_3Dao= new Requerimiento_3Dao();
    }
    
        public ArrayList<Requerimiento_1> consultarRequerimiento1() throws SQLException {
            // Su código
            return requerimiento_1Dao.requerimiento1();
        }
    
        public ArrayList<Requerimiento_2> consultarRequerimiento2() throws SQLException {
            // Su código
            return requerimiento_2Dao.requerimiento2();
        }

        public ArrayList<Requerimiento_3> consultarRequerimiento3() throws SQLException {
            // Su código
            return requerimiento_3Dao.requerimiento3();
        } 

}
