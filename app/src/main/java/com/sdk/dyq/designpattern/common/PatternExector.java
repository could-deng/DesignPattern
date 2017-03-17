package com.sdk.dyq.designpattern.common;

import java.util.ArrayList;

/**
 *  使用者
 */

public class PatternExector {
    public PatternExector() {    }

    /**
     * 订阅者模式
     */
    void Pattern5Execte(){
        Pattern5 a = new Pattern5();
        Pattern5.Observable<Pattern5.Weather> observable = a. new Observable<Pattern5.Weather>();
        Pattern5.Observer<Pattern5.Weather> observer1 = new Pattern5.Observer<Pattern5.Weather>() {
            @Override
            public void doUpdate(Pattern5.Observable<Pattern5.Weather> observable, Pattern5.Weather data) {
                //收到订阅的通知
            }
        };
        Pattern5.Weather weather = a.new Weather();
        weather.setDescription("天气晴朗");
        observable.register(observer1);
        observable.notifyObserver(weather);
    }

    /**
     * 原型模式
     */
    void Pattern4Execte(){
        Pattern4 p=new Pattern4();
        p.setAge(18);
        p.setName("张三");
        p.setHeight(178);
        ArrayList<String> hobbies=new ArrayList<String>();
        hobbies.add("篮球");
        hobbies.add("编程");
        hobbies.add("长跑");
        p.setHobbies(hobbies);
        System.out.println(p);
        Pattern4 p1= (Pattern4) p.clone();
        System.out.println(p1);
        p1.setName("李四");
        p1.getHobbies().add("游泳");
        System.out.println(p);
        System.out.println(p1);
    }

    /**
     * 建造者
     */
    void pattern2Exector(){
        Pattern2 p2 = new Pattern2();
        Pattern2.Builder builder = p2.new Builder();
        Pattern2.Director director = p2.new Director(builder);
        director.build();
    }

    /**
     * 建造者
     */
    void personExector(){
        //使用
        Person.Builder builder=new Person.Builder();
        Person person=builder
                .name("张三")
                .age(18)
                .height(178.5)
                .weight(67.4)
                .build();
    }



}
