package co.edu.uniquindio.generics;

import java.time.LocalDate;


public class Tarea<T> {

    private String descripcion; 
    private int prioridad; 
    LocalDate fechaVencimiento; 
    

    public Tarea(String descripcion, LocalDate fechaVencimiento, int prioridad) {
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tarea{");
        sb.append("descripcion=").append(descripcion);
        sb.append(", prioridad=").append(prioridad);
        sb.append(", fechaVencimiento=").append(fechaVencimiento);
        sb.append('}');
        return sb.toString();
    }


    




    

}
