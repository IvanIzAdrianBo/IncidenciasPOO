package es.daw.extra.model;

import es.daw.extra.enumerados.TIPO_CLIENTE;
import java.time.LocalDate;


public class Mejora extends Solicitud{

    public Mejora(String detalle, TIPO_CLIENTE tipoCliente, LocalDate fechaCreacion) {
        super(detalle, tipoCliente, fechaCreacion);
    }

    public Mejora(String detalle, TIPO_CLIENTE tipoCliente) {
        super(detalle, tipoCliente);
    }

    @Override
    public LocalDate calcularFechaLimite() {
        return getFechaCreacion().plusDays(getTipoCliente().diasLimites);
    }

    @Override
    public String toString() {
        return "Mejora{" + super.toString() +  '}';
    }
}
