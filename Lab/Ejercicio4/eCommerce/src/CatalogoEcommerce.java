
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CatalogoEcommerce {

    private final HashMap<String, ProductoEcommerce> mapa = new HashMap<>();
    private final ArrayList<ProductoEcommerce> lista = new ArrayList<>();

   
    /**
     * Agrega un producto al catálogo. Se inserta en el HashMap para búsquedas rápidas y en el ArrayList para mantener el orden de inserción.
     * @param producto
     */
    public void agregarProducto(ProductoEcommerce producto) {
        mapa.put(producto.getCodigo(), producto);
        lista.add(producto);
    }

    /**
     * Busca un producto por su código utilizando el HashMap, lo que permite una búsqueda eficiente con complejidad O(1) en promedio.
     * @param codigo
     * @return
     */
    public ProductoEcommerce buscarPorCodigo(String codigo) {
        return mapa.get(codigo);
    }

    /**
     * Ordena los productos por precio utilizando el ArrayList y el método sort con un Comparator. La complejidad de esta operación es O(n log n) 
     * debido al algoritmo de ordenamiento utilizado.
     * @return
     */
    public List<ProductoEcommerce> ordenarPorPrecio() {
        List<ProductoEcommerce> copia = new ArrayList<>(lista);
        copia.sort(Comparator.comparingDouble(ProductoEcommerce::getPrecio));
        return copia;
    }

    /***
     * Genera una cantidad específica de productos con códigos únicos y precios aleatorios, insertándolos en el catálogo. 
     * Esta función es útil para pruebas de escalabilidad.
     * @param cantidad
     */
    public void generarProductos(int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            agregarProducto(
                    new ProductoEcommerce(
                            "P" + i,
                            Math.random() * 5000
                    )
            );
        }
    }

    /**
     * Muestra un número limitado de productos insertados en el catálogo, proporcionando una vista rápida de los datos.
     *  Se utiliza para verificar visualmente la inserción y el formato de los productos.
     * @param cantidadMostrar
     */
    public void mostrarInsertados(int cantidadMostrar) {

        System.out.println("\nPRODUCTOS INSERTADOS (ejemplo):");

        for (int i = 0; i < Math.min(cantidadMostrar, lista.size()); i++) {
            System.out.println(lista.get(i));
        }
    }

    /**
     * Muestra un número limitado de resultados de búsqueda por código, permitiendo verificar la funcionalidad de búsqueda 
     * y la correcta recuperación de productos.
     * @param cantidadMostrar
     */
    public void mostrarBusquedas(int cantidadMostrar) {

        System.out.println("\nBÚSQUEDAS POR CÓDIGO:");

        for (int i = 0; i < cantidadMostrar && i < lista.size(); i++) {

            String codigo = lista.get(i).getCodigo();
            ProductoEcommerce encontrado = buscarPorCodigo(codigo);

            System.out.println("Buscando " + codigo + " -> " + encontrado);
        }
    }

    /**
     * Muestra un número limitado de productos ordenados por precio, permitiendo verificar la funcionalidad de ordenamiento y la 
     * correcta organización de los productos según su precio.
     * @param cantidadMostrar
     */
    public void mostrarOrdenados(int cantidadMostrar) {

        System.out.println("\nPRODUCTOS ORDENADOS POR PRECIO:");

        List<ProductoEcommerce> ordenados = ordenarPorPrecio();

        for (int i = 0; i < Math.min(cantidadMostrar, ordenados.size()); i++) {
            System.out.println(ordenados.get(i));
        }
    }


    /**
     * Ejecuta una prueba completa del catálogo, incluyendo la generación de productos, inserción, búsqueda y ordenamiento, 
     * mientras mide el tiempo y la memoria utilizada.
      * Al final, se muestra una comparación conceptual de las estructuras de datos utilizadas para cada operación, destacando 
      * las ventajas y desventajas de cada una en 
      * el contexto de un catálogo de e-commerce.
      * Esta función es esencial para evaluar el rendimiento y la eficiencia del catálogo bajo diferentes cargas de trabajo, 
      * proporcionando métricas clave para la toma de decisiones sobre optimizaciones futuras.
     */
    public void ejecutarPrueba() {

        long inicioInsercion = System.nanoTime();

        generarProductos(100); // Generamos 100, pero mostramos solo 10

        long finInsercion = System.nanoTime();

        mostrarInsertados(10);
        mostrarBusquedas(10);
        mostrarOrdenados(10);

        long memoria = Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory();

        System.out.println("\n--- MÉTRICAS ---");
        System.out.println("Total productos: " + mapa.size());
        System.out.println("Tiempo inserción (ms): "
                + (finInsercion - inicioInsercion) / 1_000_000.0);
        System.out.println("Memoria usada (bytes aprox): " + memoria);

        System.out.println("\n--- COMPARACIÓN CONCEPTUAL ---");
        System.out.println("Búsqueda → HashMap (O(1) promedio).");
        System.out.println("Ordenamiento → ArrayList (O(n log n)).");
        System.out.println("Inserción → ArrayList.add() (O(1) amortizado).");
    }


    /**
     * Genera una cantidad específica de productos con códigos únicos y precios aleatorios, insertándolos en el catálogo.
     *  Luego, mide el tiempo de inserción, búsqueda y ordenamiento, así como la memoria utilizada.
     */
    public void ejecutarPruebaEscalabilidad(int cantidad) {

        mapa.clear();
        lista.clear();

        long memoriaAntes = Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory();

        long inicioInsercion = System.nanoTime();

        for (int i = 0; i < cantidad; i++) {
            agregarProducto(
                    new ProductoEcommerce(
                            "P" + i,
                            Math.random() * 5000
                    )
            );
        }

        long finInsercion = System.nanoTime();

        long inicioBusqueda = System.nanoTime();
        buscarPorCodigo("P" + (cantidad / 2));
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

    public ArrayList<ProductoEcommerce> getLista() {
        return lista;
    }
}
