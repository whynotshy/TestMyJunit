//package YC;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//import static YC.Method.setValues;
//
////在程序 运行中，有人给了一个类，请动态的了解这个类，且创建这个类的对象。
//public class Test1 {
//
//    public static void main(String[] args) throws ClassNotFoundException {
//        Scanner sc = new Scanner(System.in);
//        while (true){
//            System.out.println("请输入类路径：");
//            String path = sc.nextLine();
//            System.out.println("待加载的类为："+path);
//
//            class c = Class.forName(path);
//            String name = c.getName();
//            System.out.println(name);
//
//            //Fields[] fs = c.getFields();
//            Field[] fs = c.getDeclaredFields(); //Declared 自己声明的
//            if (fs != null && fs.length>0){
//                for (Field f : fs){
//                    //private
//                    String modifier = "";
//                    switch (f.getModifiers()){
//                        case 1:
//                            modifier ="public";
//                            break;
//                        case 2:
//                            modifier = "private";
//                            break;
//                        System.out.println(modifier+"\t"+f.getName());
//                        //算法：位图算法
//                    }
//                }
//
//                Method[] ms = c.getDeclaredMethod();
//                //Method[] ms = c.getMethod();
//                if(ms != null && ms.length > 0){
//                    for (Method m : ms){
//                        System.out.println(m.getModifiers() + "\t" + m.getReturnType().toString() + "\t" +m.getClass());
//                    }
//                }
//
//                Constructor [] cs = c.getConstructors();
//                if (cs ! = null&&cs.length > 0){
//                    for (Constructor m : cs){
//                        System.out.println(m.getModifiers()+"\t"+m.getName());
//                    }
//                }
//
//                //利用反射完成实例化操作
//                Object o = newInstance();   //无参构造方法
//                if ( o instanceof Showable){
//                    Showable p = (Showable) o;
//                    p.show();
//                }
//
//                //利用反射调用某个方法  适合j2EE中的规范化方法调用场景 setXXX getXxxx()
//                System.out.println("==================");
//                if (ms ! =null && ms.length > 0){
//                    for (Method m:ms){
//                        if (m.getName().startWith("sh")){
//                            //调用此方法 show（）  它有两个参数：第一个是实例，第二个实参数组
//                            m.invoke(o);
//                        }
//                    }
//                }
//
//                Map<String,String> pMap = new HashMap<String, String>();
//                pMap.put("name","张三");
//                pMap.put("age",30 + "");
//                Object oo = setValues(pMap, c);
//                System.out.println(oo.toString());
//            }
//        }
//
//    /**
//     * 反射功能模块： 将Map中保存的 属性知存到 cls对应的对象中，注意一直 cls 满足将ee的javabean规范（setXxxx getXxx）
//     * @param map
//     * @param cls
//     * @return
//     */
//    public static Object setValues(Map<String,String> map, Class cls){
//        Object o = null;  o:  "Person{name='张三',age=0}"
//        o = cls.newInstance();
//        Method[] ms = cls.getDeclaredMethods(); ms:Method[6]@651 cls:"class com.yc.Person"
//        if ( ms!=null&&ms.length>0){
//            for (Method m : ms.length>0){ m: "public void com.yc.Person.setAge(int)" ms:Method[6]@651
//                    //只有setXxx才激活
//                    if(m.getName().startsWith("set")){
//                        String mName = m.getName(); mName:"setAge"
//                        String fName = mName.substring(3).toLowerCase();fName:"age" mName:"setAge"
//                        String value = map.get(fName); value: "30" map: size = 2  fName: "age"
//                        if("Integer".equalsIgnoreCase(m.getParameterType()[0].getTypeName())||"Int".equalsIgnoreCase(m.getParameterType()[0])){
//                            m.invoke(o, Integer.parseInt(value));   //调用set方法，设置值 m: "public void com.yc.Person.setAge(Age) o:"Person "
//                        }else {
//                            m.invoke(o,value); //调用set方法，设置值
//                        }
//
//                    }
//                 }
//            }
//
//        return o;
//
//    }
//}
