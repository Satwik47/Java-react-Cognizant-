package com.example.main;

import com.example.command.Command;
import com.example.command.LightOffCommand;
import com.example.command.LightOnCommand;
import com.example.invoker.RemoteControl;
import com.example.receiver.Light;

public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light livingRoom = new Light("Living Room");
        Light kitchen = new Light("Kitchen");

        Command livingOn = new LightOnCommand(livingRoom);
        Command livingOff = new LightOffCommand(livingRoom);

        remote.setCommand(livingOn, livingOff);
        System.out.println("--- Living Room Commands ---");
        remote.onButtonWasPushed();
        remote.offButtonWasPushed();
        System.out.println("Undoing last command:");
        remote.undoButtonWasPushed();

        Command kitchenOn = new LightOnCommand(kitchen);
        Command kitchenOff = new LightOffCommand(kitchen);

        remote.setCommand(kitchenOn, kitchenOff);
        System.out.println("--- Kitchen Commands ---");
        remote.onButtonWasPushed();
        remote.offButtonWasPushed();
        System.out.println("Undoing last command:");
        remote.undoButtonWasPushed();
    }
}
