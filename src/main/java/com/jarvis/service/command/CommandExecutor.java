package com.jarvis.service.command;

import com.jarvis.service.command.anotation.Command;
import com.jarvis.service.command.exception.BadCommandException;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static CommandExecutor commandExecutor = new CommandExecutor();
    private static Map<String, Class<?>> commands;

    public static void executeCommand(String name, String... args){
        Class<?> clazz = commands.get(name);
        try {

            clazz.getMethod("execute",String[].class).invoke(clazz.newInstance(), (Object) args);
        } catch (Exception e) {
            throw new BadCommandException();
        }

    }
    private CommandExecutor() {
        commands = new HashMap<String, Class<?>>();
        Reflections ref = new Reflections("com.jarvis");
        for (Class<?> cl : ref.getTypesAnnotatedWith(Command.class)) {
                commands.put(cl.getAnnotation(Command.class).value(), cl);

        }
    }
}
