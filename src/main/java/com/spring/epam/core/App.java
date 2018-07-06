package com.spring.epam.core;

import com.spring.epam.core.domain.Client;
import com.spring.epam.core.domain.Event;
import com.spring.epam.core.logger.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger logger;
    private Event event;

    public App(Client client, EventLogger logger, Event event) {
        this.client = client;
        this.logger = logger;
        this.event = event;
    }

    public static void main(String... args) {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) appContext.getBean("app");

        app.logEvent("1");

        appContext.close();
    }

    private void logEvent(String message) {
        String newMessage = message.replaceAll(
            client.getId(), client.getFirstName()
        );
        this.event.setMessage(newMessage);
        this.logger.logEvent(event);
    }
}
