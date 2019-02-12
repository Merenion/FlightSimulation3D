package com.simulation.earth.objectControl;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class MouseControl {

    private double anchorX, anchorY;  //координаты в которых произошло зажатие мыши
    private double anchorAngleX =0;  //угол вращения относительно Х
    private double anchorAngleY =0;  //угол вращения относительно У
    private final DoubleProperty angleX = new SimpleDoubleProperty(0); //хз пока
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);

    public void initMouseControl(Node node, SubScene scene){
        Rotate xRotate;  //поворот  по оси Х
        Rotate yRotate;  //поворот  по оси У

        node.getTransforms().addAll(       //добавляем эти повороты, вдальнейшем можем менять значение
                xRotate = new Rotate(0,Rotate.X_AXIS),  //поворотов и вся групппа автоматом будет поворачиваться
                yRotate = new Rotate(0,Rotate.Y_AXIS)
        );
        xRotate.angleProperty().bind(angleX);   //эти две строчки привязывают изменение угла в обьекте rotate
        yRotate.angleProperty().bind(angleY);   //к переменным которые прописанны в этом классе - изменяя их изменится значение Rotate

        scene.setOnMousePressed(event -> { //действие при нажатой мыши, открываем поток
            anchorX = event.getSceneX(); //фиксируем координаты в которых зажата клавиша
            anchorY = event.getSceneY();
            anchorAngleX = angleX.get(); //фиксируем тот угол в котором находится деталь относительно осей
            anchorAngleY = angleY.get(); //тоесть просто берем угол который был до перемещения на новые координаты
        });

        scene.setOnMouseDragged(event -> {
            angleX.set(anchorAngleX - (anchorY - event.getSceneY())); //определяем через координаты мыши
            angleY.set(anchorAngleY + (anchorX - event.getSceneX())); //угол на который должна переместиться деталь
        });
    }

    public void initScrollControl (Node node, Stage stage,double mnoziteli){
        stage.addEventHandler(ScrollEvent.SCROLL, event -> {    //обработчик событий
            double delta = event.getDeltaY();                   //делта приближения колесика
            node.translateZProperty().set(node.getTranslateZ()+delta*mnoziteli); //устанавливаем значение при прокрутке
        });
    }
}
