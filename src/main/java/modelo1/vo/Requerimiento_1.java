package modelo1.vo;

public class Requerimiento_1 {
    // Su código
    private String Ciudad;
    private String Acabados;
    private String Clasificacion;
    private String Banco_Vinculado;
    private String Constructora;
    
    // constructors
    public Requerimiento_1() {
    }

    public Requerimiento_1(String ciudad, String acabados, String clasificacion, String banco_Vinculado,
            String constructora) {
        Ciudad = ciudad;
        Acabados = acabados;
        Clasificacion = clasificacion;
        Banco_Vinculado = banco_Vinculado;
        Constructora = constructora;
    }

    // setters and getters
    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getAcabados() {
        return Acabados;
    }

    public void setAcabados(String acabados) {
        Acabados = acabados;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        Clasificacion = clasificacion;
    }

    public String getBanco_Vinculado() {
        return Banco_Vinculado;
    }

    public void setBanco_Vinculado(String banco_Vinculado) {
        Banco_Vinculado = banco_Vinculado;
    }

    public String getConstructora() {
        return Constructora;
    }

    public void setConstructora(String constructora) {
        Constructora = constructora;
    }
    
}
