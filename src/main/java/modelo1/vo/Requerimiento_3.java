package modelo1.vo;

public class Requerimiento_3 {
    // Su código
    private String Proveedor;
    private String Pagado;
    private String Constructora;

    // Constructors
    public Requerimiento_3() {
    }

    public Requerimiento_3(String proveedor, String pagado, String constructora) {
        Proveedor = proveedor;
        Pagado = pagado;
        Constructora = constructora;
    }

    //Getters and setters
    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String proveedor) {
        Proveedor = proveedor;
    }

    public String getPagado() {
        return Pagado;
    }

    public void setPagado(String pagado) {
        Pagado = pagado;
    }

    public String getConstructora() {
        return Constructora;
    }

    public void setConstructora(String constructora) {
        Constructora = constructora;
    }
}
