package com.example.mefit.Settings;

public class ChatsModal {

    private String Message;
    private String sender;

    public ChatsModal(String message, String sender) {
        Message = message;
        this.sender = sender;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
