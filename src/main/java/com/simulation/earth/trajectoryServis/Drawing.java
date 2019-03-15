package com.simulation.earth.trajectoryServis;

import com.simulation.earth.drawServis.LineToManager;
import javafx.scene.Group;

public interface Drawing {
    void addLineInPathIfNeeded (float newX, float newY, float newZ);
    Group getPath();
    boolean isNeededDraw(float newX, float newY, float newZ);
    void setDistanceDrawLine(double distanceDrawLine);
    LineToManager getLineToManager();
    void clear ();
    void setMaxNumberLine(int maxNumberLine);
    int getMaxNumberLine();
    boolean isLimitTerms();
    void setLimitTerms(boolean limitTerms);
}
