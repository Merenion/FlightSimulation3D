package com.simulation.earth.manageSpace;

import javafx.scene.image.Image;

public class ParametersSpaceNearEarth extends ParametersSpace {
    @Override
    protected void prepareSpace() {
        nearClip = 1000;
        farClip = 180_000_000;
        fondImage = new Image(getClass().getResourceAsStream("/texturs/backgroundTexture.jpg"));
    }
}
