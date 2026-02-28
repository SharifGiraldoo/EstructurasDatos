public class Cliente implements Comparable<Cliente> {

    private String nombre;
    private int edad;

    public Cliente(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Cliente otro) {
        // Orden natural: menor a mayor por edad
        return this.edad - otro.edad;
    }

    @Override
    public String toString() {
        return nombre + " - Edad: " + edad;
    }
}