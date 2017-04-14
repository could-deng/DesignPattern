package com.sdk.dyq.designpattern.common;

/**
 * 桥接模式
 * 由于实际的需要，某个类具有两个以上的维度变化，如果只是使用继承将无法实现这种需要
 * 就是把事物与具体实现分开，使他们可以各自独立地变化。
 * 将抽象部分与实现部分分离，使它们都可以独立的变化。
 */

public class Pattern3 {
    //1.abstraction,抽象化角色,抽象出给出的定义，并持有实现者对象
    //2.refined abstraction拓展抽象化角色,修正或者改变父类对抽象化的定义
    //3.implementor,实现化对象
    //4.onCreateImplementor，具体实现者
    /**
     * implementor，实现化对象
     */
    interface Drawing {
        void drawCircle();
        void drawRectangle();
    }

    /**
     *抽象化角色
     */
    public abstract class shape{

        protected Drawing drawing ;//实现化对象，桥接出去
        public shape() {
        }
        public shape(Drawing drawing) {
            this.drawing = drawing;
        }

        public abstract void draw();

        protected void drawCircle(){
            drawing.drawCircle();
        }
        protected void drawRectangle(){
            drawing.drawRectangle();
        }
    }

    /**
     * 拓展化角色
     */
    public class Circle extends shape{
        public Circle(Drawing drawing) {
            super(drawing);
        }

        @Override
        public void draw() {
            drawCircle();
        }
    }

    /**
     * 拓展化角色
     */
    public class Rectangle extends shape{
        @Override
        public void draw() {
            drawRectangle();
        }
    }


    /**
     *具体实现者
     */
    class DrawCompany1 implements Drawing{
        DP1 dp1 = new DP1();
        @Override
        public void drawCircle() {
            dp1.draw1Circle();
        }

        @Override
        public void drawRectangle() {
            dp1.draw1Rectangle();
        }
    }
    /**
     *具体实现者
     */
    class DrawCompany2 implements Drawing{
        DP2 dp2 = new DP2();
        @Override
        public void drawCircle() {
            dp2.draw2Circle();
        }

        @Override
        public void drawRectangle() {
            dp2.draw2Rectangle();
        }
    }

    class DP1{
        public DP1() {
        }
        void draw1Circle(){
            //1画法画圆
        }
        void draw1Rectangle(){
            //1画法画圆
        }
    }
    class DP2{
        void draw2Circle(){
            //2画法画圆
        }
        void draw2Rectangle(){
            //2画法画圆
        }
    }

}
