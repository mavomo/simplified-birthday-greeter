package fr.soat.cleancoders.details;


import fr.soat.cleancoders.highlevel.Friend;
import fr.soat.cleancoders.highlevel.MessageSender;

public class EmailSender extends MessageSender {
    @Override
    protected void sendContentTo(Friend aFriend) {
        System.out.print("To:" + aFriend.getEmailAdress() + ", Subject: Happy birthday!" + ", Message: "
                + buildMessageFor(aFriend.getName()));
    }

    @Override
    protected String buildMessageFor(String name) {
        return String.format("Happy birthday, dear %s!", name);
    }
}
