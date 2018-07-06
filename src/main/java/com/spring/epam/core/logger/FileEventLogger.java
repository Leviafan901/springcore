package com.spring.epam.core.logger;

import com.spring.epam.core.domain.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.getMessage(), "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        this.file = new File(fileName);
        boolean isValid = file.canWrite();
        if(!isValid) {
            throw new IOException("File with path" + fileName + " is not valid!");
        }
    }
}
