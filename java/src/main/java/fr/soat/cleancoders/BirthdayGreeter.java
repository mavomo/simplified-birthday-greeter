package fr.soat.cleancoders;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final FriendRepository friendRepository;

    public BirthdayGreeter(FriendRepository employeeRepository) {
        this.friendRepository = employeeRepository;
    }

    void sendGreetings() {
        friendRepository.findFriendsBornOn(MonthDay.now())
                .forEach(friend -> {
                    String message = emailFor(friend);
                    new EmailSender().send(friend.getContact(), message);
                });
    }

    private String emailFor(Friend friend) {
        return String.format("Happy birthday, dear %s!", friend.getName());
    }
}
