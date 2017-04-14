package com.sdk.dyq.designpattern.common;

import android.util.Log;

/**
 * 责任链模式
 * 有多个对象，每个对象有对下一个对象的应用，行程一条链，请求在链上传递，直到某一个对象处理
 */

public class PatternChainOfResponsibility {

    interface Handler{
        void operate();
    }

    abstract class AbstractHandler{
        Handler handler;

        public Handler getHandler() {
            return handler;
        }

        public void setHandler(Handler handler) {
            this.handler = handler;
        }
    }

    class MyHandler extends AbstractHandler implements Handler{
        String name;

        public MyHandler(String name) {
            this.name = name;
        }

        @Override
        public void operate() {
            Log.i("TT","operate");
            if(getHandler()!=null) {
                getHandler().operate();
            }
        }
    }

    void test(){
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        h1.setHandler(h2);
        h1.operate();
    }

}
