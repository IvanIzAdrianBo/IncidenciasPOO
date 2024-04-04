package es.daw.extra.model;

import es.daw.extra.exception.IncumplimientoException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorSolicitudes implements Gestionable{
    private ArrayList<Solicitud> solicitudes;

    public GestorSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public ArrayList<Solicitud> getSolicitudes() {
        return (ArrayList<Solicitud>) solicitudes.clone();
    }

    @Override
    public ArrayList<Solicitud> obtenerSolicitudesSinResolver() {
        ArrayList<Solicitud> lista = new ArrayList<>();
        
        solicitudes.forEach((s) -> {
            if (s.getFechaResolucion() == null)
                lista.add(s);
        });
        
        return lista;
    }

    @Override
    public ArrayList<Solicitud> obtenerSolicitudesResueltas() {
        ArrayList<Solicitud> lista = new ArrayList<>();
        
        solicitudes.forEach((s) -> {
            if (s.getFechaResolucion() != null)
                lista.add(s);
        });
        
        return lista;
    }

    @Override
    public void cerrarSolicitud(Solicitud solicitud) throws IncumplimientoException {
        int diferenciaDias;
        // TODO: Esto es una chapuza, refactorizarlo luego
        try{
            diferenciaDias = (int) LocalDate.now().datesUntil(solicitud.calcularFechaLimite()).count();
        } catch (Exception e) {
            diferenciaDias = (int) solicitud.calcularFechaLimite().datesUntil(LocalDate.now()).count();
        }
        
        if (LocalDate.now().isBefore(solicitud.calcularFechaLimite()) || LocalDate.now().isEqual(solicitud.calcularFechaLimite())){
            solicitud.setFechaResolucion(LocalDate.now());
            System.out.println("La solicitud se ha cerrado correctamente.");
        } else {
            throw new IncumplimientoException("INCUMPLIMIENTO DEL CONTRATO EN LA SOLICITUD " + solicitud.getId() + " retraso de " + diferenciaDias + " dia/s");
        }
    }
    
}
