package YC;

//java bean规范
/**
 * @programe: ReflectionandAnnotation
 * @description:
 * @author:JACKY
 * @create: 2021-03-29 19:27
 */
public class Person implements Showable{
    private String name;
    private int age;

    public Person(){System.out.println("无参构造方法");}

    public Person(String name){
        this.name = name;
        System.out.println("有参构造方法");
    }


    public void show() {
        System.out.println("show");
    }

    @Override
    public String toString(){
        return "Person{" +
                "name='" + name +'\'' +
                ",age="  + age +
                '}';
    }
}
