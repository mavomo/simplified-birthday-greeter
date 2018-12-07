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
                    messenger.sendMessageToA(friend);
                });
    }
}
