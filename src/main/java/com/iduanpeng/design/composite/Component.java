package com.iduanpeng.design.composite;

/**
 * <p>组合模式 分透明模式和安全模式</p>
 *
 *
 * <p>透明模式是把组合使用的方法放到抽象类中，不管叶子对象还是树枝对象都有相同的结构，</br>
 * 这样做的好处就是叶子节点和树枝节点对于外界没有区别，它们具备完全一致的行为接口。</br>
 * 但因为Leaf类本身不具备add()、remove()方法的功能，所以实现它是没有意义的</p>
 *
 *
 * <p>安全模式是把树枝节点和树叶节点彻底分开，树枝节点单独拥有用来组合的方法，</br>
 * 这种方法比较安全。但由于不够透明，所以树叶节点和树枝节点将不具有相同的接口，</br>
 * 客户端的调用需要做相应的判断，带来了不便</p>
 *
 */
public abstract class Component {
    protected String name;

    public Component(String name){
        this.name = name;
    }
    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display(int depth);

}
