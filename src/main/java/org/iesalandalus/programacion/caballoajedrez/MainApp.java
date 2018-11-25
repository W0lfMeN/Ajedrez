package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
        private static Color color;
        private static Direccion direccion;
        private static Posicion posicion;
        private static Posicion columna;
        private static String MOVIMIENTO_INCORRECTO;
        private static Caballo caballo;
        
	public static void main(String[] args) throws OperationNotSupportedException {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
                int opcion;
                
                do{ 
                    //repite mostrar el menu hasta que se introduzca el 0
                    menu();
                    //repite mostrar elegir una opcion del menu
                    opcion=opciones();
                    //permite ejecutar la opcion elegida por el usuario
                    ejecutarOpcion(opcion);
                }while(opcion!=0);
        }
        //metodo que muestra el menu con las opciones 
        public static void menu(){
            System.out.println("-----MENU DEL CABALLO-----");
            System.out.println("-----ELIGE UNA OPCION-----");
            System.out.println("1. Crear un caballo por defecto");
            System.out.println("2. Crear un caballo de un color");
            System.out.println("3. Crear un caballo de un color y columna inicial");
            System.out.println("4. Mover el caballo");
            System.out.println("0. Salir del programa");
        }
    //creamos el metodo que valida la opcion elegida

    /**
     *
     * @return opcion
     */
        public static int opciones(){
            int opcion;
            do{
                System.out.println("Introduce la opcion que desea realizar");
                opcion=Entrada.entero();
            }while (opcion<0 || opcion>4);
            
            return opcion;
        }
        
        //creamos el metodo que ejecuta la opcion elegida
        public static void ejecutarOpcion(int opcion) throws OperationNotSupportedException{
            switch(opcion){
                case 1: //llama al metodo que crea el caballo por defecto
                    creaCaballoDefecto();
                    break;
                case 2://llama al metodo que crea un caballo de un color
                    creaCaballoColor();
                    break;
                case 3://llama al metodo que crea un caballo de un color y posicion incial
                    creaCaballoColorPosicion();
                    break;
                case 4://llama al metodo para mover al caballo
                    moverCaballo();
                    break;
                default:
                    break;
            }
        }
        
        //creamos el metodo creaCaballoDefecto
        private static void creaCaballoDefecto(){
            caballo=new Caballo();//llama a la clase caballo
            
                System.out.println("el caballo ha sido creado");
                System.out.println("su posicion es: ");
                System.out.println(caballo);
        }
        //creamos el metodo creaCaballoColor
        private static void creaCaballoColor(){
            caballo=new Caballo();
            elegirColor();
            
            System.out.println("el caballo ha sido creado");
            System.out.println("caballo " +color);
        }
        //creamos el metodo que elige el color y lo devuelve
        /**
         * 
         * @return color
         */
        private static Color elegirColor(){
            int opcion;
            System.out.println("introduce el color. 1 para BLANCO y 2 para NEGRO");
            opcion=Entrada.entero();
            while(opcion<1 || opcion>2){
                System.out.println("se ha introducido un numero incorrecto, introduce 1 para BLANCO y 2 para NEGRO");
                opcion=Entrada.entero();
            }
            switch(opcion){
                case 1:
                    color=Color.BLANCO;
                    break;
                case 2:
                    color=Color.NEGRO;
                    break;
            }
            return color; //devuelve el color
        }
        //creamos el metodo creaCaballoColorPosicion
        private static void creaCaballoColorPosicion()throws OperationNotSupportedException {
            elegirColor();
            columnaInicial();
            char columnaInicial=posicion.getColumna();
            caballo=new Caballo(color,columnaInicial);
            System.out.println("el caballo ha sido creado");
            System.out.println(caballo);
        }
        
        //creamos el metodo columnaInicial
        private static char columnaInicial(){
            char columnaInicial;
            do{
            System.out.println("introduce una g o una b");
            columnaInicial=Entrada.caracter();
            
            }while(columnaInicial!='b' & columnaInicial!='g');
                
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
                System.out.println("La columna inicial es: "+columnaInicial+ "con posicion: "+posicion);
                
            return columnaInicial;
        }
        
        
        //creamos el metodo moverCaballo
        private static Direccion moverCaballo() throws OperationNotSupportedException{
            //mostramos el menu de movimientos
            System.out.println("-----MOVIMIENTOS DEL CABALLO------");
            System.out.println("1. ARRIBA DERECHA");
            System.out.println("2. ARRIBA IZQUIERDA");
            System.out.println("3. ABAJO DERECHA");
            System.out.println("4. ABAJO IZQUIERDA");
            System.out.println("5. IZQUIERDA ARRIBA");
            System.out.println("6. IZQUIERDA ABAJO");
            System.out.println("7. DERECHA ARRIBA");
            System.out.println("8. DERECHA ABAJO");
            System.out.println("-----MOVIMIENTOS DEL CABALLO-----");
            //fin del menu de movimientos
            int opcion;
           try{
               do{
                   System.out.println("Introduce un numero del 1 al 8");
                   opcion=Entrada.entero();
               }while(opcion<1 || opcion>8);
            switch(opcion){
                case 1:
                    direccion=Direccion.ARRIBA_DERECHA;
                    caballo.moverCaballo(Direccion.ARRIBA_DERECHA);
                    break;
                case 2:
                    direccion=Direccion.ARRIBA_IZQUIERDA;
                    caballo.moverCaballo(Direccion.ARRIBA_IZQUIERDA);
                    break;
                case 3:
                    direccion=Direccion.ABAJO_DERECHA;
                    caballo.moverCaballo(Direccion.ABAJO_DERECHA);
                    break;
                case 4:
                    direccion=Direccion.ABAJO_IZQUIERDA;
                    caballo.moverCaballo(Direccion.ABAJO_IZQUIERDA);
                    break;
                case 5:
                    direccion=Direccion.IZQUIERDA_ARRIBA;
                    caballo.moverCaballo(Direccion.IZQUIERDA_ARRIBA);
                    break;
                case 6:
                    direccion=Direccion.IZQUIERDA_ABAJO;
                    caballo.moverCaballo(Direccion.IZQUIERDA_ABAJO);
                    break;
                case 7:
                    direccion=Direccion.DERECHA_ARRIBA;
                    caballo.moverCaballo(Direccion.DERECHA_ARRIBA);
                    break;
                case 8:
                    direccion=Direccion.DERECHA_ABAJO;
                    caballo.moverCaballo(Direccion.DERECHA_ABAJO);
                    break;
            }
           }catch (OperationNotSupportedException ex){
               Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
           } 
            System.out.println("Moviendo el caballo a la direccion: "+direccion);
            System.out.println(caballo);
            
            return direccion;
        }
        
        
        
}