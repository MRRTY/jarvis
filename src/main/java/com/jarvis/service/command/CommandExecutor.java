package com.jarvis.service.command;

import com.jarvis.service.command.anotation.Command;
import com.jarvis.service.command.exception.BadCommandException;
import org.reflections.Reflections;
import java.util.HashMap;
import java.util.Map;


public class CommandExecutor {
    private static CommandExecutor commandExecutor = new CommandExecutor();
    private Map<String, Class<?>> commands;

    private CommandExecutor() {
        commands = new HashMap<String, Class<?>>();
        Reflections ref = new Reflections("com.jarvis");
        for (Class<?> cl : ref.getTypesAnnotatedWith(Command.class)) {
                commands.put(cl.getAnnotation(Command.class).value(), cl);

        }
    }

    public static CommandExecutor getInstance() {
        return commandExecutor;
    }

    public void executeCommand(String name, String... args){
        Class<?> commandClass = commands.get(name);
        try {
            commandClass.getMethod("execute", String[].class).invoke(commandClass.newInstance(), (Object) args);
        } catch (Exception e) {
            throw new BadCommandException();
        }

    }

    public  Map<String, Class<?>> getCommands() {
        return commands;
    }

    public void setCommands(Map<String, Class<?>> commands) {
        this.commands = commands;
    }

}
