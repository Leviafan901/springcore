package com.spring.epam.core.logger;

import com.spring.epam.core.domain.Event;

public interface EventLogger {

    public void logEvent(Event event);
}
