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

//Creamos la clase posicion con sus atributos
public class Posicion {
    private int fila;
    private char columna;
    
    
    /*creamos los metodos get y set y si para el set la fila no es del 1 al 8 
    ni la columna es desde la a hasta la h muestre un illegalArgumentException*/
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila>=1 || fila<=8)
            this.fila = fila;
        else
            throw new IllegalArgumentException("Error, se ha introducido una fila incorrecta");
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if(columna!='a' & columna!='b' & columna!='c' & columna!='d' & columna!='e' & columna!='f' & columna!='g' & columna!='h')
            throw new IllegalArgumentException("Error, se ha introducido una columna incorrecta");
        else
            this.columna = columna;
    }
}
