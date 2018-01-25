package com.jarvis.service.command.entity;

import com.jarvis.service.command.Commandable;

@com.jarvis.service.command.anotation.Command("Action")
public class Action implements Commandable {
    public void execute(String... args) {
        System.out.println("Hello from Action ");

    }
}
