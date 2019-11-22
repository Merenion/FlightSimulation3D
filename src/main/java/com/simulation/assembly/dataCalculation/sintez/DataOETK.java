package com.simulation.assembly.dataCalculation.sintez;

public class DataOETK {

    //выходные параметры
    public float fOETK;        //Фокусное расстояние
    public float lOETK;        //Длина ОЭТК, м
    public float dOETK;        //Диаметр ОЭТК
    public float mOETK;        //Масса телескопа
    public float vOETK;        //Обьем телескопа
    public float jOETK;        //Максимальный приведенный момент инерции ОЭТК, кг м2
    public float wOETK;        //Средняя мощность энергопотребления, Вт

    public float dkSO_OETK;//Диаметр корпуса спецотсека КА
    public float lkSO_OETK;//Длина корпуса спецотсека КА
    public float vkSO_OETK;//Обьем КА с телескопом

    //входные параметры
    public float Det;     //Детальность
    public float H;            //Высота полета
    public float rELPZS;       //Размер элемента ПЗС
    public float kUD;       //Коэффициент уменьшения длины ОЭТК
    public float oO;      //Относительное отверстие
    public float plOETK;  //Средняя плотность ОЭТК, кг/м3
    public float uwOETK;  //удельная мощность энергопотребления, Вт/кг
    public float krkOETK;  //коэффициент рациональности компоновки ОЭТК
    public float kp2dOETK; //Коэффициент превышения диаметра корпуса спецотсека КА над диматром корпуса ОЭТК
    public float kp2lOETK; //Коэффициент превышения длины корпуса спецотсека КА над длиной корпуса ОЭТК
    public TypeKa typeKA; //большой, маленький, средний
}
