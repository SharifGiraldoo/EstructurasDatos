import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {
       HashMap<String,Venta> ventas = new HashMap<>();
      
        registrarVenta(ventas, "001", "Producto A", 10, 100.0);
        registrarVenta(ventas, "002", "Producto B", 5, 50.0);
        consultarInformacionPorCodigo(ventas, "001");
        mostrarVentasRegistradas(ventas);
        mostrarVentasPorOrdenRegistro(ventas);
        mostrarVentasOrdenadasPorCodigoProducto(ventas);
         
       
    }


    public static void registrarVenta(HashMap<String, Venta> ventas, String codigo, String nombre, int cantidadVendida, double valorTotal) {
        if (ventas.containsKey(codigo)) {
            Venta ventaExistente = ventas.get(codigo);
            ventaExistente.setCantidadVendida(ventaExistente.getCantidadVendida() + cantidadVendida);
            ventaExistente.setValorTotal(ventaExistente.getValorTotal() + valorTotal);
        } else {
            Venta nuevaVenta = new Venta(cantidadVendida, codigo, nombre, valorTotal);
            ventas.put(codigo, nuevaVenta);
        }
    }


    public static void consultarInformacionPorCodigo(HashMap<String,Venta> ventas, String codigo){

        if(ventas.containsKey(codigo)){

            Venta ventaEncontrada = ventas.get(codigo);
            System.out.println("Informacion de la venta:" + "Codigo: " + ventaEncontrada.getCodigo() + " Nombre: " + ventaEncontrada.getNombre() + " Cantidad Vendida: " + ventaEncontrada.getCantidadVendida() + " Valor Total: " + ventaEncontrada.getValorTotal());

        }else{
            System.out.println("No se encontro una venta con el código: " + codigo);
        }
    }



    public static void mostrarVentasRegistradas(HashMap<String,Venta> ventas){

        if(ventas.isEmpty()){
            System.out.println("No hay ventas registradas.");
            
        }else{

            for (Map.Entry<String,Venta> ventas1 : ventas.entrySet()) {
                System.out.println("Clave: " + ventas1.getKey() + ", Valor: " + ventas1.getValue());
                System.out.println("Informacion de las ventas:" + " Codigo: " + ventas1.getValue().getCodigo() + " Nombre: " + ventas1.getValue().getNombre() + " Cantidad Vendida: " + ventas1.getValue().getCantidadVendida() + " Valor Total: " + ventas1.getValue().getValorTotal());
        }
        


        }
       
   }


    public static void mostrarVentasOrdenadasPorCodigoProducto(HashMap<String,Venta> ventas){


        ventas.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
                System.out.println("Informacion de las ventas ordenadas por codigo de producto:" + " Codigo: " + entry.getValue().getCodigo() + " Nombre: " + entry.getValue().getNombre() + " Cantidad Vendida: " + entry.getValue().getCantidadVendida() + " Valor Total: " + entry.getValue().getValorTotal());
            });


    }


    public static void mostrarVentasPorOrdenRegistro(HashMap<String,Venta> ventas){
        for (Map.Entry<String,Venta> ventas1 : ventas.entrySet()) {
            System.out.println("Clave: " + ventas1.getKey() + ", Valor: " + ventas1.getValue());
            System.out.println("Informacion de las ventas por orden de registro:" + " Codigo: " + ventas1.getValue().getCodigo() + " Nombre: " + ventas1.getValue().getNombre() + " Cantidad Vendida: " + ventas1.getValue().getCantidadVendida() + " Valor Total: " + ventas1.getValue().getValorTotal());
       }
    }




    



}



