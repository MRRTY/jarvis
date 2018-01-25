package com.jarvis.service.command;

import static org.junit.Assert.*;

import com.jarvis.service.command.exception.BadCommandException;
import org.junit.Test;

public class CommandExecutorTest {
    @Test(expected = BadCommandException.class)
    public void executeNotExistCommand() throws Exception {
        CommandExecutor.executeCommand("badcommand");
    }

}