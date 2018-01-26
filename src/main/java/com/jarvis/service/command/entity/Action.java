package com.jarvis.service.command.entity;

import com.jarvis.service.command.Executable;

@com.jarvis.service.command.anotation.Command("Action")
public class Action implements Executable {
    public void execute(String... args) {
        System.out.println("Hello from Action ");

    }
}
