/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

import java.util.Objects;
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
    private Caballo caballo;
    //creamos el contructor por defecto que cree un caballo negro en la posicion '8b'
    
    public Caballo()
    { //para hacerlo primero se nombra el atributo y a continuacion la clase a la que pertenece seguido del atributo de dicha clase.
        color=Color.NEGRO;
        posicion=new Posicion(8,'b');        
    }
    
    /*Crea un constructor para la clase que acepte como parámetro el color que creará un caballo    
      de dicho color cuya posición será '1b' si es blanco o '8b' si es negro..*/
    /**
     * @param color
     * BLANCO
     * NEGRO
     */
    public Caballo(Color color){
       this.color=color;
       
       switch(color){
           case BLANCO:
               posicion=new Posicion(1,'b');
               break;
           case NEGRO:
               posicion=new Posicion(8,'b');
               break;
       }
    }
    
    /*Crea un constructor para la clase que acepte como parámetros el color y la columna inicial.
      La columna inicial debe ser la 'b' o la 'g' (de lo contrario debe lanzar la excepción IllegalArgumentException con un mensaje adecuado)
      y creara un caballo del color dado y colocado en dicha columna y cuya fila será la 1 si el blanco y la 8 si es el negro.*/

    /**
     *
     * @param color
     * @param columnaInicial
     */
    public Caballo(Color color,char columnaInicial) throws OperationNotSupportedException {
        setColor(color);
        
        if(columnaInicial==0){
            throw new IllegalArgumentException("Error, columna introducida incorrecta");
        }
        if(columnaInicial!='b' & columnaInicial!='g'){
            throw new IllegalArgumentException("Error, columna introducida incorrecta");
        }
        try{
            if(color==Color.BLANCO & columnaInicial=='b'){
                    posicion=new Posicion (1,'b');
                }
                if(color==Color.BLANCO & columnaInicial=='g'){
                    posicion=new Posicion (1,'g');
                }
                if(color==Color.NEGRO & columnaInicial=='b'){
                    posicion=new Posicion (8,'b');
                }
                if(color==Color.NEGRO & columnaInicial=='g'){
                    posicion=new Posicion (8,'g');
                }
        }catch (IllegalArgumentException e){
            System.out.println("MOVIMIENTO INCORRECTO");
            throw new OperationNotSupportedException(MOVIMIENTO_INCORRECTO);
        }
    }
    
    /*crea el metodo mover que dependiendo del movimiento modificara la posicion del mismo
      o si no puede realizar dicho movimiento lanza una excepcion del tipo OperationNotSupportedException
      y no modificara la posicion del caballo*/
    
    public void moverCaballo(Direccion direccion) throws OperationNotSupportedException {
     
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
        } 
    }

    //creamos el metodo equals para comparar los objetos de la clase

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.color);
        hash = 59 * hash + Objects.hashCode(this.posicion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Caballo other = (Caballo) obj;
        if (this.color != other.color) {
            return false;
        }
        if (!Objects.equals(this.posicion, other.posicion)) {
            return false;
        }
        return true;
    }
    
    //creamos el metodo toString que devuelve un String que será la representacion de dicho objeto

    @Override
    public String toString() {
        return "Caballo{" + "color=" + color + ", posicion=" + posicion + '}';
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
