package com.simulation.earth.spaceObjects;

import com.simulation.earth.MathModel.IMathModel;
import com.simulation.earth.MathModel.ImplMathModel;
import com.simulation.earth.pathServis.ManagerDrawPath;
import com.simulation.earth.pathServis.ServisDrawTrajectory;
import com.simulation.earth.objectControl.SmartGroup;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.Date;
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
    private boolean drawPath = false;
    protected ServisDrawTrajectory servisDrawTrajectory;
    IMathModel mathModel = new ImplMathModel();
    private float scaleModel =1;


    public void changeScaleModel (float scale){
        changeScaleModel(scale,spaceModel);
        scaleModel = scale;
    }

    {
        spaceModel.getTransforms().add(orientation);
        spaceModel.getChildren().addAll(modelDescription());
        prepareRotate();
        prepareStartCootdints();
        servisDrawTrajectory = new ManagerDrawPath((float) orientation.getX(),(float) orientation.getY(),(float) orientation.getZ());
        if (name.equals(""))
            name=this.getClass().getSimpleName();
    }

    public Group getTrajectory () {
        return servisDrawTrajectory.getPath();
    }

    public SpaceObject(String name) {
        this.name = name;
    }

    public SpaceObject() {
    }

    public abstract void prepareStartCootdints (Date data);
    public abstract void prepareStartCootdints ();
    public abstract void movement(float deltaTime) ;
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

    public boolean isDrawPath() {
        return drawPath;
    }

    public void setDrawPath(boolean drawPath) {
        this.drawPath = drawPath;
    }

    public ArrayList<SpaceObject> getObjectsOfReferenceMovement() {
        return objectsOfReferenceMovement;
    }

    @Override
    public String toString() {
        return name;
    }

    private void prepareRotate (){
        for (Node node: spaceModel.getChildren()){
            node.getTransforms().addAll(rotateX,rotateY,rotateZ);
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
}
