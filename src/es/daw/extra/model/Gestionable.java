package es.daw.extra.model;

import es.daw.extra.exception.IncumplimientoException;
import java.util.ArrayList;

public interface Gestionable {
    
    /**
     * Método que devuelve una lista de solicitudes que no están resueltas
     * @return 
     */
    public ArrayList<Solicitud> obtenerSolicitudesSinResolver();
    
    /**
     * Método que devuelve una lista de solicitudes resueltas
     * @return 
     */
    public ArrayList<Solicitud> obtenerSolicitudesResueltas();
    
    /**
     * Método que cierra o resuelve una solicitud.
     * Cuando los días transcurridos desde la fecha de creación de solicitud hasta su fechas de cierre
     * superen los días establecidos en el contrato (dependiendo del tipo de cliente y la prioridad si es una incidencia)
     * se lanzará una excepción
     * @param solicitud
     * @throws IncumplimientoException 
     */
    public void cerrarSolicitud(Solicitud solicitud) throws IncumplimientoException;
    
}
