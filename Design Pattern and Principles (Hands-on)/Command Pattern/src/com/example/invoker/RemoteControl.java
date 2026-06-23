package com.example.invoker;

import com.example.command.Command;

public class RemoteControl {
    private Command onCommand;
    private Command offCommand;
    private Command lastCommand;

    public void setCommand(Command onCommand, Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }

    public void onButtonWasPushed() {
        if (onCommand != null) {
            onCommand.execute();
            lastCommand = onCommand;
        }
    }

    public void offButtonWasPushed() {
        if (offCommand != null) {
            offCommand.execute();
            lastCommand = offCommand;
        }
    }

    public void undoButtonWasPushed() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}
