package es.daw.extra.dao;
import es.daw.extra.enumerados.TIPO_CLIENTE;
import es.daw.extra.enumerados.TIPO_PRIORIDAD;
import es.daw.extra.model.Incidencia;
import es.daw.extra.model.Mejora;
import es.daw.extra.model.Solicitud;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author melol
 */
public class SolicitudDAO {


    private ArrayList<Solicitud> solicitudes = new ArrayList<>();
    
    public SolicitudDAO(){
        solicitudes.add(new Mejora("Actualizar tipos de IVA de la nueva normativa", TIPO_CLIENTE.GOLD,LocalDate.of(2023,05,30)));
        solicitudes.add(new Mejora("Revisión descripción de productos", TIPO_CLIENTE.SILVER,LocalDate.of(2023,05,19)));
        solicitudes.add(new Mejora("No sale la fecha correcta en el informe", TIPO_CLIENTE.SILVER));
        solicitudes.add(new Incidencia(TIPO_PRIORIDAD.P1,"No calcula bien el total", TIPO_CLIENTE.SILVER, LocalDate.of(2023,06,01)));
        solicitudes.add(new Incidencia(TIPO_PRIORIDAD.P2,"Pantalla en negro", TIPO_CLIENTE.GOLD, LocalDate.of(2023,05,02)));
        solicitudes.add(new Incidencia(TIPO_PRIORIDAD.P3,"OutofMemory exception", TIPO_CLIENTE.BRONZE));
    }
    
    public ArrayList<Solicitud> selectAll() {
        return (ArrayList<Solicitud>) solicitudes.clone();
    }               
    
}
