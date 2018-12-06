package fr.soat.cleancoders.details;


import fr.soat.cleancoders.highlevel.Friend;
import fr.soat.cleancoders.highlevel.MessageSender;

public class EmailSender implements MessageSender {

    @Override
    public void send(Friend aFriend) {
        System.out.print("To:" + aFriend.getEmailAdress() + ", Subject: Happy birthday!" + ", Message: "
                + messageForA(aFriend.getName()));
    }

    private String messageForA(String name) {
        return String.format("Happy birthday, dear %s!", name);
    }
}
