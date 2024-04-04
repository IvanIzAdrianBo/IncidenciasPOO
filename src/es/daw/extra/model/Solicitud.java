package es.daw.extra.model;

import es.daw.extra.enumerados.TIPO_CLIENTE;
import java.time.LocalDate;

/**
 *
 * @author javaee
 */
public abstract class Solicitud implements Comparable<Solicitud> {

    static private int contador = 1;
    private int id;
    private String detalle;
    private LocalDate fechaCreacion;
    private TIPO_CLIENTE tipoCliente;
    private LocalDate fechaResolucion;

    public Solicitud(String detalle, TIPO_CLIENTE tipoCliente, LocalDate fechaCreacion) {
        this.detalle = detalle;
        this.fechaCreacion = fechaCreacion;
        this.tipoCliente = tipoCliente;
        this.fechaResolucion = null;
        this.id = contador;
        contador++;
    }

    public Solicitud(String detalle, TIPO_CLIENTE tipoCliente) {
        this(detalle, tipoCliente, LocalDate.now());
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaResolucion(LocalDate fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    public TIPO_CLIENTE getTipoCliente() {
        return tipoCliente;
    }
    
    public abstract LocalDate calcularFechaLimite();
    
    @Override
    public int compareTo(Solicitud t){
        return Integer.compare(t.getId(), id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Solicitud{");
        sb.append("id=").append(id);
        sb.append(", detalle=").append(detalle);
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", tipoCliente=").append(tipoCliente);
        sb.append(", fechaResolucion=").append(fechaResolucion);
        sb.append('}');
        return sb.toString();
    }
    
    

    
    
}
