
import java.util.*;

public class PlataformaVenta {

    private final HashMap<String, Producto> mapaProductos = new HashMap<>();
    private final ArrayList<Producto> listaProductos = new ArrayList<>();


    /**
     * Agrega un producto a la plataforma de ventas, almacenándolo tanto en un HashMap para búsquedas rápidas por código como en un 
     * ArrayList para mantener el orden de inserción y permitir operaciones de ordenamiento. 
     * La complejidad de esta operación es O(1) para la inserción en el HashMap y O(1) para la inserción al inicio del ArrayList, 
     * lo que resulta en una eficiencia general para agregar productos.
     * @param p
     */
    public void agregarProducto(Producto p) {
        mapaProductos.put(p.getCodigo(), p);
        listaProductos.add(0, p);
    }

    
    /**
     * Busca un producto por su código utilizando el HashMap, lo que permite una búsqueda eficiente con complejidad O(1) en promedio.
     * @param codigo
     * @return El producto encontrado o null si no existe.
     */
    public Producto buscarPorCodigo(String codigo) {
        return mapaProductos.get(codigo);
    }

    /**
     * Filtra los productos por categoría, iterando sobre el HashMap y seleccionando aquellos que coinciden con la categoría especificada.
     * La complejidad de esta operación es O(n) en el peor caso, ya que se debe revisar cada producto para verificar su categoría.
     * @param categoria
     * @return Una lista de productos que pertenecen a la categoría especificada.
     */
    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : mapaProductos.values()) {
            if (p.getCategoria() == categoria) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    /***
     * Ordena los productos por precio utilizando el ArrayList y el método sort con un Comparator. La complejidad de esta operación es O(n log n) 
     * debido al algoritmo de ordenamiento utilizado.
     * @return Una lista de productos ordenados por precio.
     */
    public List<Producto> ordenarPorPrecio() {
        List<Producto> copia = new ArrayList<>(listaProductos);
        copia.sort(Comparator.comparingDouble(Producto::getPrecio));
        return copia;
    }


    // Método para obtener el número total de productos registrados en la plataforma, lo que es útil para verificar la cantidad de productos después de las operaciones de inserción.
    public int size() {
        return mapaProductos.size();
    }


    /**
     * Ejecuta una prueba completa del sistema de ventas, incluyendo la generación de productos, inserción, búsqueda, filtrado y ordenamiento, mientras mide el tiempo y la memoria utilizada.
      * Al final, se muestra una comparación conceptual de las estructuras de datos utilizadas para cada operación, destacando las ventajas y desventajas de cada una en 
      * el contexto de una plataforma de ventas. Esta función es esencial para evaluar el rendimiento y la eficiencia del sistema bajo diferentes cargas de trabajo, 
      * proporcionando métricas clave para la toma de decisiones sobre optimizaciones futuras.
     * @param cantidad
     */
    public void ejecutarPruebaEscalabilidad(int cantidad) {

        mapaProductos.clear();
        listaProductos.clear();

        CategoriaProducto[] categorias = CategoriaProducto.values();

        long memoriaAntes = Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory();

        long inicioInsercion = System.nanoTime();

        for (int i = 0; i < cantidad; i++) {
            agregarProducto(
                    new Producto(
                            "Producto" + i,
                            "COD" + i,
                            categorias[i % categorias.length],
                            Math.random() * 1000
                    )
            );
        }

        long finInsercion = System.nanoTime();

        long inicioBusqueda = System.nanoTime();
        buscarPorCodigo("COD" + (cantidad / 2));
        long finBusqueda = System.nanoTime();

        long inicioOrden = System.nanoTime();
        ordenarPorPrecio();
        long finOrden = System.nanoTime();

        long memoriaDespues = Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory();

        long memoriaUsada = memoriaDespues - memoriaAntes;

        System.out.println("\n--- Tamaño: " + cantidad + " ---");
        System.out.println("Tiempo Inserción (ms): "
                + (finInsercion - inicioInsercion) / 1_000_000.0);
        System.out.println("Tiempo Búsqueda (ms): "
                + (finBusqueda - inicioBusqueda) / 1_000_000.0);
        System.out.println("Tiempo Ordenamiento (ms): "
                + (finOrden - inicioOrden) / 1_000_000.0);
        System.out.println("Memoria usada (bytes aprox): "
                + memoriaUsada);
    }
}
