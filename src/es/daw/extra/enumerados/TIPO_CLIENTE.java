/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package es.daw.extra.enumerados;

/**
 *
 * @author alumnot
 */
public enum TIPO_CLIENTE {
    GOLD(8),
    SILVER(12),
    BRONZE(16);
    
    public int diasLimites;

    private TIPO_CLIENTE(int diasLimites) {
        this.diasLimites = diasLimites;
    }
}
