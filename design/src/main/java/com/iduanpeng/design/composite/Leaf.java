package com.iduanpeng.design.composite;

public class Leaf extends Component {



    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void display(int depth) {
        for(int i = 0;i < depth; i++){
            System.out.println("-");
        }
        System.out.println(this.name);
    }
}
