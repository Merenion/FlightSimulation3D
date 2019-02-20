package com.simulation.earth;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.lang.model.SourceVersion;
import java.awt.*;

public class ScreenResolution {

    private static Dimension displaySize;
    private static double HIGHT;
    private static double WIDTH;

    static {
        displaySize = Toolkit.getDefaultToolkit ().getScreenSize ();
        HIGHT = displaySize.getHeight();
        WIDTH = displaySize.getWidth();
    }

    public static Dimension getDisplaySize() {
        return displaySize;
    }

    public static double HIGHT() {
        return HIGHT;
    }

    public static double WIDTH() {
        return WIDTH;
    }

    public static Scene getSceneWithSize (Parent root) {
        return new Scene(root,WIDTH-100,HIGHT-100);
    }
}
