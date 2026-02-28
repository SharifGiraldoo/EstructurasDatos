public class Venta {

    private String codigo;
    private String nombre;
    private int cantidadVendida; 
    private double valorTotal;

    public Venta(int cantidadVendida, String codigo, String nombre, double valorTotal) {
        this.cantidadVendida = cantidadVendida;
        this.codigo = codigo;
        this.nombre = nombre;
        this.valorTotal = valorTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }


    


    



    
    
}
