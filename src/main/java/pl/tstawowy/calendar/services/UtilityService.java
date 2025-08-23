package pl.tstawowy.calendar.services;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {
    
    Random rand = new Random();

    public static String generateColor(Object object) {

        int hash = (object == null ? 0 : object.hashCode());

        // Hue: full range 0–360
        float hue = (hash & 0xFFFFFF) / (float) 0xFFFFFF;

        // Saturation: keep it between 0.6–0.9 for vivid but not neon
        float saturation = 0.7f;

        // Brightness: keep it between 0.5–0.8 for readability
        float brightness = 0.6f;

        // Convert HSB to RGB
        int rgb = hsbToRgb(hue, saturation, brightness);

        // Return as hex string (#RRGGBB)
        return String.format("%06X", rgb);
    }

    private static int hsbToRgb(float hue, float saturation, float brightness) {
        int r = 0, g = 0, b = 0;

        if (saturation == 0) {
            r = g = b = (int)(brightness * 255.0f + 0.5f);
        } else {
            float h = (hue * 6.0f);
            int i = (int)Math.floor(h);
            float f = h - i;
            float p = brightness * (1.0f - saturation);
            float q = brightness * (1.0f - saturation * f);
            float t = brightness * (1.0f - (saturation * (1.0f - f)));

            switch (i) {
                case 0: r = (int)(brightness * 255.0f + 0.5f);
                        g = (int)(t * 255.0f + 0.5f);
                        b = (int)(p * 255.0f + 0.5f);
                        break;
                case 1: r = (int)(q * 255.0f + 0.5f);
                        g = (int)(brightness * 255.0f + 0.5f);
                        b = (int)(p * 255.0f + 0.5f);
                        break;
                case 2: r = (int)(p * 255.0f + 0.5f);
                        g = (int)(brightness * 255.0f + 0.5f);
                        b = (int)(t * 255.0f + 0.5f);
                        break;
                case 3: r = (int)(p * 255.0f + 0.5f);
                        g = (int)(q * 255.0f + 0.5f);
                        b = (int)(brightness * 255.0f + 0.5f);
                        break;
                case 4: r = (int)(t * 255.0f + 0.5f);
                        g = (int)(p * 255.0f + 0.5f);
                        b = (int)(brightness * 255.0f + 0.5f);
                        break;
                case 5: r = (int)(brightness * 255.0f + 0.5f);
                        g = (int)(p * 255.0f + 0.5f);
                        b = (int)(q * 255.0f + 0.5f);
                        break;
            }
        }
        return (r << 16) | (g << 8) | b;
    }
}
