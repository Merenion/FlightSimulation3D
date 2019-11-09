package com.simulation.assembly;

public class Validate {

    /**
     * можно ли текст преообразовать в float
     * @param text
     * @return
     */
    public static boolean validFloat (String text){
        try {
            conversionTextToFloat(text);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * конвертирует текст в float (работает с запятой и точкой)
     * @param text
     * @return
     */
    public static Float conversionTextToFloat (String text){
        if (text.contains(",")){
            String[] textArray = text.split(",");
            text = textArray[0]+"."+textArray[1];
        }
        return Float.parseFloat(text);
    }

}
