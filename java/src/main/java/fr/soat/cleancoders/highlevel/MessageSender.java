package fr.soat.cleancoders.highlevel;

public abstract class MessageSender {

    void send(Friend aFriend) {
        final String message = buildMessageFor(aFriend.getName());

        sendContentTo(aFriend, message);
    }

    protected abstract void sendContentTo(Friend aFriend, String message);

    protected abstract String buildMessageFor(String name);


}
