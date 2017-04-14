package com.sdk.dyq.designpattern.common;

import android.util.Log;

/**
 * 适配器模式
 * 将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题
 */

public class PatternAdapter {
    /**
     * 类的适配器模式
     */
    interface Targetable{
        void method1();
        void method2();
    }
    class Souce{
        public void method1(){//public必不可少
            Log.i("TEST","method1");
        }
    }
    class Adapter extends Souce implements Targetable{
        @Override
        public void method2() {
            Log.i("TEST","method2");
        }
    }

    /**
     * 对象的适配器模式
     */
    interface Targetable2{
        void method1();
        void method2();
    }
    class Source2{
        public void method1(){
            Log.i("TEST","method1");
        }
    }
    class Adapter2 implements Targetable{
        Source2 source;

        @Override
        public void method1() {
            source.method1();
        }

        @Override
        public void method2() {
            Log.i("TEST","method2");
        }
    }
    /**
     * 接口的适配器模式
     */
    interface Sourcable{
        void method1();
        void method2();
    }
    abstract class Wrap implements Sourcable{
        public void method1(){}
        public void method2(){}
    }

    class SourceStub1 extends Wrap{
        @Override
        public void method1() {
            Log.i("TEST","method1");
        }
    }
    class SourceStub2 extends Wrap{
        @Override
        public void method2() {
            Log.i("TEST","method2");
        }
    }

}
