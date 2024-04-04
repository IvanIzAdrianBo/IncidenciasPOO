/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.extra.model;

import java.util.Comparator;

/**
 *
 * @author alumnot
 */
public class ComparatorByFecha implements Comparator <Solicitud> {

    @Override
    public int compare(Solicitud t, Solicitud t1) {
        return t.getFechaResolucion().compareTo(t1.getFechaResolucion());
    }
    
}
