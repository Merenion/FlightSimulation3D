package com.simulation.earth;

import com.simulation.earth.spaceObjects.SatelliteWithParametersCA;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class ControllerGraffikPeriod {
    public BarChart<String, Number> grRaspPer;
    public CategoryAxis xFRPe;
    public NumberAxis yFRP;
    public BarChart<String, Number> grPlotnRasprPer;
    public CategoryAxis xFPRPe;
    public NumberAxis yFPRP;
    public Label colZasnOb;
    public Label tekushcZnachPer;
    public Label srednZnachPer;
    public Label maxPer;
    public Label minPer;
    public Label srednKvadrOtklon;
    public Label lableTimeInMin2;
    public Label lableTimeInMin21;

    private SatelliteWithParametersCA satellite;

    private static ControllerGraffikPeriod controllerGraffikPeriod;

    public static ControllerGraffikPeriod getControllerGraffikPeriod() {
        return controllerGraffikPeriod;
    }

    public static void setControllerGraffikPeriod(ControllerGraffikPeriod controllerGraffikPeriod) {
        ControllerGraffikPeriod.controllerGraffikPeriod = controllerGraffikPeriod;
    }

    @FXML
    private void initialize() {
        controllerGraffikPeriod = this;

    }

    AnimationTimer threadMonitorPeriodichn;

    public void runDraw(SatelliteWithParametersCA satellite) {
        this.satellite = satellite;
        threadMonitorPeriodichn = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (satellite.getMathModelPeriod().isChangeMin()) {
                    initFRP();
                    initFPRP();
                    initVariable();
                }
            }
        };
        threadMonitorPeriodichn.start();
    }

    public void stopDraw() {
        if (threadMonitorPeriodichn != null) {
            threadMonitorPeriodichn.stop();
        }
    }

    private void initFRP() {
        if (satellite.getMathModelPeriod().isChangeDay() && satellite.getMathModelPeriod().getMassiv_t_Per().size()!=0) {
            XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
            List<Double> xElements = satellite.getMathModelPeriod().getMassiv_t_Per();
            List<Double> yElements = new ArrayList<>(satellite.getMathModelPeriod().getF_Per());

            if (xElements.size() == yElements.size() && xElements.size() != 0) {
                for (int i = 0; i < yElements.size(); i++) {
                    data.getData().add((new XYChart.Data<String, Number>(String.valueOf(xElements.get(i)), yElements.get(i))));
                }
                grRaspPer.getData().clear();
                grRaspPer.getData().add(data);
            }
        }
    }

    private void initFPRP() {
        if (satellite.getMathModelPeriod().isChangeDay() && satellite.getMathModelPeriod().getMassiv_t_Per().size()>30) {
            XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
            List<Double> yElements = new ArrayList<>();
            List<Double> xElements = new ArrayList<>();
            for (int i = 0; i <= ((int) satellite.getMathModelPeriod().getnIntPer() + 1d); i++) {
                xElements.add(satellite.getMathModelPeriod().getMassiv_t_Per().get(0) + satellite.getMathModelPeriod().getDnIntPer() * i);
                yElements.add(satellite.getMathModelPeriod().getMhf()[i] / ((satellite.getMathModelPeriod().getMassiv_t_Per().size() - 1) * satellite.getMathModelPeriod().getDnIntPer()));
            }

            for (int i = 0; i <= ((int) satellite.getMathModelPeriod().getnIntPer() + 1d); i++) {
                data.getData().add((new XYChart.Data<String, Number>(String.valueOf(xElements.get(i)), yElements.get(i))));
            }
            grPlotnRasprPer.getData().clear();
            grPlotnRasprPer.getData().add(data);
        }
    }

    private void initVariable() {
        colZasnOb.setText(String.valueOf(satellite.getMathModelPeriod().getMassiv_t_Per().size()));
        tekushcZnachPer.setText(String.valueOf(reduceNumber(satellite.getMathModelPeriod().getT_Per(),4)));
        srednZnachPer.setText(String.valueOf(reduceNumber(satellite.getMathModelPeriod().getT_per_sr(),4)));
        maxPer.setText(String.valueOf(reduceNumber(satellite.getMathModelPeriod().getMaxPeriodich(),4)));
        minPer.setText(String.valueOf(reduceNumber(satellite.getMathModelPeriod().getMinPeriodich(),4)));
        srednKvadrOtklon.setText(String.valueOf(reduceNumber(satellite.getMathModelPeriod().getSrKvOtklonenie_Per(),4)));
    }

    /**
     * округление
     * @param number чмсло которое нужно округлить
     * @param coll необходимое число цифр после запятой
     * @return
     */
    private double reduceNumber (double number, int coll) {
        return Math.floor(number * Math.pow(10,coll))/Math.pow(10,coll);
    }
}
