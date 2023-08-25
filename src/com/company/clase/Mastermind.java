package com.company.clase;

import java.util.Random;
import java.util.Scanner;

public class Mastermind {
    // Definimos las constantes del juego.
    private static final int longitud = 5; // Longitud del código
    private static final int turnos = 12; // Número de turnos permitidos
    private static final String[] colores = {"Blanco", "Amarillo", "Naranja", "Rosa", "Rojo", "Verde", "Azul", "Negro"}; // Arreglo de colores posibles

    // Definimos las variables globales.
    // Almacenará el código secreto
    private static String[] codigo = new String[longitud];
    // Almacenará la jugada actual del usuario
    private static String[] jugada = new String[longitud];
    // Almacenará el resultado de la jugada actual
    private static String[] resultado = new String[longitud];
    // Almacenará el código secreto
    private static int turno = 0;

    public static void createcodigo() {
        //Creamos el cóodigo secreto de forma alestoria.
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            //Asignamos un color al azar al código de la posición.
            codigo[i] = colores[random.nextInt(colores.length)];
        }
    }

    public static void getjugada() {
        // Obtenemos la jugada del usuario.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu combinacion de 5 colores (Amarillo, Naranja, Rosa, Rojo, Verde, Azul):");
        for (int i = 0; i < longitud; i++) {
            // Almacenamos la jugada del usuario en la posición actual.
            jugada[i] = scanner.next();
        }
    }

    public static void checkjugada() {
        // Verificamos la jugada del usuario y asignamos el resultado.
        for (int i = 0; i < longitud; i++) {
            resultado[i] = "Vacio";
            if (jugada[i].equals(codigo[i])) {
                // Asignamos el color "Negro" si la jugada es igual al código en la posición actual.
                resultado[i] = "Negro";
                continue;
            } else {
                for (int j = 0; j < longitud; j++) {
                    if (jugada[i].equals(codigo[j])) {
                        // Asignamos el color "Blanco" si la jugada es igual a un color en el código, pero en una posición diferente.
                        resultado[i] = "Blanco";
                        break;
                    }
                }
            }
        }
    }

    public static String getresultado() {
        // Utilizamos este método para obtener el resultado de la comparación de la combinación ingresada y la combinación a adivina.
        StringBuilder auxiliar = new StringBuilder();
        for (String r : resultado) {
            // Añadimos el resultado a una cadena.
            auxiliar.append(r + " ");
        }
        //Hacemos un return para la cadena de resultado
        return auxiliar.toString();
    }

    public static boolean haganado() {
        // Utilizamos este método para determinar si el jugador ha ganado.
        for (String resultadoauxiliar : resultado) {
            // Si no todos los resultados son "Negro", devolvemos el boolean false.
            if (!resultadoauxiliar.equals("Negro")) {
                return false;
            }
        }
        // Si todos los resultados son "Negro", devolvemos el boolean true.
        return true;
    }

    public static String getcodigo() {
        // Utilizamos este método para obtener la combinación a adivinar.
        StringBuilder cadena = new StringBuilder();
        for (String c : codigo) {
            // Añadimos cada color de la combinación a una cadena.
            cadena.append(c + " ");
        }
        // Devolvemos la cadena con la combinación a adivinar.
        return cadena.toString();
    }
}

