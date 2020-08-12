package com.iduanpeng.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        /**
         * 1.代替匿名内部类
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(111);
            }
        }).start();


        new Thread(() -> System.out.println(222)).start();


        /**
         * 2.对集合进行迭代
         */
        List<String> list = Arrays.asList("1","2","3");
        for (String s : list) {
            System.out.println(s);
        }

        list.forEach(x -> System.out.println(x));
        list.forEach(System.out::println);


        /**
         * 3.实现map
         */
        List<Integer> list1 = Arrays.asList(1,2,3);
        list1.stream().map(x -> x + 1).forEach(x -> System.out.println(x));

        /**
         * 4.实现map和reduce
         */
        List<Double> list2 = Arrays.asList(10.0,11.0,12.0);
        list2.stream().map(x -> x+1).forEach(System.out::println);
        double result = list2.stream().map(x -> x + x * 0.05).reduce((sum,x) -> sum + x).get();
        System.out.println("result = " + result);

        /**
         * 5 filter 操作
         */
        List<Integer> list3 = Arrays.asList(1,2,3);
        List<Integer> collect = list3.stream().filter(x -> x >= 3).collect(Collectors.toList());
        collect.forEach(x -> System.out.println(x));


        /**
         * 补充
         * @FunctionalInterface  注解的接口可以 被lambda 表达式引用
         */
       WorkerInterface work = () -> System.out.println(123);

        /**
         * 逻辑判断
         */
        List<Integer> list4 = Arrays.asList(1,2,3,4,5);

        System.out.println("所有数字：");
        evaluate(list4,(x) -> true);

        System.out.println("不输出：");
        evaluate(list4,(x) -> false);

        System.out.print("输出偶数：");
        evaluate(list4, (n) -> n % 2 == 0);


        /**
         * 补充 stream map
         */
        // old way
        List<Integer> list5 = Arrays.asList(1,2,3,4,5,6,7);
        for(Integer n : list5) {
            int x = n * n;
            System.out.println(x);
        }

        // new way
        List<Integer> list6 = Arrays.asList(1,2,3,4,5,6,7);
        list6.stream().map((x) -> x*x).forEach(System.out::println);

        /**
         * 补充 stream reduce
         */
        //old way
        List<Integer> list7 = Arrays.asList(1,2,3,4,5,6,7);
        int sum = 0;
        for (Integer integer : list7) {
            int x = integer * integer;
            sum = sum + x;
        }
        System.out.println(sum);
        //new way
        List<Integer> list8 = Arrays.asList(1,2,3,4,5,6,7);
        int sum1 = list8.stream().map(x -> x * x).reduce((x,y) -> x + y).get();
        System.out.println(sum1);


        /**
         * 补充 grouping by
         */
        List<Person> people = new ArrayList<>();
        people.add(new Person(1,"1"));
        people.add(new Person(2,"2"));
        Map<Integer,List<Person>> group = people.stream()
                .collect(Collectors.groupingBy(x -> x.getId()));

        /**
         * 补充 list 转 map
         */
        Map<Integer, String> map = people.stream().collect(Collectors.
                toMap((key -> key.getId()), (value -> value.getName())));
        map.forEach((key,value) -> {
            System.out.println(key + "-" + value);
        });



    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate){
        list.forEach(x -> {
            if (predicate.test(x)){
                System.out.print(x);
            }
        });
        System.out.println();
    }
}
