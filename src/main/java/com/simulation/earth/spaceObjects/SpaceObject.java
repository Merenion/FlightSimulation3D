package com.simulation.earth.spaceObjects;

import com.simulation.earth.trajectoryServis.DrawingOrbitOfSatellite;
import com.simulation.earth.trajectoryServis.DrawingPath;
import com.simulation.earth.objectControl.SmartGroup;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс космического обьекта - описывает его передвижение, модель
 * физические параметры, дополнительное поведение
 */
public abstract class  SpaceObject {

    /**Масса космического обьекта (пока не где не используется)*/
    private double massa;
    /**коллекция обьектов позволяющих перемещаться относительно их месторасположения (сейчас не где не используется)*/
    private ArrayList<SpaceObject> objectsOfReferenceMovement = new ArrayList<>();
    /**наименнование космического обьекта*/
    private SimpleStringProperty name = new SimpleStringProperty("rfrfr");
    /**Группа содержащая представляющая модель космического обьекта*/
    protected Group spaceModel = new Group();
    /**Поворот модели Космического обьекта относительно собственной оси X*/
    protected final Rotate rotateX = new Rotate(0,Rotate.X_AXIS);
    /**Поворот модели Космического обьекта относительно собственной оси Y*/
    protected final Rotate rotateY = new Rotate(0,Rotate.Y_AXIS);
    /**Поворот модели Космического обьекта относительно собственной оси Z*/
    protected final Rotate rotateZ = new Rotate(0,Rotate.Z_AXIS);
    /**поле для изменения расположения космического обьекта относительно основной системы координат*/
    protected final Translate orientation = new Translate();
    /**масштаб модели*/
    protected float scaleModel =1;

    /**поле для рисования орбиты или Пути перемещения*/
    private DrawingPath drawingOrbit;
    /**цвет орбиты или питу передвижения объкта*/
    private Color colorOrbit = Color.WHITE;
    /**максимальная дляна нарисованного пути или орбиты*/
    private int maxLengthOrbit = 175;

    /**
     * Простой конструктор с заданием наименование космического обьекта
     * @param name наименование
     */
    public SpaceObject(String name) {
        this.name.setValue(name);
    }

    /**
     * пустой конструктор
     */
    public SpaceObject() {
    }

    /*
    инициализация #orientation для модели
    и добавление инициализируемой модели в
    #spaceGroup. Модель инициализируется абстрактным
    методом #modelDescription().
    Установка модели на стартовые координаты
    абстрактным методом #prepareStartCootdints()
     */
    {
        spaceModel.getTransforms().add(orientation);
        spaceModel.getChildren().addAll(modelDescription());
        prepareRotate();
        prepareStartCootdints();
        if (name.getValue().equals(""));
            name.setValue(this.getClass().getSimpleName());
    }

    /**
     * метод для изменения масштаба модели космического обьекта
     * @param scale необходимый масштаб модели
     */
    public void changeScaleModel (float scale){
        changeScaleModel(scale,spaceModel);
        scaleModel = scale;
    }

    /**
     * перемещает обьект на координаты соответствующие заданному времени
     * @param time время от которого зависит расположение обьекта
     */
    public abstract void prepareStartCootdints (double time);

    /**
     * перемещает обьект на стартовые координаты по дефолту
     * Реализацию метода необходимо проводить строго в рамках метода или
     * с использованием полей SpaceObject
     * Другими словами не задействуя поля класса в котором реализован
     * данный метод так как он вызывается при инициализации в его родителе.
     * (ИБО инициализаци происходит с родителя (если что))
     * Так же можно обработать NullPointException для другого подхода
     * после инициализации класса
     */
    public abstract void prepareStartCootdints ();

    /**
     * метод в котором описывается перемещение
     * нвся математика с использованием поля #orientation
     * и углов повората используется в нем.
     * как правило в нем подкрепляются математические модели и прочее
     * Метод вызывается при симуляции космического пространства
     * @param time время симуляции
     */
    public abstract void movement(double time) ;

    /**
     * В этом методе создается сама модель обьекта
     * или ее составляющие которые возвращаются в виде
     * коллекции и используются постоянно в течении использования обьекта
     * в группе #spaceModel которая их объединяет
     * @return лист составляющих модели космического обьекта
     */
    protected abstract List<Node> modelDescription();


    /**
     * подготавливает поля Rotate по всем осям
     * (#rotateX  #rotateY  #rotateZ)
     * помещая их в составляющие модели #spaceModel
     */
    private void prepareRotate (){
        for (Node node: spaceModel.getChildren()){
            node.getTransforms().addAll(rotateX,rotateY,rotateZ);
        }
    }

    /**
     * Включает прорисовку Орбиты или пути перемещения космического объекта.
     * Удаляет весь нарисованный путь до вызова метода
     * @param spaceGroup группа где будет храниться прорисованный путь
     */
    public void enableDrawingMovementPath(Group spaceGroup) {
        if (drawingOrbit!=null)
            drawingOrbit.removeTrajectory();
        drawingOrbit = new DrawingOrbitOfSatellite(spaceGroup,orientation,colorOrbit,maxLengthOrbit);
        drawingOrbit.startDrawTrajectories();
    }

    /**
     * Останавливает прорисовку Орбиты или пути перемещения космического объекта
     */
    public void stopDrawingMovementPath() {
        if (drawingOrbit != null) {
            drawingOrbit.stopDrawTrajectories();
        }
    }

    /**
     * метод для изменения масштаба обьектов группы (расположени группы относительно
     * родительской системы координат не менется)
     * @param scale необходимый масштаб
     * @param group группа составляющие которой необходимо изменить.
     */
    protected void changeScaleModel (float scale, Group group){
        changeScaleModel(scale,group,null);
    }

    /**
     * метод для изменения масштаба обьектов группы (расположени группы относительно
     * родительской системы координат не менется)
     * @param scale необходимый масштаб
     * @param group группа составляющие которой необходимо изменить.
     * @param groupNonChange группа которую не измменять
     */
    protected void changeScaleModel (float scale, Group group,Group groupNonChange){
        for (Node node: group.getChildren()){
            if (node instanceof Group && !((Group) node).equals(groupNonChange)) {
                break;
            }
                if (node instanceof Group) {
                    changeScaleModel(scale, (Group) node);
                } else {
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

    /**
     * удаляет весь нарисованный путь движения обьект
     */
    public void refreshDrawingMovementPath() {
        if (drawingOrbit!=null)
        drawingOrbit.removeTrajectory();
    }

    @Override
    public String toString() {
        return name.getValue();
    }

    public Group getSpaceModel(){
        return spaceModel;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public Color getColorOrbit() {
        return colorOrbit;
    }

    public void setColorOrbit(Color colorOrbit) {
        this.colorOrbit = colorOrbit;
    }

    public int getMaxLengthOrbit() {
        return maxLengthOrbit;
    }

    public void setMaxLengthOrbit(int maxLengthOrbit) {
        this.maxLengthOrbit = maxLengthOrbit;
    }

    public DrawingPath getDrawingOrbit() {
        return drawingOrbit;
    }

    public ArrayList<SpaceObject> getObjectsOfReferenceMovement() {
        return objectsOfReferenceMovement;
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
}
