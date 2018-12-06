package fr.soat.cleancoders;

import fr.soat.cleancoders.highlevel.BirthdayGreeter;

import java.time.LocalDate;

public class FriendBuilder {
    private String firstName = "John";
    private String lastName = "Doe";
    private LocalDate dateOfBirth = LocalDate.of(1980, 9, 10);
    private String email = "john.doe@foobar.com";
    private String phoneNumber = "06xxxxxx";

    public static FriendBuilder aFriend() {
        return new FriendBuilder();
    }

    public FriendBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public FriendBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    public FriendBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FriendBuilder withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public BirthdayGreeter.Friend build() {
        return new BirthdayGreeter.Friend(firstName, email, phoneNumber);
    }
}
