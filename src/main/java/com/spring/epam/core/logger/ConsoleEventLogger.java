package com.spring.epam.core.logger;

import com.spring.epam.core.domain.Event;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
