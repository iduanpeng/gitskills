package com.iduanpeng.design.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

    private List<Component> componentList = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        this.componentList.add(component);
    }

    @Override
    public void remove(Component component) {
        this.componentList.remove(component);
    }

    @Override
    public void display(int depth) {
        for(int i = 0;i < depth; i++){
            System.out.println("-");
        }
        System.out.println(this.name);
        for (Component component : componentList) {
            component.display(depth + 1);
        }

    }
}
