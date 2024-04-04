package es.daw.extra;

import es.daw.extra.dao.SolicitudDAO;
import es.daw.extra.enumerados.TIPO_CLIENTE;
import es.daw.extra.enumerados.TIPO_PRIORIDAD;
import es.daw.extra.exception.IncumplimientoException;
import es.daw.extra.model.ComparatorByFecha;
import es.daw.extra.model.GestorSolicitudes;
import es.daw.extra.model.Incidencia;
import es.daw.extra.model.Mejora;
import es.daw.extra.model.Solicitud;
import java.time.LocalDate;
import java.util.ArrayList;
import static utils.Utilidades.*;

public class Ej1App {


    public static void main(String[] args) {
        /* PRUEBAS
        Mejora mejora = new Mejora("Test cerrado", TIPO_CLIENTE.BRONZE, LocalDate.now().minusDays(16));
        System.out.println(mejora);
        
        try {
            gestorSolicitudes.cerrarSolicitudMenu(mejora);
        } catch (IncumplimientoException ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println(mejora);
        
        System.out.println("==========================");
        
        
        Incidencia incidencia = new Incidencia(TIPO_PRIORIDAD.P1, "Test cerrado", TIPO_CLIENTE.BRONZE, LocalDate.now().minusDays(6));
        System.out.println(incidencia);
        
        try {
            gestorSolicitudes.cerrarSolicitudMenu(incidencia);
        } catch (IncumplimientoException ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println(incidencia);
        */
        
        SolicitudDAO solicitudDAO = new SolicitudDAO();
        GestorSolicitudes gestorSolicitudes = new GestorSolicitudes(solicitudDAO.selectAll());
        
        menuPrincipal(gestorSolicitudes);
    }

    
    public static void menuPrincipal(GestorSolicitudes gs){
        int opcion;
        do {
            System.out.println("\n\n\n");
            pintaMenu();
            opcion = leerEntero("Introduce una opción: ");
            switch (opcion) {
                case 1:
                    System.out.println("\n\n\nLISTADO DE TODAS LAS SOLICITUDES");
                    mostrarSolicitudes(gs.getSolicitudes());
                    pausa();
                    break;
                case 2:
                    if (gs.obtenerSolicitudesResueltas().isEmpty())
                        System.out.println("No hay ninguna solicitud resuelta...");
                    else
                        mostrarSolicitudes(gs.obtenerSolicitudesResueltas(), new ComparatorByFecha());
                    pausa();
                    break;
                case 3:
                    menuCerrarSolicitud(gs);
                    break;
                case 4:
                    System.out.println("PROXIMAMENTE");
                    pausa();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    pausa();
            }
            
        } while (opcion != 5);
    }
    
    public static void menuCerrarSolicitud(GestorSolicitudes gs){
        int opcion;
        do {
            System.out.println("\n\n\n");
            pintaMenuCerrarSolicitud();
            opcion = leerEntero("Introduce una opción: ");
            switch (opcion) {
                case 1:
                    cerrarSolicitudMenu(gs, obtenerIncidencias(gs.obtenerSolicitudesSinResolver()));
                    pausa();
                    break;
                case 2:
                    cerrarSolicitudMenu(gs, obtenerMejoras(gs.obtenerSolicitudesSinResolver()));
                    pausa();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 3);
    }
}
