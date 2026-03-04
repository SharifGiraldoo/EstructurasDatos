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

            // ---------------- INSERCIÓN ----------------
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

            // ---------------- FILTRADO ----------------
            System.out.println("\nFILTRADO POR CATEGORÍA: ALIMENTOS");

            List<Producto> filtrados = sistema.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);

            for (Producto p : filtrados) {
                System.out.println(p);
            }

            System.out.println("Total filtrados: " + filtrados.size());

            // ---------------- ORDENAMIENTO ----------------
            System.out.println("\nPRODUCTOS ORDENADOS POR PRECIO:");

            List<Producto> ordenados = sistema.ordenarPorPrecio();

            // Mostrar solo los primeros 5 para no saturar consola
            for (int i = 0; i < Math.min(5, ordenados.size()); i++) {
                System.out.println(ordenados.get(i));
            }

            // ---------------- MÉTRICAS ----------------
            long memoria = Runtime.getRuntime().totalMemory()
                    - Runtime.getRuntime().freeMemory();

            System.out.println("\nMÉTRICAS DE RENDIMIENTO:");
            System.out.println("Tiempo Inserción (ms): "
                    + (finInsercion - inicioInsercion) / 1_000_000.0);
            System.out.println("Memoria usada (bytes aprox): " + memoria);
        }
    }
}