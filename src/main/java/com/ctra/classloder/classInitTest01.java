package com.ctra.classloder;

public class classInitTest01 {
    static {
        System.out.println("main方法总是会启动（最优先）");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // ======================= 主动引用 二个示例 ===========================
        //Father fa = new Son();
        // ---------输出----------------
        // main方法总是会启动（最优先）
        // 父类被加载
        // 子类被加载
        // 2

        //Class.forName("com.ctra.classloder.Son");
        // ---------输出----------------
        // main方法总是会启动（最优先）
        //父类被加载
        //子类被加载

        // ======================= 被动引用 三个示例 ===========================

        //System.out.println(Son.M); // 访问静态常量
        // ---------输出----------------
        // main方法总是会启动（最优先）
        // 2

        //Son[] sons = new Son[100]; // 数组定义
        // ---------输出----------------
        // main方法总是会启动（最优先）

        //System.out.println(Son.b);// 访问父类静态域（变量、方法）
        // ---------输出----------------
        // main方法总是会启动（最优先）
        // 父类被加载
        // 2
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 3;
    }

    static int m = 1;
    static final int M = 2;
}

class Father {
    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}
