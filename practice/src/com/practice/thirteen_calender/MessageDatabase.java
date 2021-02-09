package com.practice.thirteen_calender;

import java.util.ArrayList;
import java.util.List;

public class MessageDatabase {
    static List<Message> allMessages = new ArrayList<>();

    public static void addMessage(User sender, User reciever, String text) {
        allMessages.add(new Message(sender, reciever, text)); //new object message is created and added to list allMessages
    }

    public static void showDialog(User user1, User user2) {
        for (Message message : allMessages) { //for each element message belonging to class Message we search inside allMeasages
/*            if(message.getSender().getUsername().equals(user1.getUsername()) && message.getReciever().getUsername().equals(user2.getUsername())){
                System.out.println(message.getSender()+": " +message.getText());
            }
            if(message.getSender().getUsername().equals(user2.getUsername()) && message.getReciever().getUsername().equals(user1.getUsername())){
                System.out.println(message.getSender()+": "+message.getText());
            }*/ //my solution is also working
            if ((message.getSender() == user1 && message.getReciever() == user2) || (message.getSender() == user2 && message.getReciever() == user1)) {
                System.out.println(message.getSender() + ": " + message.getText());
            }
        }

    }
}

