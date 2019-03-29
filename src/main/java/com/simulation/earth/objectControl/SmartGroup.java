package com.simulation.earth.objectControl;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public class SmartGroup extends Group {
    private Rotate rotate;                          //Создаем тут потому что так правильнее
    private Transform transform = new Rotate();     //Создаем тут один раз чтоб не где больше не создавать
    private String name = "";

    public void rotateByX (int angel){
        rotate = new Rotate(angel,Rotate.X_AXIS);
        transform = transform.createConcatenation(rotate);  //метод позволяет добавить к уже существующему повороту заданный и в строке мы переопределяем
        getTransforms().clear();
        getTransforms().add(transform);
    }

    public void rotateByY (int angel){
        rotate = new Rotate(angel,Rotate.Y_AXIS);
        transform = transform.createConcatenation(rotate);
        getTransforms().clear();
        getTransforms().add(transform);
    }

    public void rotateByZ (int angel){
        rotate = new Rotate(angel,Rotate.Z_AXIS);
        transform = transform.createConcatenation(rotate);
        getTransforms().clear();
        getTransforms().add(transform);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
