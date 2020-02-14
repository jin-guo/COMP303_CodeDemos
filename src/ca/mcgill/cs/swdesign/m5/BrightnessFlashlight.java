package ca.mcgill.cs.swdesign.m5;

public class BrightnessFlashlight {
    private int brightness = 0;

    public void setBrightness(int pBrightness) {
        if (pBrightness < 0 || pBrightness > 5) {
            throw new IllegalArgumentException("Invalid brightness level");
        }
        this.brightness = pBrightness;
    }

    public int getBrightness() {
        return this.brightness;
    }

    private void incrementBrightness() {
        this.brightness = (this.brightness + 1) % 6;
    }
}
