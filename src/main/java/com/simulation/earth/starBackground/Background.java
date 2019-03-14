package com.simulation.earth.starBackground;

import javafx.scene.Group;
import javafx.scene.Node;

import java.util.ArrayList;

public abstract class Background {

    private String pathTexture = "/texturs/starsBackground/starBackground.jpg";
    private float scale = 0;

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
        group.setScaleX(scale);
        group.setScaleY(scale);
        group.setScaleZ(scale);
    }

    public String getPathTexture() {
        return pathTexture;
    }

    public void setPathTexture(String pathTexture) {
        this.pathTexture = pathTexture;
    }

    private Group group = new Group();
    {
        group.getChildren().addAll(prepareBackground());
    }
    abstract ArrayList<Node> prepareBackground ();

    public Group getGroup() {
        return group;
    }
}
