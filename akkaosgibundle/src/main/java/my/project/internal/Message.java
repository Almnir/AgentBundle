package my.project.internal;

import java.io.Serializable;

/**
 * Created by alm on 27.01.14.
 */
public class Message implements Serializable {

    private final String messageString;

    public Message(String messageString) {
        this.messageString = messageString;
    }

    public String getMessageString() {
        return messageString;
    }
}
