package com.iduanpeng.base.generic.g5;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型上下边界
 * @param <T>
 */
public class Generic<T> {

    private Object o;

    public Generic(T o) {
        this.o = o;
    }

    public Object getO() {
        return o;
    }

    static List<Generic<? extends Number>> gg = new ArrayList<>();

    // 形参                                  实参
    public <T extends Number> T show(Generic<? extends Number> t){
        return null;
    }

    public static void showValue(Generic<Object> g){
        System.out.println(g.getO());
    }

    public static void showValue1(Generic<?> g){
        System.out.println(g.getO());
    }
    public static void showValue2(Generic<? extends Number> g){
        gg.add(g);
        System.out.println(g.getO());
    }

    public static void main(String[] args) {
        Generic<Integer> a = new Generic<Integer>(11);
        Generic<String> b = new Generic<String>("111");

        //showValue(a); 报错
        //showValue(b); 报错
        //通配符
        /**
         * 通过提示信息我们可以看到Generic<Integer>不能被看作为`Generic<Number>的子类。
         * 由此可以看出:同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的。
         *
         * 回到上面的例子，如何解决上面的问题？总不能为了定义一个新的方法来处理Generic<Integer>类型的类，
         * 这显然与java中的多台理念相违背。因此我们需要一个在逻辑上可以表示同时是Generic<Integer>和
         * Generic<Number>父类的引用类型。由此类型通配符应运而生。
         */
        showValue1(a);
        showValue1(b);
        /**
         * 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。
         * 重要说三遍！此处’？’是类型实参，而不是类型形参 ！ 此处’？’是类型实参，而不是类型形参 ！
         * 再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，
         * 可以把？看成所有类型的父类。是一种真实的类型。
         *
         * 可以解决当具体类型不确定的时候，这个通配符就是 ?  ；当操作类型时，不需要使用类型的具体功能时，
         * 只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
         */

        /**
         * 使用泛型的时候，我们还可以为传入的泛型类型实参进行上下边界的限制，如：类型实参只准传入某种类型的父类或某种类型的子类
         */
        Generic<Integer> generic = new Generic<Integer>(11);
        Generic<Double> doubleGeneric = new Generic<Double>(22.2);
        showValue2(generic);
        showValue2(doubleGeneric);
        System.out.println(gg.toString());


    }
}
