package com.sdk.dyq.designpattern.common;

import android.util.Log;

/**
 * 命令模式
 * 实现请求和执行分开，熟悉Struts的同学应该知道，Struts其实就是一种将请求和呈现分离的技术，其中必然涉及命令模式的思想！
 */

public class PatternCommand {
    interface Command{
        void exe();
    }

    class Receiver{
        void action(){
            Log.i("TT","receive");
        }
    }
    class MyCommand implements Command{
        Receiver receiver;

        public MyCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void exe() {
            receiver.action();
        }
    }
    class Invoker{
        Command command ;

        public Invoker(Command command) {
            this.command = command;
        }

        void action(){
            command.exe();
        }
    }

    void test(){
        Receiver re = new Receiver();
        Command com = new MyCommand(re);
        Invoker inv = new Invoker(com);
        inv.action();
    }

}
