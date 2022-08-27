package com.calculator.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalControllerTest{
    CalController calController;

    @Test
    public void addTest(){
        MyCalculator calculator=new MyCalculator();
        calController =new CalController(calculator);
        float result=calController.addition(3.0f,4.0f);
        assertEquals(7.0,result,0.0002);
    }
    @Test
    public void subTest(){
        MyCalculator calculator=new MyCalculator();
        calController =new CalController(calculator);
        float result=calController.subtraction(8.0f,4.0f);
        assertEquals(4.0,result,0.0002);
    }
    @Test
    public void mulTest(){
        MyCalculator calculator=new MyCalculator();
        calController=new CalController(calculator);
        float result= calController.multiplication(3.0f,4.0f);
        assertEquals(12.0, result,0.0002);

    }

    @Test
    public void divTest(){
        MyCalculator calculator=new MyCalculator();
        calController=new CalController(calculator);
        float result= calController.division(12.0f,4.0f);
        assertEquals(3.0, result,0.0002);

    }

}