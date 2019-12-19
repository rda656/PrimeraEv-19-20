/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

/**
 * Clase principal del proyecto
 * @author Antonio Ramos
 * @author 1.0
 */
public class ClasePrincipal {
    /**
     * Constante con el número máximo de errores que se permiten.
     */
    private static final int NUM_MAX_ERRORES = 6;
    
    /**
     * Array bidimensional que guarda la palabra y su definición.
     */
    private static String[][] palabras = {        
        {"AJARDINABA", "Convertir en jardín un terreno."},
        {"BOBINADORA", "Máquina destinada a hilar y a bobinar."},
        {"CUADRATURA", "Situación relativa de dos cuerpos celestes, que en longitud o en ascensión recta distan entre sí respectivamente uno o tres cuartos de círculo."},
        {"DALTONISMO", "Defecto de la vista que consiste en no percibir determinados colores o en confundir algunos de los que se perciben."},
        {"EQUILIBRAR", "Compensar las masas de un mecanismo con el fin de evitar vibraciones perjudiciales en su funcionamiento."},
        {"FIABILIDAD", "Probabilidad de buen funcionamiento de algo."},
        {"GIGANTILLO", "Figura de enano de gran cabeza."},
        {"HABICHUELA", "Diminutivo de haba. Judía."},
        {"ICONOLOGIA", "Estudio de las imágenes y de su valor simbólico."},
        {"JUBILACION", "Pensión que recibe quien se ha jubilado."}
    };
    
    /**
     * Array de caracteres que almacena las letras correctas que introduce el usuario.
     */
    private static char[] respuesta = new char[10];    
    
    /**
     * Palabra seleccionada para el juego.
     */
    private static String palabraBuscada;
    
    /**
     * Fallos cometidos por el jugador.
     */
    private static int fallos;
    
    /**
     * Cantidad de letras que ha encontrado el jugador.
     */
    private static int letrasEncontradas;
    
    /**
     * Clasificación de los jugadores
     */
    //private static String[][] clasificacion = new String[10][2];
    
    
    /**
     * Método principal del proyecto
     * @param args 
     */
    public static void main (String[] args){
        int opcion;
        
        do{
            mostrarMenu();
            opcion = Entrada.leerEntero(0, 2);
            
            switch(opcion){
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    iniciarJuego();
                    jugar();
                    break;
                case 2:
                    System.out.println("Disponible en próximas versiones");
                    break;
            }
        }while (opcion != 0);
    }
    
    /**
     * Método que muestra por pantalla el menú del juego.
     */
    private static void mostrarMenu(){
        System.out.print("JUEGO DEL AHORCADO\n"
                + "Pulse:\n"
                + "1. Nuevo juego.\n"
                + "2. Record de puntos.\n"
                + "0. Salir.\n"
                + "Opción: ");
    }
    
    /**
     * Método que elige una palabra para buscar y resetea la respuesta
     */
    private static void iniciarJuego(){
        fallos = 0;
        letrasEncontradas = 0;
        
        for (int i = 0; i < respuesta.length; i++)
            respuesta[i] = '_';
        
        int numeroAleatorio = (int)(Math.random()*palabras.length);
        
        System.out.println("Definición: " + palabras[numeroAleatorio][1]);
        palabraBuscada = palabras[numeroAleatorio][0];
    }
    
    /**
     * Método en el que se desarrolla el juego hasta que el usuario gana o pierde.
     */
    private static void jugar(){
        int numLetras;
        do{            
            numLetras = verificarLetra(Entrada.leerCaracter("Introduzca una letra: "));
            
            if(numLetras == 0)
                fallos++;
            else
                letrasEncontradas += numLetras;
            
            mostrarEstado();
        }while(fallos < NUM_MAX_ERRORES && letrasEncontradas < 10);
        
        if(fallos == NUM_MAX_ERRORES)
            System.out.println("\n \u001B[31mHas perdido \u001B[0m\n");
        else
            System.out.println("\n \u001B[32m¡GANASTE! \u001B[0m \n");
    }
    
    /**
     * Comprueba si la letra pasada por parámetro se encuentra en la palabra buscada y va añadiendolas al
     * array de la respuesta. Si ya se ha dicho la letra lo tomará como un fallo.
     * @param letra letra a buscar
     * @return número de coincidencias con la letra buscada
     */
    private static int verificarLetra(char letra){
        int contadorDeLetras = 0;        
        letra = Character.toUpperCase(letra);
        
        for(int i = 0; i < palabraBuscada.length(); i++){
            if(palabraBuscada.charAt(i) == letra){
                if(respuesta[i] == '_'){
                    respuesta[i] = letra;
                    contadorDeLetras++;
                }
                else{
                    System.out.println("Letra ya introducida");
                    return 0;
                }                    
            }
        }
        return contadorDeLetras;
    }
    
    /**
     * Muestra las coincidencias de la palabra a buscar y los fallos cometidos.
     */
    private static void mostrarEstado(){
        for(char c : respuesta)
            System.out.print(c);
        System.out.format("\nNúmero de fallos: %d de %d.\n\n",fallos, NUM_MAX_ERRORES);
    }
    
    
}
