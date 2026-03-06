package co.edu.uniquindio.generics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Camion<Paquete> camion1 = new Camion<>(1000.0, new ArrayList<>(), "ABC123");
        Paquete paquete1 = new Paquete("P001", "Juan Perez", "Calle 123", 200.0);
        Paquete paquete2 = new Paquete("P002", "Maria Gomez", "Avenida 456", 300.0);
        camion1.getPaquetes().add(paquete1);
        camion1.getPaquetes().add(paquete2);


        
        try {
            Camion.imprimirCodigosParesWildcard(camion1);
        } catch (Exception e) {
            e.printStackTrace();
        }

       
        try {
            camion1.cargarCamion(camion1, camion1.getPaquetes(), paquete2);
             camion1.mostrarPaqueteMasPesado(camion1);
        } catch (Exception e) {

            e.printStackTrace();
        }

        Camion<Paquete> camion2 = new Camion<>(500.0, new ArrayList<>(), "DEF456");
        Paquete paquete3 = new Paquete("P003", "Carlos Lopez", "Calle 789", 100.0);

        try {
            camion2.descargarCamion(camion2, camion2.getPaquetes());
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            camion1.imprimirCodigosParesWildcard(camion1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Camion<Paquete>.IteradorCamion iterador = camion1.iteradorBidireccional();
        System.out.println("Recorrido hacia adelante con iterador propio:");
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }

        System.out.println("Recorrido hacia atras con iterador propio:");
        while (iterador.hasPrevious()) {
            System.out.println(iterador.previous());
        }

        
    }
}
