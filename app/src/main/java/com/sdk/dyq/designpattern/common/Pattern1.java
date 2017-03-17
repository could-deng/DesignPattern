package com.sdk.dyq.designpattern.common;

/**
 * Created by yuanqiang on 2017/3/14.
 * 工厂模式
 */

public class Pattern1 {

    //工厂模式

    //一般工厂
//    1.抽象产品接口
//    2.具体产品
//    3.具体生产产品的工厂
    public interface car{    }
    public class Acar implements car{    }
    public class Bcar implements car{    }
//    public class factory{
//        public car produceCar(String string){
//            if(string == "Acar"){
//                return new Acar();
//            }else{
//                return new Bcar();
//            }
//        }
//    }


    //工厂
//    1.抽象产品接口
//    2.具体产品
//    3.抽象工厂，具有统一的抽象生产方法
//    4.具体的工厂,实现统一的抽象生产方法
    public abstract class factory{
        abstract car produceCar();
    }
    public class AcarFactory extends factory{
        @Override
        car produceCar() {
            return new Acar();
        }
    }
    public class BcarFactory extends factory{
        @Override
        car produceCar() {
            return new Bcar();
        }
    }


    //抽象工厂
    //1.抽象产品
    //2.具体产品
    //3.抽象工厂，一种统一抽象方法
    //4.具体工厂，两个工厂，都实现统一的抽象方法
    public interface bus{    }
    public interface plane{    }
    public class Abus implements bus{    }
    public class BBus implements bus{    }
    public class Aplane implements plane{    }
    public class Bplane implements plane{    }
    public abstract class Factory{
        abstract bus produceBus();
        abstract plane producePlane();
    }
    public class AFactory extends Factory{
        @Override
        bus produceBus() {
            return new Abus();
        }
        @Override
        plane producePlane() {
            return new Aplane();
        }
    }
    public class BFactory extends Factory{
        @Override
        bus produceBus() {
            return new BBus();
        }
        @Override
        plane producePlane() {
            return new Bplane();
        }
    }
}
