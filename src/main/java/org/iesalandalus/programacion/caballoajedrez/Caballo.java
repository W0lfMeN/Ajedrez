/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

/**
 *
 * @author Carlos
 */
public class Caballo {
    //creamos la clase caballo con los atributos
    /* para hacer referencia a otras clases se pone el nombre de la clase 
    y a continuacion el nombre del atributo*/
    
    private Color color;
    private Posicion posicion;
    
    //creamos los metodos get y set para cada atributo

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    
    
}