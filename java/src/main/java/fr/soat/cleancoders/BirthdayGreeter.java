package fr.soat.cleancoders;

import java.time.MonthDay;

import static java.time.MonthDay.*;

public class BirthdayGreeter {
    private final FriendRepository friendRepository;

    public BirthdayGreeter(FriendRepository employeeRepository) {
        this.friendRepository = employeeRepository;
    }

    public void sendGreetings() {
        friendRepository.findFriendsBornOn(now())
                .forEach(friend -> {
                    String message = emailFor(friend);
                    new EmailSender().send(friend.getEmailAdress(), message);
                });
    }

    public String emailFor(Friend friend){
        return String.format("Happy birthday, dear %s!", friend.getName());

    }

}
