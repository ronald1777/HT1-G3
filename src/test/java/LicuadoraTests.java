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
        licuadora.addElement();
        licuadora.addElement();
        assertFalse(licuadora.isFull());

        licuadora.addElement();
        licuadora.addElement();
        licuadora.addElement();
        assertTrue(licuadora.isFull());
    }

    @Test
    void testChangeSpeedWhenFull() {
        for (int i = 0; i < 6; i++) {
            licuadora.addElement();
        }

        assertTrue(licuadora.isFull());
        assertTrue(licuadora.changeSpeed(true));
        assertEquals(1, licuadora.checkSpeed());

        assertTrue(licuadora.changeSpeed(false));
        assertEquals(0, licuadora.checkSpeed());
    }

    @Test
    void testChangeSpeedWhenNotFull() {
        licuadora.addElement();
        assertFalse(licuadora.isFull());
        assertFalse(licuadora.changeSpeed(true));
        assertEquals(0, licuadora.checkSpeed());
    }

    @Test
    void testSpeedWrapsAroundWhenIncreasing() {
        for (int i = 0; i < 6; i++) {
            licuadora.addElement();
        }

        for (int i = 0; i < 10; i++) {
            licuadora.changeSpeed(true);
        }

        assertEquals(10, licuadora.checkSpeed());
        licuadora.changeSpeed(true);
        assertEquals(0, licuadora.checkSpeed());
    }

    @Test
    void testSpeedDoesNotGoBelowZero() {
        for (int i = 0; i < 6; i++) {
            licuadora.addElement();
        }

        licuadora.changeSpeed(false);
        assertEquals(0, licuadora.checkSpeed());
    }

    @Test
    void testCheckSpeedUpdatesState() {
        assertEquals(0, licuadora.checkSpeed());
        assertFalse(licuadora.state);

        for (int i = 0; i < 6; i++) {
            licuadora.addElement();
        }
        licuadora.changeSpeed(true);
        assertTrue(licuadora.state);
    }
}
