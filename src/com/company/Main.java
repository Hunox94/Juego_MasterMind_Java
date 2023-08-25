package com.company;

import static com.company.clase.Mastermind.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // Contador para llevar el registro de los turnos realizados.
        int turno = 0;
        // Número máximo de turnos permitidos en el juego.
        final int turnos = 12;
        System.out.println("Bienvenido al juego Mastermind!.");
        System.out.println("El objetivo del juego es adivinar el codigo secreto de 5 colores.");
        System.out.println("Los colores disponibles son: Blanco, Amarillo, Naranja, Rosa, Rojo, Verde, Azul y Negro.");
        System.out.println("El jugador que intenta adivinar el codigo tiene un maximo de 12 intentos para descifrar el patrón.");
        System.out.println("Vamos a generar el codigo aleatoriamente.");
        // Llamada al método para generar el código secreto.
        createcodigo();
        // Bucle que se repite hasta que el número de turnos permitidos se alcance o se haya adivinado el código secreto.
        while (turno < turnos) {
            // Llamada al método para obtener la jugada del usuario.
            getjugada();
            // Llamada al método para chequear la jugada del usuario.
            checkjugada();
            System.out.println("Su resultado es: " + getresultado());
            // Si el usuario ha ganado, se muestra el mensaje y se termina el bucle.
            if (haganado()) {
                System.out.println("Ganaste! El codigo ganador es:  " + getcodigo());
                break;
            }
            // Incremento del contador de turnos.
            turno++;
        }
        // Si se alcanzó el número máximo de turnos y no se adivinó el código secreto, se muestra un mensaje de pérdida.
        if (turno == turnos) {
            System.out.println("Perdiste! El codigo ganador es:  " + getcodigo());
        }
    }

}

