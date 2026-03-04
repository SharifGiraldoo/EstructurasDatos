public class Producto {

    private String nombre;
    private String codigo;
    private CategoriaProducto categoria;
    private double precio;

    public Producto(String nombre, String codigo, CategoriaProducto categoria, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public CategoriaProducto getCategoria() { return categoria; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return codigo + " | " + nombre + " | " + categoria + " | $" + precio;
    }
}