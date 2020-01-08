package com.simulation.earth.spaceObjects;

import com.simulation.earth.ControllerWindowSimulation;
import com.simulation.earth.MathModels.GeodeticLocation;
import com.simulation.earth.MathModels.MathModelCa;
import com.simulation.earth.MathModels.MathModelSatelite;
import com.simulation.earth.PerspectiveCameraWithName;
import com.simulation.earth.manageSatellite.CaParameters;
import com.simulation.earth.manageSatellite.OrbitParameters;
import com.simulation.earth.manageSatellite.StorageOrbitParameters;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

/**
 * реализация космического обьекта- спутника с парамметрами СА
 */
public class SatelliteWithParametersCA extends SatelliteDefault{

    CaParameters caParameters;

    MathModelCa mathModelCa;


    public SatelliteWithParametersCA(OrbitParameters parametrsOrbit, CaParameters caParameters) {
        super(parametrsOrbit);
        this.caParameters = caParameters;
        mathModelCa = new MathModelCa(parametrsOrbit,caParameters);
    }

    public CaParameters getCaParameters() {
        return caParameters;
    }

    public void setCaParameters(CaParameters caParameters) {
        this.caParameters = caParameters;
    }

    @Override
    public void movement(double time) {
        super.movement(time);
        mathModelCa.testMath2(time, ControllerWindowSimulation.getControllerWindowSimulation().getSimulation().getDeltaTime());
    }
}