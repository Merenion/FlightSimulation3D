package com.simulation.earth.trajectoryServis;

import com.simulation.earth.drawServis.LineTo3D;
import javafx.scene.Group;

/**
 * интерфейс позволяющий работать с сервисом рисования
 */
public interface Drawing {
    void addLineInPathIfNeeded (float newX, float newY, float newZ);
    Group getPath();
    boolean isNeededDraw(float newX, float newY, float newZ);
    void setDistanceDrawLine(double distanceDrawLine);
    LineTo3D getLineTo3D();
    void clear ();
    void setMaxNumberLine(int maxNumberLine);
    int getMaxNumberLine();
    boolean isLimitTerms();
    void setLimitTerms(boolean limitTerms);
}
