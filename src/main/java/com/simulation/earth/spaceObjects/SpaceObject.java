package com.simulation.earth.spaceObjects;

import com.simulation.earth.trajectoryServis.DrawingOrbitOfSatellite;
import com.simulation.earth.trajectoryServis.DrawingTrajectory;
import com.simulation.earth.objectControl.SmartGroup;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.List;

public abstract class  SpaceObject {
    private double massa;
    private ArrayList<SpaceObject> objectsOfReferenceMovement = new ArrayList<>();
    private String name = "";
    private SmartGroup spaceModel = new SmartGroup();
    protected final Rotate rotateX = new Rotate(0,Rotate.X_AXIS);
    protected final Rotate rotateY = new Rotate(0,Rotate.Y_AXIS);
    protected final Rotate rotateZ = new Rotate(0,Rotate.Z_AXIS);
    protected final Translate orientation = new Translate();
    private DrawingTrajectory drawingOrbit;
    private float scaleModel =1;


    {
        spaceModel.getTransforms().add(orientation);
        spaceModel.getChildren().addAll(modelDescription());
        prepareRotate();
        prepareStartCootdints();
        if (name.equals(""))
            name=this.getClass().getSimpleName();
    }

    public void changeScaleModel (float scale){
        changeScaleModel(scale,spaceModel);
        scaleModel = scale;
    }

    public SpaceObject(String name) {
        this.name = name;
    }

    public SpaceObject() {
    }

    public abstract void prepareStartCootdints (double time);
    public abstract void prepareStartCootdints ();
    public abstract void movement(double time) ;
    protected abstract List<Node> modelDescription();


    public SmartGroup getSpaceModel(){
        return spaceModel;
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

    private void prepareRotate (){
        for (Node node: spaceModel.getChildren()){
            node.getTransforms().addAll(rotateX,rotateY,rotateZ);
        }
    }

    public Rotate getRotateX() {
        return rotateX;
    }
    public Rotate getRotateY() {
        return rotateY;
    }
    public Rotate getRotateZ() {
        return rotateZ;
    }

    public void enableDrawingOrbit (Group spaceGroup, Color colorOrbit, int maxLengthOrbit) {
        if (drawingOrbit!=null)
            drawingOrbit.removeTrajectory();
        drawingOrbit = new DrawingOrbitOfSatellite(spaceGroup,orientation,colorOrbit,maxLengthOrbit);
        drawingOrbit.startDrawTrajectories();
    }

    public void stopDrawingOrbit () {
        if (drawingOrbit != null) {
            drawingOrbit.stopDrawTrajectories();
        }
    }

    private void changeScaleModel (float scale, Group group){
        for (Node node: group.getChildren()){
            if (node instanceof Group) {
                changeScaleModel(scale, (Group) node);
            }else {
                node.setScaleX(scale);
                node.setScaleY(scale);
                node.setScaleZ(scale);
                node.setTranslateX(node.getTranslateX() / scaleModel * scale);
                node.setTranslateY(node.getTranslateY() / scaleModel * scale);
                node.setTranslateZ(node.getTranslateZ() / scaleModel * scale);
                for (Transform transform : node.getTransforms()) {
                    if (transform instanceof Translate) {
                        ((Translate) transform).setX(((Translate) transform).getX() / scaleModel * scale);
                        ((Translate) transform).setY(((Translate) transform).getY() / scaleModel * scale);
                        ((Translate) transform).setZ(((Translate) transform).getZ() / scaleModel * scale);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
