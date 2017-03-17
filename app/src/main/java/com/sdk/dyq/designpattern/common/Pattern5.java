package com.sdk.dyq.designpattern.common;

import java.util.ArrayList;

/**
 * 观察者模式
 * 各种onClickListener等等监听器、回调、都是使用观察者模式
 */

public class Pattern5 {

    public interface Observer<T>{//观察者
        void doUpdate(Observable<T> observable,T data);
    }

    public class Weather{//实体类
        public Weather() {}
        private String description;
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
    }
    public class Observable<T>{//被观察者
        Observable() {}
        ArrayList<Observer<T>> mObserver = new ArrayList<>();
        void register(Observer<T> observer){
            if(observer != null) {
                synchronized (this) {
                    mObserver.add(observer);
                }
            }
        }
        synchronized void unregister(Observer<T> observer){
            mObserver.remove(observer);
        }
        public void notifyObserver(T data){
            for(Observer<T> observer:mObserver){
                observer.doUpdate(this,data);
            }
        }
    }


}
