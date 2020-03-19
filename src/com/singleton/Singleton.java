package com.singleton;


/**
 * 1 默认就是饿汉式  线程安全
 *
 * 2 懒加载  线程不安全
 */
//public class Singleton {
//
//    private static Singleton ourInstance;
//
//    static Singleton getInstance() {
//        if (ourInstance == null) {
//            ourInstance = new Singleton();
//        }
//        return  ourInstance;
//    }
//
//    private Singleton() {
//
//    }
//}

/**
 * 线程安全但是效率低下
 *
 * 单锁
 */
//public class Singleton {
//
//    private static Singleton singleton;
//
//    static synchronized Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }
//
//    private Singleton() {
//
//    }
//}


/**
 * 双锁
 */
//public class Singleton {
//
//    private static Singleton singleton;
//
//    static Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//
//    private Singleton() {
//
//    }
//}

/**
 * 静态内部类
 *
 * 静态内部类中的静态成员只在第一次使用的时候加载
 */
public class Singleton {

    private static class InnerClass {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerClass.singleton;
    }

    private Singleton() {

    }
}