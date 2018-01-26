package com.jarvis.service.command;

import static org.junit.Assert.*;

import com.jarvis.service.command.anotation.Command;
import com.jarvis.service.command.entity.TestCommand;
import com.jarvis.service.command.exception.BadCommandException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandExecutorTest {
    private CommandExecutor ce;
    @Before
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        ce = (CommandExecutor) context.getBean("commandExecutor");
    }
    @Test(expected = BadCommandException.class)
    public void executeNotExistCommand() throws Exception {
        ce.executeCommand("badcommand");
    }

    @Test
    public void executeExistCommand() throws Exception {
        ce.getCommands().put("test",TestCommand.class);
        ce.executeCommand("test");
    }

}