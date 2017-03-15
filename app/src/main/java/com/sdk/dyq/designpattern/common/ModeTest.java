package com.sdk.dyq.designpattern.common;

/**
 * 单例模式
 */

public class ModeTest {

    //静态内部类
    public ModeTest(){};
    public static class LazyHolder{
        public static ModeTest holder =  new ModeTest();
    }
    public static ModeTest getInstance(){
        return LazyHolder.holder;
    }

    //饿汉
//  public ModeTest(){}
//  private static ModeTest test = new ModeTest();
//  public static ModeTest getInstance(){
//      return test;
//  }

    //懒汉
//    private ModeTest(){}
//    private static ModeTest test;
//    public static ModeTest getInstance(){
//        if(test == null){
//            test = new ModeTest();
//        }
//        return test;
//    }

    //双重锁
//    public static ModeTest test = null;
//    public ModeTest(){}
//    public ModeTest getInstance(){
//        if(test == null){
//            synchronized (ModeTest.class) {
//                if(test == null) {
//                    test = new ModeTest();
//                }
//            }
//        }
//        return test;
//    }

}
