package com.simulation.earth;

import com.simulation.earth.spaceObjects.Satellite;
import com.simulation.earth.spaceObjects.SatelliteWithParametersCA;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
                if (satellite.getMathModelCa().isChangeMin()) {
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
        if (satellite.getMathModelCa().isChangeDay() && satellite.getMathModelCa().getMassiv_t_Per().size()!=0) {
            XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
            List<Double> xElements = satellite.getMathModelCa().getMassiv_t_Per();
            List<Double> yElements = new ArrayList<>(satellite.getMathModelCa().getF_Per());

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
        if (satellite.getMathModelCa().isChangeDay() && satellite.getMathModelCa().getMassiv_t_Per().size()>30) {
            XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
            List<Double> yElements = new ArrayList<>();
            List<Double> xElements = new ArrayList<>();
            for (int i = 0; i <= ((int) satellite.getMathModelCa().getnIntPer() + 1d); i++) {
                xElements.add(satellite.getMathModelCa().getMassiv_t_Per().get(0) + satellite.getMathModelCa().getDnIntPer() * i);
                yElements.add(satellite.getMathModelCa().getMhf()[i] / ((satellite.getMathModelCa().getMassiv_t_Per().size() - 1) * satellite.getMathModelCa().getDnIntPer()));
            }

            for (int i = 0; i <= ((int) satellite.getMathModelCa().getnIntPer() + 1d); i++) {
                data.getData().add((new XYChart.Data<String, Number>(String.valueOf(xElements.get(i)), yElements.get(i))));
            }
            grPlotnRasprPer.getData().clear();
            grPlotnRasprPer.getData().add(data);
        }
    }

    private void initVariable() {
        colZasnOb.setText(String.valueOf(satellite.getMathModelCa().getMassiv_t_Per().size()));
        tekushcZnachPer.setText(String.valueOf(satellite.getMathModelCa().getT_Per()));
        srednZnachPer.setText(String.valueOf(satellite.getMathModelCa().getT_per_sr()));
        maxPer.setText(String.valueOf(satellite.getMathModelCa().getMaxPeriodich()));
        minPer.setText(String.valueOf(satellite.getMathModelCa().getMinPeriodich()));
        srednKvadrOtklon.setText(String.valueOf(satellite.getMathModelCa().getSrKvOtklonenie_Per()));
    }
}
