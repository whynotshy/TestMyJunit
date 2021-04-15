package com.yc.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyJunitRunner {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //因为没有idea插件，只能先做  class加载
        Class cls = Class.forName("com.yc.MyCalculatorTest");
        //TODO:升级:...按照 maven 约定的目录要求来扫描 test/java下的单元测试类

        //1.获取这个类中所有方法
        Method[] ms = cls.getDeclaredMethods();
        List<Method> testMethods = new ArrayList<Method>();
        Method beforeMethod = null;
        Method afterMethod = null;
        Method beforeClassMethod = null;
        Method afterClassMethod = null;
        //2.循环这些方法，判断 上面加了哪个注释
        for (Method m : ms){
            //3.将这些方法分别存好。@Test对应的方法有多个，存到一个集合中。  其它注释对应的方法只有一个，直接存。
            if (m.isAnnotationPresent(MyTest.class)){
                testMethods.add(m);  //添加到集合中
            }
            if (m.isAnnotationPresent(MyBefore.class)){
                beforeMethod = m;
            }
            if (m.isAnnotationPresent(MyAfter.class)){
                afterMethod = m;
            }
            if (m.isAnnotationPresent(MyBeforeClass.class)){
                beforeClassMethod = m;
            }
            if (m.isAnnotationPresent(MyAfterClass.class)){
                afterClassMethod = m;
            }
        }
        //4.按Junit的运行的声明周期来调用
        /*
        * beforeclass
        * before
        * add测试
        * after
        * before
        * sub测试
        * after
        * AfterClass
        * */
        if (testMethods == null || testMethods.size() <= 0){
            throw new RuntimeException("没有要测试的方法");
        }
        Object o = cls.newInstance();   //实例化 测试类
        beforeClassMethod.invoke(o, null);  //@BeforeClass
        for(Method m : testMethods){
            if (beforeMethod != null){
                beforeMethod.invoke(o, null);  //@Before
            }
            m.invoke(o, null);  //测试方法
            if (afterMethod != null){
                afterMethod.invoke(o, null);    //@After
            }
        }
        afterClassMethod.invoke(o, null);   //@AfterClass
    }
}
