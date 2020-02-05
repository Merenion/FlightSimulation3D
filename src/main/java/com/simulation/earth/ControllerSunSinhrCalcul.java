package com.simulation.earth;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerSunSinhrCalcul {
    public TextField hFly;
    public Label angelPlosk;

    public void actionCalculAngel(ActionEvent actionEvent) {
        try {
            float h = Float.parseFloat(hFly.getText());
            angelPlosk.setText(String.valueOf(calulationAngelNaclon(h)));
        } catch (Exception e) {

        }
    }

    private float calulationAngelNaclon (float h){
        h = h;
        float rz = 6371;
        float u = 398600;
        float Ts = 86400;
        float E = (float) 0.003352;
        float uglUvrZ = (float) (0.729211/10000);
        float p = rz+h;

        float T1 = (float) Math.pow(p,2f/3f);
        float T2 = (float) Math.sqrt(u);
        float T = (float) ((2*Math.PI*Math.pow(p,2f/3f))/Math.sqrt(u));

        float N = Ts/T;
        float cosi = (float) ((u*p*p*(2*Math.PI-Ts*uglUvrZ))/(2*Math.PI*E*N));
        float i = (float) ((float) Math.acos(cosi)*180/Math.PI);
        return i;
    }
}
