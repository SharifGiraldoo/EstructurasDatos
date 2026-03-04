public class ProductoEcommerce {

    private String codigo;
    private double precio;

    public ProductoEcommerce(String codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductoEcommerce{");
        sb.append("codigo=").append(codigo);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }


    

    
}