/*
 * Hoja de trabajo 1
 * Fecha: 17 / 01 / 2025
 * Grupo: 3
 * */

package com.api;

import java.util.Scanner;
public class Main {

    public static void MiddlewareLicuadoraOn (String msg, boolean on, Runnable function) {
        if (on) {
            function.run();
            System.out.println(msg);
        } else {
            System.out.println("Encender com.api.Licuadora.");
        }
    }

    public static void main(String[] args) {
        Licuadora licuadora = new Licuadora();
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println(
            "LICUADORA\n" +
            "1. Encender/Apagar\n" +
            "2. Vaciar\n" +
            "3. Llenar\n" +
            "4. Consultar llenado\n" +
            "5. Aumentar velocidad\n" +
            "6. Consultar velocidad\n" +
            "7. Salir\n" +
            ">>> ");
            option = scanner.nextInt();

            if (option == 1) {
                licuadora.encender();
                System.out.println(licuadora.on ? "com.api.Licuadora encendida." : "com.api.Licuadora apagada.");
            }

            if (option == 2) {
                licuadora.vaciar();
                System.out.println("com.api.Licuadora vaciada.");
            }

            if (option == 3) {
                licuadora.llenar();
                System.out.println("Elemento agregado. Lleno: " + licuadora.consultarLlenado());
            }

            if (option == 4) {
                System.out.println("¿Está llena la licuadora?: " + licuadora.consultarLlenado());
            }

            if (option == 5) {
                MiddlewareLicuadoraOn(
                        "Velocidad aumentada",
                        licuadora.on,
                        licuadora::aumentarVelocidad
                );
            }

            if (option == 6) {
                MiddlewareLicuadoraOn(
                        "Velocidad actual: " + licuadora.consultarVelocidad(),
                        licuadora.on,
                        licuadora::consultarVelocidad
                );
            }

            if (option == 7) {
                System.out.println("Saliendo del programa...");
            }

        } while (option != 7);
        scanner.close();
    }
}
