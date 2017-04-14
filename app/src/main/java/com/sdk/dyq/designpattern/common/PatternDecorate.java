package com.sdk.dyq.designpattern.common;

import android.util.Log;

/**
 * 装饰模式
 * 装饰模式即给一个对象新的功能。装饰对象与被装饰对象实现一个接口，同时装饰对象持有被装饰对象的实例。
 */

public class PatternDecorate {
    interface Sourceable{
        void method1();
    }
    class Source implements Sourceable{
        @Override
        public void method1() {
            Log.i("TT","method1");
        }
    }
    class Decoratror implements Sourceable{
        Source source;

        public Decoratror(Source source) {
            this.source = source;
        }

        @Override
        public void method1() {
            Log.i("TT","header");
            source.method1();
            Log.i("TT","footer");
        }
    }

}
