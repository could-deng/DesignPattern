package com.sdk.dyq.designpattern.common;

import android.provider.MediaStore;
import android.util.Log;

/**
 * 中介者模式
 */

public class PatternMediator {

    interface Mediator{
        void createMedia();
        void workAll();
    }


    abstract class User{
        Mediator mediator;
        abstract void work();
    }

    class User1 extends User{

        @Override
        void work() {
            Log.i("TT","user1,work");
        }
    }
    class User2 extends User{

        @Override
        void work() {
            Log.i("TT","user2,work");
        }
    }

    class MyMediator implements Mediator {
        User user1 ;
        User user2 ;
        @Override
        public void createMedia() {
            user1 = new User1();
            user2 = new User2();
        }

        @Override
        public void workAll() {
            user1.work();
            user2.work();
        }
    }
    void test(){
        MyMediator myMediator = new MyMediator();
        myMediator.createMedia();
        myMediator.workAll();
    }
}
