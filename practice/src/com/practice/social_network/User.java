package com.practice.social_network;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<User> subscriptions;

    public User(String username) {
        this.username = username;
        this.subscriptions = new ArrayList<>();
    }

    public void subscribe(User user) {
        this.subscriptions.add(user);
    }

    public boolean isSubscribed(User user) {
        return subscriptions.contains(user);
    }

    public boolean isFriend(User user) {
        return isSubscribed(user) && subscriptions.contains(user); //different from example
    }
    public void sendMessage(User to, String text){
        MessageDatabase.addMessage(this, to, text); ///object who calls this method  = THIS, so he is a sender of a message
    }

    @Override
    public String toString() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }
}
