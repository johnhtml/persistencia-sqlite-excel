package vista1;

import java.util.ArrayList;

import controlador1.ElControladorDeRequerimientos;
import modelo1.vo.Requerimiento_1;
import modelo1.vo.Requerimiento_2;
import modelo1.vo.Requerimiento_3;

public class VistaRequerimientos {

    public static final ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();

    public static void requerimiento1() {

        try {
            // Su código
            ArrayList<Requerimiento_1> ArrListRS = controlador.consultarRequerimiento1();
            for (Requerimiento_1 r1 : ArrListRS) {
                System.out.printf("%s %s %s %s %s\n", r1.getCiudad(), r1.getAcabados(), r1.getClasificacion(),
                        r1.getBanco_Vinculado(), r1.getConstructora());
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public static void requerimiento2() {

        try {
            // Su código
            ArrayList<Requerimiento_2> ArrListRS = controlador.consultarRequerimiento2();
            for (Requerimiento_2 r2 : ArrListRS) {
                System.out.printf("%s %s %s %s %d\n", r2.getNombre(), r2.getPrimer_Apellido(),
                        r2.getCiudad_Residencia(), r2.getCargo(), r2.getSalario());
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public static void requerimiento3() {
        try {
            // Su código
            ArrayList<Requerimiento_3> ArrListRS = controlador.consultarRequerimiento3();
            for (Requerimiento_3 r3 : ArrListRS) {
                System.out.printf("%s %s %s\n", r3.getProveedor(), r3.getPagado(),
                        r3.getConstructora());
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
}
