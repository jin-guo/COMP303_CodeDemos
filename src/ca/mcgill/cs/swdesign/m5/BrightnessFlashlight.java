package ca.mcgill.cs.swdesign.m5;

import java.util.Optional;

public class BrightnessFlashlight {
    private int brightness = 0;
    private Optional<CloudConfig> config;

    BrightnessFlashlight() {
        config = Optional.empty();
    }

    public void setBrightness(int pBrightness) {
        if (pBrightness < 0 || pBrightness > 5) {
            throw new IllegalArgumentException("Invalid brightness level");
        }
        this.brightness = pBrightness;
    }

    public void SetCloudConfig(CloudConfig pConfig) {
        assert pConfig != null;
        config = Optional.of(pConfig);
    }

    public void setBrightnessFromCloud() {
        if (config.isPresent()) {
            setBrightness(config.get().getBrightConfig());
        }
    }


    public int getBrightness() {
        return this.brightness;
    }

    private void incrementBrightness() {
        this.brightness = (this.brightness + 1) % 6;
    }

}
