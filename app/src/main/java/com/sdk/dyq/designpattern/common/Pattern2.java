package com.sdk.dyq.designpattern.common;

/**
 * Created by yuanqiang on 2017/3/14.
 */

public class Pattern2 {
    //建造者模式
    //关注过程
    // 1.具体产品、产品所具备的部分、
    // 2.抽象产品生成器（产品部分的生成、组合）、
    // 3.具体的产品生成器、
    // 4.统筹者（可有可无）
    public class Unit1{
    }
    public class Unit2{
    }
    public class Person{
        public Person() {
        }
        Unit1 unit1;//部分
        Unit2 unit2;//部分
    }
    public interface iBuilder{
        void createUnit1();
        void createUnit2();
        void composite();
    }

    public class Builder implements iBuilder{
        Person person = new Person();
        @Override
        public void createUnit1() {
            person.unit1 = new Unit1();
        }
        @Override
        public void createUnit2() {
            person.unit2 = new Unit2();
        }
        @Override
        public void composite() {
            //todo unit1与unit2的组合
        }
    }
    //统筹者
    public class Director {
        iBuilder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public void build(){
            builder.createUnit1();
            builder.createUnit2();
            builder.composite();
        }
    }

}
