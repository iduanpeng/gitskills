package com.iduanpeng.design.command;

/**
 * Invoker是调用者（司令员），
 * Receiver是被调用者（士兵），
 * MyCommand是命令，实现了Command接口，持有接收对象
 * 命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        ICommand command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();

    }
}
