package com.spring.epam.core.logger;

import com.spring.epam.core.domain.Event;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    public CacheFileEventLogger(String fileName, int cacheSize, ArrayList cache) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = cache;
    }

    private int cacheSize;
    private List<Event> cache;

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        try {
            StringBuilder combinedMessage = new StringBuilder();
            for (Event gettedEvent : cache) {
                combinedMessage.append(gettedEvent.getMessage());
            }
            String message = combinedMessage.toString();
            FileUtils.writeStringToFile(getFile(), message, "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
