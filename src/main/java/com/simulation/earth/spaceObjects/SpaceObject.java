package com.simulation.earth.spaceObjects;

import com.simulation.earth.objectControl.SmartGroup;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.Date;

public abstract class  SpaceObject {
    private double massa;
    private ArrayList<SpaceObject> objectsOfReferenceMovement = new ArrayList<>();
    private String name = "";
    private SmartGroup spaceGroup = new SmartGroup();
    private final Rotate rotateX = new Rotate(0,Rotate.X_AXIS);
    private final Rotate rotateY = new Rotate(0,Rotate.Y_AXIS);
    private final Rotate rotateZ = new Rotate(0,Rotate.Z_AXIS);
    private final Translate translate = new Translate();
    public SpaceObject(String name) {
        this.name = name;
    }

    {
        spaceGroup.getTransforms().addAll(rotateZ,rotateY,rotateX,translate);
    }

    SpaceObject(){
    }

    public abstract void prepareStartCootdints (Date data);
    public abstract void movement(float deltaTime) ;

    public Rotate getRotateY() {
        return rotateY;
    }

    public Rotate getRotateZ() {
        return rotateZ;
    }

    public Rotate getRotateX() {
        return rotateX;
    }

    public Translate getTranslate() {
        return translate;
    }

    public SmartGroup getSpaceGroup(){
        return spaceGroup;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SpaceObject> getObjectsOfReferenceMovement() {
        return objectsOfReferenceMovement;
    }

    @Override
    public String toString() {
        if (!name.equals("")) return name;
        else return "Object nameless";
    }

    protected abstract void prepareSpaceGroup ();
}
