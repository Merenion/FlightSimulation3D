package com.simulation.earth.drawServis;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public interface LineServis {
    void addCoordinat (float x, float y, float z);
    void changeScaleTrajectory (float coefficient);
    Node getPath();
    Color getColor();
    void setColor(Color color);
    float getWidth();
    void setWidth(float width);
}
