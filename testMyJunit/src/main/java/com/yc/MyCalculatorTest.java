package com.yc;

import com.yc.biz.Calculator;
import com.yc.junit.*;
import junit.framework.Assert;

/**
 * @programe: ReflectionandAnnotation
 * @description:
 * @author:JACKY
 * @create: 2021-03-31 20:06
 */
public class MyCalculatorTest {
    private Calculator cal;              //        待测试的单元

    @MyBeforeClass
    public static void bc(){System.out.println("beforeclass");}

    @MyBefore        // 执行测试方法前要调用的
    public void setUp() {
        System.out.println("before");
        cal = new Calculator();
    }

    @MyAfter        //  执行测试方法后要调用的
    public void tearDown(){
        System.out.println("after");
    }

    @MyAfterClass
    public static void ac(){System.out.println("AfterClass");}

    @MyTest
    public void add(){
        System.out.println("add测试");

    }

    @MyTest
    public void sub(){
        System.out.println("sub测试");

    }
}
