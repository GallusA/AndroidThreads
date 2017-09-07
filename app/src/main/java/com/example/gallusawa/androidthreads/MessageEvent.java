package com.example.gallusawa.androidthreads;

import java.util.Stack;

/**
 * Created by gallusawa on 8/8/17.
 */

public class MessageEvent {

    String message;

    MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
