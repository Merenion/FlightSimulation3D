package com.simulation.earth.manageSpace;

import com.simulation.earth.spaceObjects.SpaceObjectWithCamera;
import com.simulation.earth.spaceObjects.SpaceObject;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Camera;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный класс описывающий пространство, хранит все обьекты (SpaceObject),
 * которые необходимо отображать в приложении.
 * Имеется абстрактный метод для сазадия обьектов по дефолту.
 * Реализация представляет с собой две колекции, одна из которых
 * хранит обьекты пространства (@See #SpaceObject) и их модели, которые
 * добавляются и удаляются вместе с обьктами пространства автоматически.
 */
public abstract class Space {

    /**Коллекция которая хранит в себе обьекты пространства*/
    private ObservableList<SpaceObject> spaceObjects = FXCollections.observableArrayList();
    /**Группа которая хранит в себе модели обьектов пространства*/
    private Group spaseGroup = new Group();
    /**Наименование пространства*/
    private String name = "";
    /**Коллекция хранит все камеры установленные в обьекты пространства типа SpaceObjectWithCamera*/
    private ObservableList<Camera> cameras = FXCollections.observableArrayList();

    /*
      Создает слушатель который автоматически изменяет группу при редактировании
      коллекции обьектов пространства @See #spaceObjects
     */
    {
        spaceObjects.addListener((ListChangeListener<SpaceObject>) c -> {
            c.next();
            if (c.wasRemoved()){
                List<? extends SpaceObject> objecrsRemoved = c.getRemoved();
                for (SpaceObject object : objecrsRemoved)
                    spaseGroup.getChildren().remove(object.getSpaceModel());
            }
            if (c.wasAdded()) {
                List<? extends SpaceObject> objectsAdded = c.getAddedSubList();
                for (SpaceObject object : objectsAdded)
                    spaseGroup.getChildren().add(object.getSpaceModel());
            }
            refreshCameras();
        });
    }

    /*
      Автоматически добавляет стандартные обьекты в коллекцию обьктов пространства
      при инициализации.
      Использует абстрактный метод реализуемый в наследниках
     */
    {
        spaceObjects.addAll(prepareSpace());
    }

    /**
     * Метод для определения обьктов пространства, необходимые по умолчанию в @see #spaceObjects
     * @return
     */
    protected abstract ArrayList<SpaceObject> prepareSpace ();

    /**
     * Позволяет достать определенный обьект пространства
     * @param name наименование спутника
     * @return искомый спутник
     */
    public SpaceObject getSpaceObject (String name) {
        for (SpaceObject object: spaceObjects){
            if (object.getName().equals(name))
                return object;
        }
        return null;
    }

    public Group getSpaceGroup () {
        return spaseGroup;
    }

    public ObservableList<SpaceObject> getSpaceObjects() {
        return spaceObjects;
    }

    /**
     * Возвращает или подготавливает все обьекты пространства к исходному положению
     * для заданного времени
     * @param time время необходимого положения
     */
    public void prepareStartCoordinatForObjects (double time) {
        for (SpaceObject object : spaceObjects)
            object.prepareStartCootdints(time);
    }

    /**
     * Метод движения обьектов. Перемещение относительно времени.
     * @param deltaTime время через которое происходит перемещение
     */
    public void movementObjects(double deltaTime) {
        for (SpaceObject object : spaceObjects)
            object.movement(deltaTime);
    }

    /**
     * Возвращает все имеющиеся камеры от SpaceObjectWithCamera
     * @return камеры
     */
    public ObservableList<Camera> getCamerasFromSpaseObjects() {
        return cameras;
    }

    /**
     * Заного собирает все камеры с обьектов пространства и пепезаполняет коллекцию @link #cameras
     */
    private void refreshCameras () {
        cameras.clear();
        for (SpaceObject object : spaceObjects) {
            if (object instanceof SpaceObjectWithCamera)
                cameras.addAll(((SpaceObjectWithCamera) object).getCameras());
        }
    }

    /***
     * Возвращает наименование пространства
     * @return name
     */
    @Override
    public String toString() {
        if (!name.equals(""))
            return name;
        else return "Space nameless";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
