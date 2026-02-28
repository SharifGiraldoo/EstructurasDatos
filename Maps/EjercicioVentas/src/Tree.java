
import java.util.Map;
import java.util.TreeMap;

public class Tree {

    public static void main(String[] args) {
        TreeMap<String, Venta> ventasTreeMap = new TreeMap<>();
        registrarventaTreeMap(ventasTreeMap, "001", "Producto A", 10, 100.0);
        registrarventaTreeMap(ventasTreeMap, "002", "Producto B", 5, 50.0);
        consultarInformacionPorCodigoTreeMap(ventasTreeMap, "001");
        mostrarVentasRegistradasTreeMap(ventasTreeMap);
        mostrarOrdenPorCodigoTreeMap(ventasTreeMap);
        mostrarPorOrden(ventasTreeMap);
        
    }


    public static void registrarventaTreeMap(TreeMap<String, Venta> ventasTreeMap, String codigo, String nombre, int cantidadVendida, double valorTotal) {
        if (ventasTreeMap.containsKey(codigo)) {
            Venta ventaExistente = ventasTreeMap.get(codigo);
            ventaExistente.setCantidadVendida(ventaExistente.getCantidadVendida() + cantidadVendida);
            ventaExistente.setValorTotal(ventaExistente.getValorTotal() + valorTotal);
        } else {
            Venta nuevaVenta = new Venta(cantidadVendida, codigo, nombre, valorTotal);
            ventasTreeMap.put(codigo, nuevaVenta);
        }
    }


    public static void consultarInformacionPorCodigoTreeMap(TreeMap<String,Venta> ventasTreeMap, String codigo){

        if(ventasTreeMap.containsKey(codigo)){

            Venta ventaEncontrada = ventasTreeMap.get(codigo);
            System.out.println("Informacion de la venta:" + "Codigo: " + ventaEncontrada.getCodigo() + " Nombre: " + ventaEncontrada.getNombre() + " Cantidad Vendida: " + ventaEncontrada.getCantidadVendida() + " Valor Total: " + ventaEncontrada.getValorTotal());

        }else{
            System.out.println("No se encontro una venta con el código: " + codigo);
        }

    }


    public static void mostrarVentasRegistradasTreeMap(TreeMap<String,Venta> ventasTreeMap){

        if(ventasTreeMap.isEmpty()){
            System.out.println("No hay ventas registradas.");
            
        }else{

            for (Map.Entry<String,Venta> ventas1 : ventasTreeMap.entrySet()) {
                System.out.println("Clave: " + ventas1.getKey() + ", Valor: " + ventas1.getValue());
                System.out.println("Informacion de las ventas:" + " Codigo: " + ventas1.getValue().getCodigo() + " Nombre: " + ventas1.getValue().getNombre() + " Cantidad Vendida: " + ventas1.getValue().getCantidadVendida() + " Valor Total: " + ventas1.getValue().getValorTotal());
            }
        }
    }

    public static void mostrarOrdenPorCodigoTreeMap(TreeMap<String, Venta> ventasTreeMap){

        ventasTreeMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
                System.out.println("Informacion de las ventas ordenadas por codigo de producto:" + " Codigo: " + entry.getValue().getCodigo() + " Nombre: " + entry.getValue().getNombre() + " Cantidad Vendida: " + entry.getValue().getCantidadVendida() + " Valor Total: " + entry.getValue().getValorTotal());
            });
    }

    public static void mostrarPorOrden(TreeMap<String, Venta> ventasTreeMap){

        ventasTreeMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
                System.out.println("Informacion de las ventas ordenadas por codigo de producto:" + " Codigo: " + entry.getValue().getCodigo() + " Nombre: " + entry.getValue().getNombre() + " Cantidad Vendida: " + entry.getValue().getCantidadVendida() + " Valor Total: " + entry.getValue().getValorTotal());
            });
    }
}
