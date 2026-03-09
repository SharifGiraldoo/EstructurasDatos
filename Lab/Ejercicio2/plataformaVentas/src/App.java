import java.util.List;

public class App {

    public static void main(String[] args) {

        int[] tamaños = {10, 100, 1000};

        for (int n : tamaños) {

            System.out.println("\n===============================");
            System.out.println("PRUEBA CON " + n + " PRODUCTOS");
            System.out.println("===============================");

            PlataformaVenta sistema = new PlataformaVenta();
            CategoriaProducto[] categorias = CategoriaProducto.values();

            /**
             * Inserta un número específico de productos en la plataforma, lo que es fundamental para evaluar el rendimiento de la inserción y la gestión de datos a medida que la cantidad de productos aumenta. 
             * Esta operación es clave para medir el tiempo de inserción y el uso de memoria, proporcionando una base para comparar con otras operaciones como búsqueda y ordenamiento.
             */
            long inicioInsercion = System.nanoTime();

            for (int i = 0; i < n; i++) {
                sistema.agregarProducto(
                        new Producto(
                                "Producto" + i,
                                "COD" + i,
                                categorias[i % categorias.length],
                                Math.random() * 1000
                        )
                );
            }

            long finInsercion = System.nanoTime();

            System.out.println("\nTotal productos registrados: " + sistema.size());

            // ---------------- BÚSQUEDA ----------------
            System.out.println("\nBÚSQUEDA POR CÓDIGO:");

            String[] codigosBusqueda = {
                    "COD0",
                    "COD" + (n / 2),
                    "COD" + (n - 1)
            };

            for (String codigo : codigosBusqueda) {
                Producto encontrado = sistema.buscarPorCodigo(codigo);
                System.out.println("Buscando " + codigo + " -> " + encontrado);
            }

            /**
             * Filtra los productos por una categoría específica, lo que es esencial para evaluar la eficiencia del filtrado y la capacidad de la plataforma para manejar consultas basadas en atributos.
             * Esta operación permite medir el tiempo de filtrado y la cantidad de productos que coinciden con la categoría,
             *  proporcionando información valiosa sobre el rendimiento del sistema en escenarios de consulta comunes en plataformas de ventas.
             */
            System.out.println("\nFILTRADO POR CATEGORÍA: ALIMENTOS");

            List<Producto> filtrados = sistema.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);

            for (Producto p : filtrados) {
                System.out.println(p);
            }

            System.out.println("Total filtrados: " + filtrados.size());

            /**
             * Ordena los productos por precio, lo que es crucial para evaluar la eficiencia del ordenamiento y la capacidad de 
             * la plataforma para organizar grandes cantidades de datos de manera efectiva.
             * Esta operación permite medir el tiempo de ordenamiento y verificar que los productos se ordenen correctamente
             *  según su precio, lo que es fundamental para la experiencia del usuario en una plataforma de ventas.
              */
            System.out.println("\nPRODUCTOS ORDENADOS POR PRECIO:");

            List<Producto> ordenados = sistema.ordenarPorPrecio();

            
            for (int i = 0; i < Math.min(5, ordenados.size()); i++) {
                System.out.println(ordenados.get(i));
            }

            /**
             * Mide el tiempo total de ejecución de las operaciones clave (inserción, búsqueda, filtrado y ordenamiento) y el uso de memoria, 
             * proporcionando métricas esenciales para evaluar el rendimiento del sistema bajo diferentes cargas de trabajo.
             */
            long memoria = Runtime.getRuntime().totalMemory()
                    - Runtime.getRuntime().freeMemory();

            System.out.println("\nMÉTRICAS DE RENDIMIENTO:");
            System.out.println("Tiempo Inserción (ms): "
                    + (finInsercion - inicioInsercion) / 1_000_000.0);
            System.out.println("Memoria usada (bytes aprox): " + memoria);
        }
    }
}