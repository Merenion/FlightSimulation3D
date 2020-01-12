package com.simulation.earth.spaceObjects;

import com.simulation.earth.ControllerWindowSimulation;
import com.simulation.earth.MathModels.MathModelOper;
import com.simulation.earth.MathModels.MathModelPeriod;
import com.simulation.earth.manageSatellite.CaParameters;
import com.simulation.earth.manageSatellite.OrbitParameters;
import javafx.scene.Group;
import javafx.scene.Node;

/**
 * реализация космического обьекта- спутника с парамметрами СА
 */
public class SatelliteWithParametersCA extends SatelliteDefault {

    CaParameters caParameters;

    MathModelPeriod mathModelPeriod;
    MathModelOper mathModelOper;

    Group konus;

    public SatelliteWithParametersCA(OrbitParameters parametrsOrbit, CaParameters caParameters) {
        super(parametrsOrbit);
        this.caParameters = caParameters;
        mathModelPeriod = new MathModelPeriod(parametrsOrbit, caParameters);
        mathModelOper = new MathModelOper(parametrsOrbit);
    }

    @Override
    public void movement(double time) {
        super.movement(time);
        mathModelPeriod.calculationPeriodichn(time, ControllerWindowSimulation.getControllerWindowSimulation().getSimulation().getDeltaTime());
        if (konus!=null && mathModelPeriod.isChangeTenMin()) {
            for (Node node : konus.getChildren()){
                if (node instanceof Cone){
                    Cone cone = (Cone) node;
                    cone.update(mathModel.flightAltitude(time,0)+2000,caParameters.maksUgolKAotNadira);
                }
            }
        }
    }

    @Override
    public void prepareStartCootdints(double time) {
        super.prepareStartCootdints(time);
        mathModelPeriod = new MathModelPeriod(parametrsOrbit, caParameters);
    }

    public CaParameters getCaParameters() {
        return caParameters;
    }

    public void setCaParameters(CaParameters caParameters) {
        this.caParameters = caParameters;
    }

    public MathModelPeriod getMathModelPeriod() {
        return mathModelPeriod;
    }

    public void setMathModelPeriod(MathModelPeriod mathModelPeriod) {
        this.mathModelPeriod = mathModelPeriod;
    }

    @Override
    public void changeScaleModel(float scale) {
        changeScaleModel(scale, spaceModel, konus);
        if (konus != null) {
            konus.setTranslateX(konus.getTranslateX() / scaleModel * scale);
        }
        scaleModel = scale;
    }

//    @Override
//    protected List<Node> modelDescription() {
//        initKonus();
//        List<Node> models = new ArrayList<>();
//        models.add(konus);
//        models.addAll(super.modelDescription());
//        return models;
//    }

    private void initKonus() {
        if (spaceModel.getChildren().contains(konus)) {
            spaceModel.getChildren().remove(konus);
        }
        konus = new Group();
        konus.setTranslateX(0);
        konus.setVisible(false);
//        konus.getChildren().add(new Cone(400, 0, 1200));
        konus.getChildren().add(new Cone(mathModel.flightAltitude(1,0)+2000,caParameters.maksUgolKAotNadira));
        konus.getTransforms().addAll(rotateX, rotateY, rotateZ);
        spaceModel.getChildren().add(konus);
    }

    public void setVisibleZonaObzora(boolean value) {
        initKonus();
        konus.setVisible(value);
        if (!value){
            konus=null;
        }
    }

    @Override
    public void changeParam(Object o) {
        super.changeParam(o);
        spaceModel.getChildren().remove(konus);
        initKonus();
    }

    public MathModelOper getMathModelOper() {
        return mathModelOper;
    }
}