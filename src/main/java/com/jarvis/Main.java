package com.jarvis;

import com.jarvis.service.command.CommandExecutor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String args[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        CommandExecutor ce = (CommandExecutor) context.getBean("commandExecutor");
        ce.executeCommand("test");
    }
}
