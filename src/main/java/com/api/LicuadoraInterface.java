/*
 * Hoja de trabajo 1
 * Fecha: 17 / 01 / 2025
 * Grupo: 3
 * */

package com.api;

public interface LicuadoraInterface {
    public void encender();
    public void vaciar();
    public void llenar();
    public boolean consultarLlenado();
    public void aumentarVelocidad ();
    public int consultarVelocidad();
}