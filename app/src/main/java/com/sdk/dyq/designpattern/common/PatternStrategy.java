package com.sdk.dyq.designpattern.common;

/**
 * 策略模式
 * 定义一系列算法，并将每个算法封装起来，使用者只管使用，不会被算法的变化所改变
 * 设计一个接口，各个算法实现该接口
 */

public class PatternStrategy {
    interface ICalculator{
        int calculate(String calString);
    }
    class Plus implements ICalculator{

        @Override
        public int calculate(String calString) {
            String arrays[] = calString.split("\\+");
            int a1 = Integer.valueOf(arrays[0]);
            int a2 = Integer.valueOf(arrays[1]);
            return a1+a2;
        }
    }
    class Minus implements ICalculator{

        @Override
        public int calculate(String calString) {
            String arrays[] = calString.split("-");
            int a1 = Integer.valueOf(arrays[0]);
            int a2 = Integer.valueOf(arrays[1]);
            return a1-a2;
        }
    }

    void test(String string){
        ICalculator icalculator = new Plus();//重点
        int result = icalculator.calculate("2+3");

        ICalculator icalculator2 = new Minus();
        int result2 = icalculator2.calculate("3-2");

    }
}
