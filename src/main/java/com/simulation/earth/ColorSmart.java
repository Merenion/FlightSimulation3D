package com.simulation.earth;

import javafx.scene.paint.Color;

/**
 * Енам для удобной работы с цветами.
 * Так как ласс Color из пакета javafx закрыт для наследования
 * его неудобно использовать в GUI (там где надо выбирать цвет исходя из его названия).
 * Нельзя поместить в меню выбора цвета сам класс цвета и его название
 * Этот класс решает эту проблему, возвращая енам указывающий на класс цвета
 * и в тоже время отображая названия цвета.
 * Можно как получить цвет в виде енама (при помощи присвоеная Color color = ColorSmart.RED) так и переделать цвет в енам
 * припомощи метода matchingColor
 */
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
