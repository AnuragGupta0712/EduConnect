package com.example.website.domain;

import org.springframework.stereotype.Component;

@Component
public class SupportUserMessage implements UserMessage{
    String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }


    @Override
    public void setUserId(int userId) {
        this.Message = "Hii,Welcome to the support page."+String.valueOf(userId);

    }
}

