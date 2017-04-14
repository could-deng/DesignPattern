package com.sdk.dyq.designpattern.common;

/**
 * 模板方法模式
 * 一个抽象类，具备一个主方法，n个抽象方法。定义一个类继承抽象类，重写抽象方法。通过调用抽象类，实现了对子类的调用。
 */

public class PatternTemplateMethod {

    abstract class AbstractCalculator{
        final int calculate(String cal,String opt){
            String arrays[] = cal.split(opt);
            return calculate(arrays[0],arrays[1]);
        }
        abstract int calculate(int num1,int num2);
    }

    class Plus extends AbstractCalculator{

        @Override
        int calculate(int num1, int num2) {
            return num1+num2;
        }
    }

    class Minus extends AbstractCalculator{
        @Override
        int calculate(int num1, int num2) {
            return num1-num2;
        }
    }

    int test(){
        AbstractCalculator calculator = new Plus();
        int num = calculator.calculate("9+1","\\+");
        return num;
    }

}
