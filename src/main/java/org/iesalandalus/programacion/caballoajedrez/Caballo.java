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
    
    //creamos el contructor por defecto que cree un caballo negro en la posicion '8b'
    
    public Caballo()
    { //para hacerlo primero se nombra el atributo y a continuacion la clase a la que pertenece seguido del atributo de dicha clase.
        color=Color.NEGRO;
        posicion=new Posicion(8,'b');        
    }
    
    /*Crea un constructor para la clase que acepte como parámetro el color que creará un caballo    
      de dicho color cuya posición será '1b' si es blanco o '8b' si es negro..*/
    public Caballo(Color color,Posicion posicion){
        if (color==null) //valida que el color introducido no sea nulo, es decir, no es ni blanco ni negro
        {
        throw new IllegalArgumentException("Error, se ha introducido un color incorrecto");
        }
        else
        {
            this.color=color;
        }
        if(color==Color.BLANCO){
            posicion=new Posicion(1,'b');
        }
        else{
            posicion=new Posicion(8,'b');
        }
            
        
    }




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
