package org.sample.springmvc.extra;

import org.springframework.stereotype.Component;

@Component(value="mb")
public class MessageBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Hello, "+message;
    }
}
