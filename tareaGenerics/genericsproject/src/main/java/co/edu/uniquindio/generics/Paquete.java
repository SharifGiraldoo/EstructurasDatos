package co.edu.uniquindio.generics;

public class Paquete {

    private String codigo;
    private String destinatario;
    private double peso;
    private String direccion;

    public Paquete(String codigo, String destinatario, String direccion, double peso) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paquete{");
        sb.append("codigo=").append(codigo);
        sb.append(", destinatario=").append(destinatario);
        sb.append(", peso=").append(peso);
        sb.append(", direccion=").append(direccion);
        sb.append('}');
        return sb.toString();
    }




    

}
