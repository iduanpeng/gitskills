package com.iduanpeng.design.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ChessFlyWeightFactory {
    //享元池
    private static Map<String,ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color){
        if (map.get(color) == null){
            return map.get(color);
        } else {
            ChessFlyWeight cfw = new ConcreteChess(color);
            map.put(color,cfw);
            return cfw;
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("black");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("black");
        System.out.println(chess1);
        System.out.println(chess2);
        //外部状态增加
        chess1.display(new Coordinate(1,1));
        chess2.display(new Coordinate(2,1));
    }

}
