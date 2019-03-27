package com.simulation.earth.spaceObjects;

import com.simulation.earth.spaceObjects.PlanetOrStart;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс реализующий землю (для околоземного пространства)
 * Описание методов которые не задокументированы искать в родителях класса
 */
public class EarthNE extends PlanetOrStart {

    @Override
    public void prepareStartCootdints(double time) {
        prepareStartCootdints();
    }

    @Override
    public void prepareStartCootdints() {
        rotateY.setAngle(-90);
    }


    /**время на которое уже совершенно перемещение #movement(double time)*/
    private float oldTime;
    /**
     * Математической модели НЕТУ ОРБИТЫ ПЕРЕМЕЩЕНИ НЕ будет,
     * перемещение реализованно при помощи поворота сферы вокруг центра координат
     * через delta time
     */
    @Override
    public void movement(double time) {
        float deltaTime = (float) (time -oldTime);
        oldTime = (float) time;
        rotateY.setAngle(rotateY.getAngle()+1* deltaTime /(rotationalSpeedEarth/360));
    }
    @Override
    public List<Node> modelDescription() {
        Group group = new Group();
        List<Node> nodes = new ArrayList<>();
        Sphere sphere = new Sphere(radiusEarth);
        sphere.setMaterial(prepareMaterial());
        group.getChildren().add(sphere);
        nodes.add(group);
        return nodes;
    }

    private PhongMaterial prepareMaterial () {
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/texturs/earthTexture.jpg")));
        phongMaterial.setSpecularMap(new Image(getClass().getResourceAsStream("/texturs/earthMapReflection.jpg")));
        return phongMaterial;
    }

    @Override
    public float getRadiusPlanet() {
        return radiusEarth;
    }
}
