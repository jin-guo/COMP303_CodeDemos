package ca.mcgill.cs.swdesign.m5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class   BrightnessFlashlightTest {
    BrightnessFlashlight f;

    static class CloudConfigStub implements CloudConfig {
        int aBrightConfig;

        CloudConfigStub(int pBrightConfig) {
            aBrightConfig = pBrightConfig;
        }

        @Override
        public int getBrightConfig() {
            return aBrightConfig;
        }
    }

    @BeforeEach
    void setUp() {
        f = new BrightnessFlashlight();
    }

    @Test
    void testBrightnessFromCloud(){
        CloudConfigStub cloudC = new CloudConfigStub(4);
        f.SetCloudConfig(cloudC);
        f.setBrightnessFromCloud();


        assertEquals(4, f.getBrightness());
    }

    @Test
    void testValidBrightness() {
        f.setBrightness(3);
        assertEquals(3, f.getBrightness());
    }

    @Test
    void testDefaultBrightness() {
        assertEquals(0, f.getBrightness());
    }


    @Test
    void testInvalidBrightness() {
        try {
            f.setBrightness(-1);
            fail();
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    public void testInvalidBrightnessAlt() {
        assertThrows(IllegalArgumentException.class, () -> f.setBrightness(420));
    }

    @Test
    void testPrivateIncrementBrightness() {
        Method incrementBrightness = null;
        try {
            incrementBrightness = f.getClass().getDeclaredMethod("incrementBrightness");
            incrementBrightness.setAccessible(true);

            incrementBrightness.invoke(f);
            assertEquals(1, f.getBrightness());

            incrementBrightness.invoke(f);
            assertEquals(2, f.getBrightness());

            f.setBrightness(5);
            incrementBrightness.invoke(f);
            assertEquals(0, f.getBrightness());

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
           fail();
        }
    }

}