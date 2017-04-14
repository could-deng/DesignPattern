package com.sdk.dyq.designpattern.common;

import android.util.Log;

/**
 * 桥接模式
 * 由于实际的需要，某个类具有两个以上的维度变化，如果只是使用继承将无法实现这种需要，或者使得设计变得相当臃肿。
 * 而桥接模式的做法是把变化部分抽象出来，使变化部分与主类分离开来，从而将多个的变化彻底分离。最后提供一个管理类来组合不同维度上的变化，
 * 通过这种组合来满足业务的需要。
 *我们JDBC连接的原理
 */

public class PatternBridge {

//    /**
//     * 独立出来的新的维度
//     */
//    interface Peppery{//胡椒粉
//        void style();
//    }
//    class PepperyStyle implements Peppery{
//        @Override
//        public void style() {
//            Log.i("TT","辣");
//        }
//    }
//    class PainStyle implements Peppery{
//        @Override
//        public void style() {
//            Log.i("TT","不辣");
//        }
//    }
//
//    /**
//     * 桥接类
//     */
//    abstract class AbstractNoodle {
//        protected Peppery style;//将该维度的变量独立出去
//
//        public AbstractNoodle(Peppery style) {
//            this.style = style;
//        }
//        abstract void eat();
//    }
//
//    class PorkyNoddle extends AbstractNoodle {
//        public PorkyNoddle(Peppery style) {
//            super(style);
//        }
//        @Override
//        void eat() {
//            style.style();
//        }
//    }
//
//    class BeefNoddle extends AbstractNoodle{
//        public BeefNoddle(Peppery style) {
//            super(style);
//        }
//        @Override
//        void eat() {
//            style.style();
//        }
//
//    }
//
//
//   public void test(){
//       PorkyNoddle noddle1 = new PorkyNoddle(new PepperyStyle());
//       noddle1.eat();
//       BeefNoddle noddle2 = new BeefNoddle(new PainStyle());
//       noddle2.eat();
//
//   }

    /**
     * 独立出来的维度
     */
    interface Sourceable{
        public void method();
    }

    class SourceStub1 implements Sourceable{
        @Override
        public void method() {
            Log.i("TT","sourceStub1.method");
        }
    }

    class SourceStub2 implements Sourceable{
        @Override
        public void method() {
            Log.i("TT","sourceStub2.method");
        }
    }

    /**
     * 桥接类
     */
    abstract class Bridge{
        private Sourceable source;//因拥有多个维度，因此独立出来该变量
        public void method(){
            source.method();
        }

        public Sourceable getSource() {
            return source;
        }

        public void setSource(Sourceable source) {
            this.source = source;
        }
    }

    class MyBridge extends Bridge{
        public void method(){
            getSource().method();
        }
    }
    public void test() {

        Bridge bridge = new MyBridge();

        /*调用第一个对象*/
        Sourceable source1 = new SourceStub1();
        bridge.setSource(source1);
        bridge.method();

        /*调用第二个对象*/
        Sourceable source2 = new SourceStub2();
        bridge.setSource(source2);
        bridge.method();
    }

}
