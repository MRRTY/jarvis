package com.jarvis.service.command.entity;

import com.jarvis.service.command.Commandable;

@com.jarvis.service.command.anotation.Command("Deactivate")
public class Deactivate implements Commandable {

    public void execute(String... args) {
        System.out.println("Hello from Deactivate");
    }
}
