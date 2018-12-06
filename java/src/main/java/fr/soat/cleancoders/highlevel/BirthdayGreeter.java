package fr.soat.cleancoders.highlevel;

import fr.soat.cleancoders.EmailSender;
import fr.soat.cleancoders.Friend;
import fr.soat.cleancoders.FriendRepository;

import static java.time.MonthDay.now;

public class BirthdayGreeter {
    private final FriendRepository friendRepository;

    public BirthdayGreeter(FriendRepository employeeRepository) {
        this.friendRepository = employeeRepository;
    }

    public void sendGreetings() {
        friendRepository.findFriendsBornOn(now())
                .forEach(friend -> {
                    String message = emailFor(friend);
                    final String contact = friend.getEmailAdress();
                    new EmailSender().send(contact, message);
                });
    }

    private String emailFor(Friend friend){
        return String.format("Happy birthday, dear %s!", friend.getName());

    }

}
