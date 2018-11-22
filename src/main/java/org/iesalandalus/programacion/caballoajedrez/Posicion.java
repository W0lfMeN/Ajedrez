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
    
   /*Creamos el constructor que acepte como parametros la fila y columna y que los asigne 
     a los atributos si son correctos y si no que lance una excepcion*/
    
    public Posicion (int fila,char columna)
    { //Se llama al metodo set ya que el es el encargado de validar la fila y la columna
        setFila(fila);
        setColumna(columna);
    }
            
    /* crea un constructor copia para esta clase*/
    public Posicion(final Posicion copia)
    {
        this.columna=copia.columna;
        this.fila=copia.fila;
    }
           
    
    
    
    
    /*creamos los metodos get y set y si para el set la fila no es del 1 al 8 
    ni la columna es desde la a hasta la h muestre un illegalArgumentException*/
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila>=1 || fila<=8){
            this.fila = fila;
        }
        else{
            throw new IllegalArgumentException("Error, se ha introducido una fila incorrecta");
        }
            
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if(columna!='a' & columna!='b' & columna!='c' & columna!='d' & columna!='e' & columna!='f' & columna!='g' & columna!='h'){
           throw new IllegalArgumentException("Error, se ha introducido una columna incorrecta"); 
        }
            
        else{
           this.columna = columna; 
        }
            
    }
}
