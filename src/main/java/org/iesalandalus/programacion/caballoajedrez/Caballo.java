/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;
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
    private static final String MOVIMIENTO_INCORRECTO="Movimiento incorrecto"; //sirve para cuando se introduce un movimiento incorrecto
    
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
    
    /*crea el metodo mover que dependiendo del movimiento modificara la posicion del mismo
      o si no puede realizar dicho movimiento lanza una excepcion del tipo OperationNotSupportedException
      y no modificara la posicion del caballo*/
    
    public void moverCaballo(Direccion direccion,int x, char y ) throws OperationNotSupportedException {
     
        if (direccion==null){
            throw new IllegalArgumentException("Error, se ha introducido una direccion nula");
        }
        if ((posicion.getFila())<=0 & (posicion.getColumna())<=0){
            throw new IllegalArgumentException("Error, no puede haber fila y columna menor o igual que 0");
        }
        switch(direccion){
            case ARRIBA_DERECHA:
                try{
                    posicion.setFila(posicion.getFila()+2);
                    posicion.setColumna((char)(posicion.getColumna()+1));
                }catch (IllegalArgumentException e){
                    throw new OperationNotSupportedException(MOVIMIENTO_INCORRECTO);
                }
                break;
            case ARRIBA_IZQUIERDA:
                try{
                    posicion.setFila(posicion.getFila()+2);
                    posicion.setColumna((char)(posicion.getColumna()-1));
                }catch(IllegalArgumentException e){
                    throw new OperationNotSupportedException(MOVIMIENTO_INCORRECTO);
                }
                break;
            case ABAJO_DERECHA:
                try{
                    posicion.setFila(posicion.getFila()-2);
                    posicion.setColumna((char)(posicion.getColumna()+1));
                }catch (IllegalArgumentException e){
                    throw new OperationNotSupportedException(MOVIMIENTO_INCORRECTO);
                }
                break;
            case ABAJO_IZQUIERDA:
                try{
                    posicion.setFila(posicion.getFila()-2);
                    posicion.setColumna((char)(posicion.getColumna()-1));
                }catch (IllegalArgumentException e){
                    throw new OperationNotSupportedException(MOVIMIENTO_INCORRECTO);
                }
                break;
            case DERECHA_ARRIBA:
                try{
                    posicion.setFila(posicion.getFila()+1);
                    posicion.setColumna((char)(posicion.getColumna()+2));
                }catch (IllegalArgumentException e){
                    throw new OperationNotSupportedException(MOVIMIENTO_INCORRECTO);
                }
                break;
            case DERECHA_ABAJO:
                 try{
                    posicion.setFila(posicion.getFila()-1);
                    posicion.setColumna((char)(posicion.getColumna()+2));
                }catch (IllegalArgumentException e){
                    throw new OperationNotSupportedException(MOVIMIENTO_INCORRECTO);
                }
                break;
            case IZQUIERDA_ARRIBA:
                 try{
                    posicion.setFila(posicion.getFila()+1);
                    posicion.setColumna((char)(posicion.getColumna()-2));
                }catch (IllegalArgumentException e){
                    throw new OperationNotSupportedException(MOVIMIENTO_INCORRECTO);
                }
                break;
            case IZQUIERDA_ABAJO:
                 try{
                    posicion.setFila(posicion.getFila()-1);
                    posicion.setColumna((char)(posicion.getColumna()-2));
                }catch (IllegalArgumentException e){
                    throw new OperationNotSupportedException(MOVIMIENTO_INCORRECTO);
                }
                break;
            default:
                break;
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
