package fr.soat.cleancoders.details;

import fr.soat.cleancoders.highlevel.Friend;
import fr.soat.cleancoders.highlevel.MessageSender;

public class SmsSender implements MessageSender {
    @Override
    public void send(Friend aFriend, String message) {
        System.out.print("To:" + aFriend.getPhoneNumber() + ", Subject: Happy birthday!" + ", Message: " + message);
    }
}
