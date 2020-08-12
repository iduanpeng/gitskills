package com.iduanpeng.design.factory.simplefactory;

public class SimpleFactory {
    public static Operation createOperation(String name){
        Operation operation = null;
        switch (name){
            case "+":
                operation = new Add();
                break;
            case "-":
                operation = new Sub();
                break;
            case "*":
                operation = new Mul();
                break;
            case "/":
                operation = new Div();
                break;
            default:
                    break;
        }
        return operation;
    }

    public static void main(String[] args) throws Exception {
        Operation operation = SimpleFactory.createOperation("+");
        System.out.println(operation.getResult(1,1));
    }
}
