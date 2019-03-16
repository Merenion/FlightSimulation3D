package com.simulation.earth;

import javafx.scene.paint.Color;

public enum ColorOrbit {
    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    WHITE(Color.WHITE),
    SKYBLUE(Color.SKYBLUE),
    PINK(Color.PINK),
    YELLOW(Color.YELLOW);

    ColorOrbit(Color color) {
        this.color = color;
    }

    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public static ColorOrbit matchingColor (Color color) {
        for (ColorOrbit colorOrbit:ColorOrbit.values()) {
            if (color.equals(colorOrbit.getColor()))
                return colorOrbit;
        }
        return ColorOrbit.WHITE;
    }
}
