package co.edu.uniquindio.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Camion<T extends Paquete> implements Iterable<T>, Comparable<Camion<T>> {

    private String placa;
    private double capacidadCarga;
    private ArrayList<T> paquetes;

    public Camion(double capacidadCarga, ArrayList<T> paquetes, String placa) {
        this.capacidadCarga = capacidadCarga;
        this.paquetes = paquetes;
        this.placa = placa;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorCamion();
    }

    public IteradorCamion iteradorBidireccional() {
        return new IteradorCamion();
    }

    public class IteradorCamion implements Iterator<T> {

        private int indice = 0;

        @Override
        public boolean hasNext() {
            return indice < paquetes.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay siguiente paquete");
            }
            return paquetes.get(indice++);
        }

        public boolean hasPrevious() {
            return indice > 0;
        }

        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("No hay paquete anterior");
            }
            indice--;
            return paquetes.get(indice);
        }

        public int getIndiceActual() {
            return indice;
        }
    }

    @Override
    public int compareTo(Camion<T> o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public ArrayList<T> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<T> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Camion{");
        sb.append("placa=").append(placa);
        sb.append(", capacidadCarga=").append(capacidadCarga);
        sb.append(", paquetes=").append(paquetes);
        sb.append('}');
        return sb.toString();
    }

    public static <T extends Paquete> void cargarCamion(Camion<T> camion, ArrayList<Paquete> paquetes, Paquete paquete) throws capacidadExcedidaException {

        if (camion.getCapacidadCarga() < paquete.getPeso()) {
            throw new capacidadExcedidaException("El paquete excede la capacidad de carga del camión.");
        } else if (camion.getPaquetes().size() >= camion.getCapacidadCarga()) {
            throw new capacidadExcedidaException("El camión ya ha alcanzado su capacidad máxima de carga.");
        } else {
            System.out.println("Cargando paquete " + paquete.getCodigo() + " al camión " + camion.getPlaca());
        }

    }


    public static <T extends Paquete> void descargarCamion(Camion<T> camion, ArrayList<Paquete> paquetes) throws camionVacioException{

        if(camion.getPaquetes().isEmpty()){

            throw new camionVacioException("El camión está vació, no hay paquetes para descargar");

        }else{

            for(Paquete paquete: camion.getPaquetes()){

                System.out.println("Descargando paquete " + paquete.getCodigo() + " con un peso de: " + paquete.getPeso() + " del camión " + camion.getPlaca());

            }
        }
    }


    public static <T extends Paquete> void mostrarPaqueteMasPesado(Camion<T> camion) throws camionVacioException {

        if (camion.getPaquetes().isEmpty()) {
            throw new camionVacioException("El camión está vació, no hay paquetes para mostrar");
        } else {
            T paqueteMasPesado = camion.getPaquetes().get(0);
            for (T paquete : camion.getPaquetes()) {
                if (paquete.getPeso() > paqueteMasPesado.getPeso()) {
                    paqueteMasPesado = paquete;
                }
            }
            System.out.println("El paquete más pesado en el camión " + camion.getPlaca() + " es: " + paqueteMasPesado.getCodigo() + " con un peso de: " + paqueteMasPesado.getPeso());
        }
    }

    public static <T extends Paquete> void recorrerCamionPosicionesPares(Camion<T> camion) throws camionVacioException {

        if (camion.getPaquetes().isEmpty()) {
            throw new camionVacioException("El camion esta vacio, no hay paquetes para recorrer");
        }

        System.out.println("Paquetes en posiciones pares del camion " + camion.getPlaca() + ":");
        for (int i = 0; i < camion.getPaquetes().size(); i += 2) {
            T paquete = camion.getPaquetes().get(i);
            System.out.println("Posicion " + i + ": " + paquete);
        }
    }


    public static void imprimirCodigosParesWildcard(Camion<? extends Paquete> camion) throws camionVacioException {

        if (camion.getPaquetes().isEmpty()) {
            throw new camionVacioException("El camion esta vacio, no hay paquetes para recorrer");
        }

        System.out.println("Codigos en posiciones pares del camion " + camion.getPlaca() + ":");
        for (int i = 0; i < camion.getPaquetes().size(); i += 2) {
            Paquete paquete = camion.getPaquetes().get(i);
            System.out.println("Posicion " + i + " -> Codigo: " + paquete.getCodigo());
        }
    }
}
