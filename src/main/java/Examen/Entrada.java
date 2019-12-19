package Examen;
import java.util.Scanner;

/**
 * Clase que permite leer distintos tipos de datos desde teclado
 * @author Antonio Ramos
 * @version 1.2
 */
public class Entrada {
    /**
     * Método que permite la lectura desde teclado de un número entero
     * @return devuelve el número introducido desde teclado
     */
    public static int leerEntero(){
        Scanner teclado = new Scanner(System.in);
        do{
            try{
                return teclado.nextInt();                
            }
            catch(Exception e){
                System.out.println("Error. El valor introducido no es un número. Vuelva a intentarlo.");
                teclado.nextLine();
            }
        }while(true);
    }
    
    /**
     * Método que permite la lectura desde teclado de un número entero
     * @param mensaje muestra un mensaje por pantalla
     * @return devuelve el número introducido desde teclado
     */
    public static int leerEntero(String mensaje){
        System.out.print(mensaje);
        return leerEntero();
    }
    
    /**
     * Método que permite la lectura desde teclado de un número entero entre un valor máximo y uno mínimo
     * @param minimo valor mínimo que se acepta como válido
     * @param maximo valor máximo que se acepta como válido
     * @return devuelve el número introducido desde teclado
     */
    public static int leerEntero(int minimo, int maximo){
        int numero;
        do{
            numero = leerEntero();
            if(numero < minimo || numero > maximo)
                System.out.format("Error. El número tiene que estar entre %d y %d (ambos incluidos).\n"
                        + "Introduzca un nuevo número: ", minimo, maximo);
            else
                return numero;
        }while(true);
    }
    
    /**
     * Método que permite la lectura desde teclado de un número entero largo o long
     * @return devuelve el número introducido desde teclado
     */
    public static long leerEnteroLargo(){
        Scanner teclado = new Scanner(System.in);
        boolean repetir = true;
        long numero = 0;
        do{
            try{
                numero = teclado.nextLong();
                repetir = false;
            }
            catch(Exception e){
                System.out.println("Error. El valor introducido no es un número");
                teclado.nextLine();
            }
        }while(repetir == true);
        
        return numero;
    }
    
    /**
     * Método que permite la lectura desde teclado de un número decimal
     * @return devuelve el número introducido desde teclado
     */
    public static float leerReal(){
        Scanner teclado = new Scanner(System.in);
        boolean repetir = true;
        float numero = 0;
        do{
            try{
                numero = teclado.nextFloat();
                repetir = false;
            }
            catch(Exception e){
                System.out.println("Error. El valor introducido no es un número");
                teclado.nextLine();
            }
        }while(repetir == true);
        
        return numero;
    }
    
    /**
     * Método que permite la lectura desde teclado de un número decimal de mayor precisión
     * @return devuelve el número introducido desde teclado
     */
    public static double leerRealLargo(){
        Scanner teclado = new Scanner(System.in);
        boolean repetir = true;
        double numero = 0;
        do{
            try{
                numero = teclado.nextDouble();
                repetir = false;
            }
            catch(Exception e){
                System.out.println("Error. El valor introducido no es un número");
                teclado.nextLine();
            }
        }while(repetir == true);
        
        return numero;
    }
    
    /**
     * Método que permite la lectura desde teclado de una cadena de caracteres
     * @return devuelve la cadena de caracteres introducida desde teclado
     */
    public static String leerCadena(){
        Scanner teclado = new Scanner(System.in);
        boolean repetir = true;
        String cadena = "";
        do{
            try{
                cadena = teclado.next();
                repetir = false;
            }
            catch(Exception e){
                System.out.println("Error.");
            }
        }while(repetir == true);
        
        return cadena;
    }
    
    /**
     * Método que permite la lectura desde teclado de un caracter
     * @return devuelve el caracter introducido desde teclado
     */
    public static char leerCaracter(){
        Scanner teclado = new Scanner(System.in);
        boolean repetir = true;
        String cadena = "";
        do{
            try{
                cadena = teclado.next();
                repetir = false;
            }
            catch(Exception e){
                System.out.println("Error. No se ha introducido ningún carácter");
            }
        }while(repetir == true);
        
        return cadena.charAt(0);
    }
    
    /**
     * Método que permite la lectura desde teclado de un carácter
     * @param mensaje muestra un texto por pantalla
     * @return devuelve el caracter introducido desde teclado
     */
    public static char leerCaracter(String mensaje){
        System.out.print(mensaje);
        return leerCaracter();
    }
   
    /**
     * Método que permite la lectura desde teclado de un valor booleano
     * @return devuelve el valor booleano introducido desde teclado
     */
    public static boolean leerBooleano(){
        Scanner teclado = new Scanner(System.in);
        boolean repetir = true;
        boolean valor = false;
        do{
            try{
                valor = teclado.nextBoolean();
                repetir = false;
            }
            catch(Exception e){
                System.out.println("Error. No se ha introducido ningún carácter");
            }
        }while(repetir == true);
        
        return valor;
    }
}
