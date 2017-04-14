package com.sdk.dyq.designpattern.common;

/**
 * 状态模式
 */

public class PatternState {

    class State{
        String value;

        public State(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        void method1(){

        }
        void method2(){

        }
        void method3(){

        }
    }
    class Context{
        private State state;

        public Context(State state) {
            this.state = state;
        }

        public void setState(State state) {
            this.state = state;
        }

        void method(){
            if(state.getValue() == "state1"){
                state.method1();
            }else if(state.getValue() == "state2"){
                state.method2();
            }else if(state.getValue() == "state3"){
                state.method3();
            }
        }
    }
    void test(){
        State state = new State("state1");
        Context context = new Context(state);
        context.method();

        context.setState(new State("state2"));
        context.method();

        context.setState(new State("state3"));
        context.method();
    }
}
