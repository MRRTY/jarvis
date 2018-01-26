package com.jarvis;

import com.jarvis.service.command.CommandExecutor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException, UnsupportedAudioFileException {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        CommandExecutor ce = (CommandExecutor) context.getBean("commandExecutor");
        ce.executeCommand("test");

        File file = new File("D:/test/test.wav");
        AudioInputStream in= AudioSystem.getAudioInputStream(file);
        AudioInputStream din = null;
        AudioFormat baseFormat = in.getFormat();
        AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                baseFormat.getSampleRate(),
                false);
        din = AudioSystem.getAudioInputStream(decodedFormat, in);
        byte[] data = new byte[din.available()];
        din.read(data);
        System.out.println(Arrays.toString(data));
    }
}
