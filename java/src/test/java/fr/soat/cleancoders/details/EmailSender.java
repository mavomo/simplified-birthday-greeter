package fr.soat.cleancoders.details;


import fr.soat.cleancoders.highlevel.Friend;
import fr.soat.cleancoders.highlevel.MessageSender;

public class EmailSender extends MessageSender {
    @Override
    protected void sendContentTo(Friend aFriend, String message) {
        System.out.print("To:" + aFriend.getEmailAdress() + ", Subject: Happy birthday!" + ", Message: "
                + message);
    }

    @Override
    protected String buildMessageFor(String name) {
        return String.format("Happy birthday, dear %s!", name);
    }
}
