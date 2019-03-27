package com.simulation.earth;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.lang.model.SourceVersion;
import java.awt.*;

/**
 * Класс определяет разрешение экрана
 * и выдает созданную сцену с уже определенными размерами окна GUI
 */
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

    /**
     * Размер окна GUI
     * @param root которую необходимо запихнуть в Scene
     * @return сцена в которую уже заложены размеры окна
     */
    public static Scene getSceneWithSize (Parent root) {
        return new Scene(root,WIDTH-100,HIGHT-100);
    }
}
