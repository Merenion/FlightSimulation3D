package com.simulation.earth;

import javafx.scene.paint.Color;

public enum ColorSmart {
    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    WHITE(Color.WHITE),
    SKYBLUE(Color.SKYBLUE),
    PINK(Color.PINK),
    YELLOW(Color.YELLOW);

    ColorSmart(Color color) {
        this.color = color;
    }

    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public static ColorSmart matchingColor (Color color) {
        for (ColorSmart colorSmart : ColorSmart.values()) {
            if (color.equals(colorSmart.getColor()))
                return colorSmart;
        }
        return ColorSmart.WHITE;
    }
}
