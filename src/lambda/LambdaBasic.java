package src.lambda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface TransForm<T, R> {
    R transForm(T t);
}

@FunctionalInterface
interface Generator<T, R> {
    R create(T t);
}

interface AppleFilter {
    boolean test(Apple apple);
}

class Apple {
    private String color;
    private Double weight;
    
    public Apple(String color, Double weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(String color) {
        this.color = color;
    }
    

    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

class AppleFilterMethod {
    public static List<Apple> filterApple(List<Apple> list, AppleFilter filter) {
        List<Apple> filterList = new ArrayList<>();
        for (Apple apple : list) {
            if (filter.test(apple)) {
                filterList.add(apple);
            }
        }
        return filterList;
    }
}

public class LambdaBasic {

    public static void main(String[] args) {
        //函数式接口
        Thread t1 = new Thread(() -> System.out.println("hello lambda!"));
        t1.start();

        //类型转换函数式接口
        TransForm<String, Integer> trans = (String str) -> Integer.valueOf(str);
        System.out.println(trans.transForm("111"));
        //简化版
        TransForm<String, Integer> trans1 = (str) -> Integer.valueOf(str);
        System.out.println(trans1.transForm("222"));
        
        //分隔符::写法
        TransForm<String, Integer> trans2 = Integer::valueOf;
        System.out.println(trans2.transForm("333"));

        //创造一个Apple实例
        Generator<String, Apple> g = Apple::new;
        Apple apple = g.create("red");

        //等价方法
        Generator<String, Apple> g2 = (color) -> new Apple(color);
        Apple apple2 = g2.create("green");

        //访问局部final变量，成员变量和静态变量，需确保值不变
        String str = "abc";
        Runnable r = () -> System.out.println(str);
        // str = "cba";   //改变str的值报错

        //Lambda表达式实战
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("red", 0.4));
        appleList.add(new Apple("red", 0.6));
        appleList.add(new Apple("red", 1.3));
        appleList.add(new Apple("green", 0.2));
        appleList.add(new Apple("green", 0.35));
        appleList.add(new Apple("green", 1.1));
        //筛选红色的苹果
        List<Apple> appleFilterList = AppleFilterMethod.filterApple(appleList, (apple3) -> "red".equalsIgnoreCase(apple3.getColor()));
        appleFilterList.stream().forEach(app -> System.out.println(app.getColor() + " apple,weight:" + app.getWeight()));
        //筛选红色且重量大于1kg的苹果
        List<Apple> appleFilterList2 = AppleFilterMethod.filterApple(appleList, (apple4) -> "green".equalsIgnoreCase(apple4.getColor()) && apple4.getWeight() > 1.0);
        appleFilterList2.stream().forEach(app -> System.out.println(app.getColor() + " apple,weight:" + app.getWeight()));
    }
    
}