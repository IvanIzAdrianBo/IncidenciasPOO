package utils;

import es.daw.extra.exception.IncumplimientoException;
import es.daw.extra.model.GestorSolicitudes;
import es.daw.extra.model.Incidencia;
import es.daw.extra.model.Mejora;
import es.daw.extra.model.Solicitud;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilidades {
    static public Scanner sc = new Scanner(System.in);

    /**
     * Método que devuelve la fecha (LocalDate) tras añadir los días a la fecha pasada por parámetro 
     * @param fecha
     * @param dias
     * @return 
     */
    public static LocalDate sumaDias(LocalDate fecha, int dias) {
        return fecha.plusDays(dias);
    }

    /**
     * Método que pinta por consola el menú principal
     */
    public static void pintaMenu(){
        System.out.println("\n************* SISTEMA DE GESTIÓN DE INCIDENCIAS Y MEJORAS ***************");
        System.out.println("1. LISTADO DE TODAS LAS SOLICITUDES");
        System.out.println("2. LISTAR LAS SOLICITUDES RESUELTAS ORDENADAS POR FECHA DE RESOLUCIÓN");
        System.out.println("3. CERRAR SOLICITUD");
        System.out.println("4. EXPORTAR TODAS LAS SOLICITUDES A FORMATO CSV");
        System.out.println("5. SALIR");
    }
    
    public static void pintaMenuCerrarSolicitud(){
        System.out.println("¿Qué tipo de solicitud vas a cerrar?");
        System.out.println("1. Incidencia");
        System.out.println("2. Mejora");
        System.out.println("3. Volver al menú principal");
        System.out.println("--------------------------------------");
    }
    
    public static boolean leerEnter(String cadena){
        System.out.print(cadena);
        return sc.nextLine().isEmpty();
    }
    
    public static void pausa(){
        leerEnter("Pulsa ENTER...");
    }
    
    public static int leerEntero(String dialogo){
        while (true){
            System.out.print(dialogo);
            try{  
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e ){
                System.out.println("Introduce un entero valido");
            }
        }
    }
    
    /**
     * Devuelve solo las incidencias de una lista de solicitudes
     * @param solicitudes
     * @return
     */
    public static ArrayList<Solicitud> obtenerIncidencias(ArrayList<Solicitud> solicitudes){
        ArrayList<Solicitud> incidencias = new ArrayList<>();
        for (Solicitud solicitud : solicitudes)
            if (solicitud instanceof Incidencia)
                incidencias.add(solicitud);
        return incidencias;
    }
    
    /**
     * Devuelve solo las mejoras de una lista de solicitudes
     * @param solicitudes
     * @return 
     */
    public static ArrayList<Solicitud> obtenerMejoras(ArrayList<Solicitud> solicitudes){
        ArrayList<Solicitud> incidencias = new ArrayList<>();
        for (Solicitud solicitud : solicitudes)
            if (solicitud instanceof Mejora)
                incidencias.add(solicitud);
        return incidencias;
    }
    
    /**
     * Muestra un menu para cerrar solicitudes de un gestor dada una lista de opciones
     * @param gs
     * @param listaElegir
     */
    public static void cerrarSolicitudMenu(GestorSolicitudes gs, ArrayList<Solicitud> listaElegir){
        int index;
        System.out.println("Este es listado indicando la posición:");
        
        for (int i = 0; i < listaElegir.size(); i++) {
            System.out.printf("[%d] %s\n", i+1, listaElegir.get(i));
        }
        
        while (true) {
            index = leerEntero("Indica la posición de la solicitud a cerrar:") - 1;
            try{
                listaElegir.get(index);
                break;
            } catch (Exception e) {
                System.out.println("La posicion es incorrecta");
            }
        }
        
        try {
            gs.cerrarSolicitud(listaElegir.get(index));
        } catch (IncumplimientoException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * Muestra por pantalla las solicitudes ordenadas en su orden natural
     * @param solicitudes 
     */
    public static void mostrarSolicitudes(ArrayList<Solicitud> solicitudes){
        Collections.sort(solicitudes);
        for (int i = 0; i < solicitudes.size(); i++) {
            System.out.printf("[%d] %s \n", i + 1, solicitudes.get(i));
        }
    }
    
    /**
     * Muestra por pantalla las solicitudes ordenadas segun un comparator
     * @param solicitudes
     * @param comparador
     */
    public static void mostrarSolicitudes(ArrayList<Solicitud> solicitudes, Comparator <Solicitud> comparador){
        solicitudes.sort(comparador);
        for (int i = 0; i < solicitudes.size(); i++) {
            System.out.printf("[%d] %s \n", i + 1, solicitudes.get(i));
        }
    }
    
}
