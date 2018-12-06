package fr.soat.cleancoders.highlevel;

import fr.soat.cleancoders.MessageSender;
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
                    String message = emailFor(friend);
                    final String contact = friend.getEmailAdress();
                    messenger.send(friend, message);
                });
    }

    private String emailFor(Friend friend){
        return String.format("Happy birthday, dear %s!", friend.getName());

    }

    public static class Friend {
        private final String name;
        private final String emailAdress;
        private final String phoneNumber;

        public Friend(String name, String email, String phoneNumber) {
            this.name = name;
            this.emailAdress = email;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getEmailAdress() {
            return emailAdress;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
}
