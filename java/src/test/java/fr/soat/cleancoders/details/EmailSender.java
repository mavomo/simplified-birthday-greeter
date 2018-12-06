package fr.soat.cleancoders.details;


import fr.soat.cleancoders.highlevel.Friend;
import fr.soat.cleancoders.highlevel.MessageSender;

public class EmailSender implements MessageSender {

    @Override
    public void send(Friend aFriend, String message) {
        System.out.print("To:" + aFriend.getEmailAdress() + ", Subject: Happy birthday!" + ", Message: " + message);
    }
}
