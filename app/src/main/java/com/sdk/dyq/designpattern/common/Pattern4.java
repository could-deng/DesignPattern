package com.sdk.dyq.designpattern.common;

import java.util.ArrayList;

/**
 * 原型模式
 * 各种实现clonnable()接口的方法
 */

public class Pattern4 implements Cloneable{
    private String name;
    private int age;
    private int height;
    private ArrayList<String> hobbies;

    public Pattern4() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    /**
     * 深拷贝
     * @return
     */
    @Override
    protected Object clone()  {
        Pattern4 person = null;
        if(person == null){
            person = new Pattern4();
            person.age = this.age;
            person.height = this.height;
            person.name = this.name;
            person.hobbies = (ArrayList<String>)this.hobbies.clone();//深拷贝
        }
        return person;
    }


    /**
     * 浅拷贝,即直接实现clonable接口即可
     * @return
     * @throws CloneNotSupportedException
     */
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Pattern4 person = (Pattern4) super.clone();
//        return person;
//    }
}
