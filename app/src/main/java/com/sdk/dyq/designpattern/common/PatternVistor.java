package com.sdk.dyq.designpattern.common;

import android.util.Log;

/**
 * 访问者模式
 */

public class PatternVistor {
    //访问者
    interface Visitor{
        void visit(Subject subject);
    }

    class MyVisitor implements Visitor{
        @Override
        public void visit(Subject subject) {
            Log.i("TT","visit the subject:"+subject.getSubject());
        }
    }

    interface Subject{
        void accept(Visitor visitor);
        String getSubject();
    }

    class MySubject implements Subject{

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override
        public String getSubject() {
            return "love";
        }
    }

    void test(){
        Visitor visitor = new MyVisitor();
        Subject subject = new MySubject();
        subject.accept(visitor);

    }

}
