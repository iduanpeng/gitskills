package com.iduanpeng.design.composite;

public class Client {

    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("leaf A"));
        root.add(new Leaf("leaf B"));

        Composite branch = new Composite("Composite X");
        branch.add(new Leaf("leaf XA"));
        branch.add(new Leaf("leaf XB"));
        root.add(branch);

        root.display(1);



    }
}
