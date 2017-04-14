package com.sdk.dyq.designpattern.common;

/**
 * 外观模式
 * 解决类与类之间的依赖关系。外观模式就是将他们的关系放在facade类中，降低类的耦合度
 */

public class PatternFacade {
    class CPU {
        void startUp(){};
        void close(){};
    }
    class Monitor{
        void startUp(){};
        void close(){};
    }
    class Facade{
        CPU cpu ;
        Monitor monitor ;

        public Facade() {
            cpu = new CPU();
            monitor = new Monitor();
        }

        void startUp(){
            cpu.startUp();;
            monitor.startUp();
        }
        void close(){
            cpu.close();
            monitor.close();
        }
    }

}
