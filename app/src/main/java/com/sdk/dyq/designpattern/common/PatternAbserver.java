package com.sdk.dyq.designpattern.common;

import android.util.Log;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 订阅者模式
 */

public class PatternAbserver {

    //观察者
    interface Observer{
        void update();
    }
    class Observer1 implements Observer{
        @Override
        public void update() {
            Log.i("TT","Observer1,update");
        }
    }

    class Observer2 implements Observer{
        @Override
        public void update() {
            Log.i("TT","Observer1,update");
        }
    }


    //被观察者
    interface Subject{
        void add(Observer obs);
        void remove(Observer obs);
        void notifyObserver();//通知
        void operate();//自身操作
    }

    abstract class abstractSubject implements Subject {
        private Vector<Observer> list;

        protected abstractSubject() {
            list = new Vector<>();
        }

        @Override
        public void add(Observer obs) {
            list.add(obs);
        }

        @Override
        public void remove(Observer obs) {
            list.remove(obs);
        }

        @Override
        public void notifyObserver() {
            Enumeration<Observer> enumo = list.elements();
            while (enumo.hasMoreElements()){
                enumo.nextElement().update();
            }
        }
    }

    class MySubject extends abstractSubject{
        @Override
        public void operate() {
            Log.i("TT","update self");
            notifyObserver();
        }
    }

    void test(){
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());
        sub.operate();
    }

}

