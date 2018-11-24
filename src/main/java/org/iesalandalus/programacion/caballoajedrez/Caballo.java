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
    public Caballo(Color color){
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
    
    /*Crea un constructor para la clase que acepte como parámetros el color y la columna inicial.
      La columna inicial debe ser la 'b' o la 'g' (de lo contrario debe lanzar la excepción IllegalArgumentException con un mensaje adecuado)
      y creara un caballo del color dado y colocado en dicha columna y cuya fila será la 1 si el blanco y la 8 si es el negro.*/
    
    public Caballo(Color color,char columnaInicial){
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
        
        if(columnaInicial!='b' & columnaInicial!='g'){
            throw new IllegalArgumentException("Error, la columna introducida es incorrecta");
        }
        if(this.color==Color.BLANCO & columnaInicial=='b'){
            this.posicion=new Posicion (1,'b');
        }
        if(this.color==Color.BLANCO & columnaInicial=='g'){
            this.posicion=new Posicion (1,'g');
        }
        if(this.color==Color.NEGRO & columnaInicial=='b'){
            this.posicion=new Posicion (8,'b');
        }
        if(this.color==Color.NEGRO & columnaInicial=='g'){
            this.posicion=new Posicion (8,'g');
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
