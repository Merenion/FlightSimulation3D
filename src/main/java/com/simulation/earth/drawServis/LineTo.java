package com.simulation.earth.drawServis;

import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * интерфейс для создания цепочки прямых
 */
public interface LineTo {
    void addCoordinats(float x, float y, float z);
    void changeScaleLines(float coefficient);
    Color getColor();
    void setColor(Color color);
    float getWidth();
    void setWidth(float width);
}
