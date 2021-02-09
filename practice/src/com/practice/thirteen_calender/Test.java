package com.practice.thirteen_calender;

public class Test {
    public static void main(String[] args) {
        User u1 = new User("Mark");
        User u2 = new User("Anton");
        User u3 = new User("Artjom");

        Message mes = new Message(u1, u2, "Hello");
        System.out.println(mes);

        u1.subscribe(u2);
        u1.subscribe(u3);
        u2.subscribe(u1);

        System.out.println(u1.isSubscribed(u3));
        System.out.println(u1.isSubscribed(u2));
        System.out.println(u1.isFriend(u2));

        u1.sendMessage(u2, "hello");
        u1.sendMessage(u3,"whatsup?");
        u1.sendMessage(u2, "u here?");
        u2.sendMessage(u1, "hi");
        u1.sendMessage(u2, "how are you?");
        u2.sendMessage(u1, "im busy..");

        MessageDatabase.showDialog(u1, u2);

    }
}
