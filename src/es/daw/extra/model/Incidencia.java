package es.daw.extra.model;

import es.daw.extra.enumerados.TIPO_PRIORIDAD;
import es.daw.extra.enumerados.TIPO_CLIENTE;
import java.time.LocalDate;

public class Incidencia extends Solicitud{
    
    private TIPO_PRIORIDAD prioridad;

    public Incidencia(TIPO_PRIORIDAD prioridad, String detalle, TIPO_CLIENTE tipoCliente, LocalDate fechaCreacion) {
        super(detalle, tipoCliente, fechaCreacion);
        this.prioridad = prioridad;
    }

    public Incidencia(TIPO_PRIORIDAD prioridad, String detalle, TIPO_CLIENTE tipoCliente) {
        super(detalle, tipoCliente);
        this.prioridad = prioridad;
    }

    @Override
    public LocalDate calcularFechaLimite() {
        switch (prioridad) {
            case P3:
                return getFechaCreacion().plusDays(getTipoCliente().diasLimites);
            case P2:
                return getFechaCreacion().plusDays(getTipoCliente().diasLimites / 2);
            case P1:
                return getFechaCreacion().plusDays(getTipoCliente().diasLimites / 4);
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Incidencia{" + super.toString() + "prioridad=" + prioridad + '}';
    }
}
