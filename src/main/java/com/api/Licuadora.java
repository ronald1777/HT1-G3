/*
* Hoja de trabajo 1
* Fecha: 17 / 01 / 2025
* Grupo: 3
* */

package com.api;

public class Licuadora implements LicuadoraInterface {

    boolean on = false; // 👈 IMPORTANTE 🔴
    int currentElements = 0;
    boolean state = false;
    boolean full = false;
    boolean increase = true;
    int speed = 0;

    public void encender() {
        on = !on;
    }

    public void vaciar () {
        currentElements = !on ? 0 : currentElements;
    }

    public void llenar () {
        if (!full) {
            currentElements++;
        }
        full = currentElements == 5;
    }

    public boolean consultarLlenado () {
        return full;
    }

    public void aumentarVelocidad() {
        if (consultarLlenado()) {
            speed = (speed + 1) > 10 ? 0 : speed + 1;
            state = true;
            // Changed the speed succesfully
        } else {
            state = false;
            //com.api.Licuadora isnt full, couldnt change speed
        }
    }

    public int consultarVelocidad() {
        if (speed == 0) {
            state = false;
            return speed;
        } else {
            state = true;
            return speed;
        }
    }
}
