package fr.soat.cleancoders.highlevel;

public abstract class MessageSender {

    void send(Friend aFriend) {
        buildMessageFor(aFriend.getName());
        sendContentTo(aFriend);
    }

    protected abstract void sendContentTo(Friend aFriend);

    protected abstract String buildMessageFor(String name);


}
