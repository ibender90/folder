package com.practice.social_network;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private User sender;
    private User reciever;
    private String text;
    private Date messageDate;
    DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss");



    public Message(User sender, User reciever, String text) {
        this.sender = sender;
        this.reciever = reciever;
        this.text = text;
        this.messageDate = new Date();

    }

    @Override
    public String toString() {
        return "Message{" +
                "From " + sender.getUsername() +
                ", to " + reciever.getUsername() +
                ", text='" + text + '\'' +
                ", ON " + dateFormat.format(messageDate) +
                '}';
    }

    public User getSender() {
        return sender;
    }

    public User getReciever() {
        return reciever;
    }

    public String getText() {
        return text;
    }

    public Date getMessageDate() {
        return messageDate;
    }
}
