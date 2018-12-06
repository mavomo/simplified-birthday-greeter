package fr.soat.cleancoders.highlevel;

import fr.soat.cleancoders.FriendRepository;

import static java.time.MonthDay.now;

public class BirthdayGreeter {
    private final FriendRepository friendRepository;

    public BirthdayGreeter(FriendRepository employeeRepository) {
        this.friendRepository = employeeRepository;
    }

    public void sendGreetings(MessageSender messenger) {
        friendRepository.findFriendsBornOn(now())
                .forEach(friend -> {
                    String message = messageForA(friend);
                    messenger.send(friend, message);
                });
    }

    private String messageForA(Friend friend){
        return String.format("Happy birthday, dear %s!", friend.getName());

    }

}
