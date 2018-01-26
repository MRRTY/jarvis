package com.jarvis.service.command.entity;

import com.jarvis.service.command.Executable;
import com.jarvis.service.command.anotation.Command;

@Command("test")
public class TestCommand implements Executable {
    public void execute(String... args) {
        System.out.println("Test command");
    }
}
