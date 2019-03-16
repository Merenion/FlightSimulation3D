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

    public Color getColor() {
        return color;
    }
}
