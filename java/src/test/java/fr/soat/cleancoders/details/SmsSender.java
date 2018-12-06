package fr.soat.cleancoders.details;

import fr.soat.cleancoders.highlevel.Friend;
import fr.soat.cleancoders.highlevel.MessageSender;

public class SmsSender extends MessageSender {
    @Override
    protected void sendContentTo(Friend aFriend, String message) {
        System.out.print("To:" + aFriend.getPhoneNumber() + ", " + message);
    }

    @Override
    protected String buildMessageFor(String name) {
        return String.format("Happy birthday, my dear %s!", name);
    }
}
