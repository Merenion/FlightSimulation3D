package com.simulation.earth.spaceObjects;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс реализующий луну (для околоземного пространства)
 * Описание методов которые не задокументированы искать в родителях класса
 */
public class MoonNE extends PlanetOrStart {

    @Override
    public void prepareStartCootdints(double time) {
        prepareStartCootdints();
    }

    @Override
    public void prepareStartCootdints() {
        rotateX.setAngle(0);
        if (rotateFlyCircle!= null)
            rotateFlyCircle.setAngle(0);
    }

    /**
     * поворот для вращение вокруг центра, автоматически помещается в модель
     */
    private Rotate rotateFlyCircle = new Rotate(0,new Point3D(1,1,0));

    /*
    тут классы для повората автоматически помещаются в модель
    #rotateFlyCircle
     */
    {
        getSpaceModel().getTransforms().add(rotateFlyCircle);
    }

    /**время на которое уже совершенно перемещение #movement(double time)*/
    private double oldTime;

    /**
     * Математической модели НЕТУ ОРБИТЫ ПЕРЕМЕЩЕНИ НЕ будет,
     * перемещение реализованно при помощи поворота сферы вокруг центра координат
     * через delta time
     * (#rotateFlyCircle - через него она и вертится)
     */
    @Override
    public void movement(double time) {
        double deltaTime = time -oldTime;
        oldTime = time;
        rotateFlyCircle.setAngle(rotateFlyCircle.getAngle()-3* deltaTime /10);
        rotateX.setAngle(rotateX.getAngle()+4* deltaTime /10);
    }

    @Override
    protected List<Node> modelDescription() {
        Group group = new Group();
        List<Node> nodes = new ArrayList<>();
        Sphere sphere = new Sphere(radiusMoon);
        group.setTranslateZ(distanceOfEarthPerigey);
        sphere.setMaterial(prepareMaterial());
        nodes.add(group);
        group.getChildren().add(sphere);
        return nodes;
    }

    private PhongMaterial prepareMaterial() {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/moonTexture.jpg")));
        return phongMaterial;
    }

    @Override
    public float getRadiusPlanet() {
        return radiusMoon;
    }
}
