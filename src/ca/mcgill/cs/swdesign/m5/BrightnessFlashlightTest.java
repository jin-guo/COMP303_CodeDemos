package ca.mcgill.cs.swdesign.m5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class BrightnessFlashlightTest {
    BrightnessFlashlight f;

    @BeforeEach
    void setUp() {
        f = new BrightnessFlashlight();
    }

    @Test
    void setBrightness() {
        assertEquals(f.getBrightness(), 0);
        f.setBrightness(3);
        assertEquals(f.getBrightness(), 3);
    }

    @Test
    void setInvalidBrightness() {
        assertEquals(f.getBrightness(), 0);
        try {
            f.setBrightness(100);
            fail();
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    public void setInvalidBrightnessAlt() {
        assertThrows(IllegalArgumentException.class, () -> f.setBrightness(420));
    }

    @Test
    void incrementBrightness() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = f.getClass();

        Method incrementBrightness = c.getDeclaredMethod("incrementBrightness");
        incrementBrightness.setAccessible(true);
        incrementBrightness.invoke(f);

        assertEquals(f.getBrightness(), 1);

        incrementBrightness.invoke(f);
        assertEquals(f.getBrightness(), 2);
    }
}