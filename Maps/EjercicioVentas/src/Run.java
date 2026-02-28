import java.util.LinkedHashMap;
import java.util.Map;

public class Run {


    public static void main(String[] args) {

         LinkedHashMap<String, Venta> ventasLinkedHash = new LinkedHashMap<> ();
         registrarVentLinked(ventasLinkedHash, "001", "Producto A", 10, 100.0);
         registrarVentLinked(ventasLinkedHash, "002", "Producto B", 5, 50.0);
         consultarInfoPorCodigoLinkedHash(ventasLinkedHash, "001");
         mostrarVentasRegistradasLinkedHash(ventasLinkedHash);

        
    }


      public static void registrarVentLinked(LinkedHashMap<String, Venta> ventasLiinkedHash, String codigo, String nombre, int cantidadVendida, double valorTotal) {
        if (ventasLiinkedHash.containsKey(codigo)) {
            Venta ventaExistente = ventasLiinkedHash.get(codigo);
            ventaExistente.setCantidadVendida(ventaExistente.getCantidadVendida() + cantidadVendida);
            ventaExistente.setValorTotal(ventaExistente.getValorTotal() + valorTotal);
        } else {
            Venta nuevaVenta = new Venta(cantidadVendida, codigo, nombre, valorTotal);
            ventasLiinkedHash.put(codigo, nuevaVenta);
        }
    }


    public static void consultarInfoPorCodigoLinkedHash(LinkedHashMap<String,Venta> ventasLinkedHashMap, String codigo){

        if(ventasLinkedHashMap.containsKey(codigo)){

            Venta ventaEncontrada = ventasLinkedHashMap.get(codigo);
            System.out.println("Informacion de la venta:" + "Codigo: " + ventaEncontrada.getCodigo() + " Nombre: " + ventaEncontrada.getNombre() + " Cantidad Vendida: " + ventaEncontrada.getCantidadVendida() + " Valor Total: " + ventaEncontrada.getValorTotal());

        }else{
            System.out.println("No se encontro una venta con el código: " + codigo);
        }

    }


    public static void mostrarVentasRegistradasLinkedHash(LinkedHashMap<String, Venta> ventasLinkedHashMap){

        if(ventasLinkedHashMap.isEmpty()){
            System.out.println("No se encuentran ventas");
        }else{


            for (Map.Entry<String,Venta> ventas1 : ventasLinkedHashMap.entrySet()) {
                System.out.println("Clave: " + ventas1.getKey() + ", Valor: " + ventas1.getValue());
                System.out.println("Informacion de las ventas:" + " Codigo: " + ventas1.getValue().getCodigo() + " Nombre: " + ventas1.getValue().getNombre() + " Cantidad Vendida: " + ventas1.getValue().getCantidadVendida() + " Valor Total: " + ventas1.getValue().getValorTotal());
        }


        }

    }


    public static void mostrarOrdenPorCodigoLinkedHash(LinkedHashMap<String, Venta> ventasLinkedHashMap){

        ventasLinkedHashMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
                System.out.println("Informacion de las ventas ordenadas por codigo de producto:" + " Codigo: " + entry.getValue().getCodigo() + " Nombre: " + entry.getValue().getNombre() + " Cantidad Vendida: " + entry.getValue().getCantidadVendida() + " Valor Total: " + entry.getValue().getValorTotal());
            });

    }
    
}
