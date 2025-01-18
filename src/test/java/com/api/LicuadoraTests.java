/*
 * Hoja de trabajo 1
 * Fecha: 17 / 01 / 2025
 * Grupo: 3
 * */

package com.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LicuadoraTests {

    private Licuadora licuadora;

    @BeforeEach
    void setUp() {
        licuadora = new Licuadora();
    }

    @Test
    void testAddElementIncrementsCurrentElements() {
        licuadora.llenar();
        licuadora.llenar();
        assertFalse(licuadora.consultarLlenado());

        licuadora.llenar();
        licuadora.llenar();
        licuadora.llenar();
        assertTrue(licuadora.consultarLlenado());
    }

    @Test
    void testChangeSpeedWhenFull() {
        for (int i = 0; i < 6; i++) {
            licuadora.llenar();
        }

        assertTrue(licuadora.consultarLlenado());
        licuadora.aumentarVelocidad();
        assertEquals(1, licuadora.consultarVelocidad());
    }

    @Test
    void testChangeSpeedWhenNotFull() {
        licuadora.llenar();
        assertFalse(licuadora.consultarLlenado());
        licuadora.aumentarVelocidad();
        assertEquals(0, licuadora.consultarVelocidad());
    }

    @Test
    void testSpeedWrapsAroundWhenIncreasing() {
        for (int i = 0; i < 6; i++) {
            licuadora.llenar();
        }

        for (int i = 0; i < 10; i++) {
            licuadora.aumentarVelocidad();
        }

        assertEquals(10, licuadora.consultarVelocidad());
        licuadora.aumentarVelocidad();
        assertEquals(0, licuadora.consultarVelocidad());
    }

    @Test
    void testCheckSpeedUpdatesState() {
        assertEquals(0, licuadora.consultarVelocidad());
        assertFalse(licuadora.state);

        for (int i = 0; i < 6; i++) {
            licuadora.llenar();
        }
        licuadora.aumentarVelocidad();
        assertTrue(licuadora.state);
    }
}
