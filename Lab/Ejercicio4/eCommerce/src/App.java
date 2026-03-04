public class App {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("CATÁLOGO DE PRODUCTOS E-COMMERCE");
        System.out.println("=================================");

        CatalogoEcommerce catalogo = new CatalogoEcommerce();
        catalogo.ejecutarPrueba();
        catalogo.ejecutarPruebaEscalabilidad(100);
    }
}