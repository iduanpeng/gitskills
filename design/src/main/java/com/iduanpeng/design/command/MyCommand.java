package com.iduanpeng.design.command;

public class MyCommand implements ICommand{

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.execute();
    }
}
