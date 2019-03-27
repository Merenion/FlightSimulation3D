package com.simulation.earth.spaceObjects;

import com.simulation.earth.PerspectiveCameraWithName;
import javafx.scene.Camera;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * класс для описания и работы с космическими обьектами имеющими камеру
 */
public abstract class SpaceObjectWithCamera extends SpaceObject{

    /**хранилище всех камер*/
    private ArrayList<Camera> cameras = new ArrayList<>();

    /*
    инициализирует содержимое списка имеющихся камер
    с помощью использования абстрактного метода для описания камер
    #prepareCameras
    так же запихивает в них rotates для поворота вместе с
    моделью объекта, помещает их группу модели #spaceModel
     */
    {
        cameras.addAll(prepareCameras());
        for (Camera camera: cameras) {
            Group group = new Group();
            group.getChildren().add(camera);
            group.getTransforms().addAll(rotateX, rotateY, rotateZ);
            getSpaceModel().getChildren().add(group);
        }
    }

    /**
     * Реализация данного мтеода подразумевает инициалиацию
     * всех необходимых (уже размещенных) камер для обьекта
     * Все они попадают в группу модели обьекта #spaceModel
     * и работаю как простая составляющая модели
     * @return список камер
     */
    protected abstract List<Camera> prepareCameras ();

    /**
     * Возвращает необходимую камеру по ее наименнованию
     * @param name наименнование камеры
     * @return камера
     */
    public Camera getCamera (String name) {
        for (Camera camera : cameras){
            if (camera.toString().equals(name))
                return camera;
        }
        return null;
    }

    public ArrayList<Camera> getCameras () {
        return cameras;
    }

    /**
     * переопределение задания наименнование космического обьекта
     * для того чтобы обновить информацию о обьекте имеющуюся у камер
     * Все это для того чтобы от камеры можно было узнать
     * наименнование обьекта к которому она относится и переопределить у нее toString
     * с этим учетом
     * @param name наименнование обьекта которое следует задать
     */
    @Override
    public void setName(String name) {
        super.setName(name);
        for (Camera camera : cameras){
            if (camera instanceof PerspectiveCameraWithName)
                ((PerspectiveCameraWithName) camera).setNameSpaceObject(getName());
        }
    }
}
