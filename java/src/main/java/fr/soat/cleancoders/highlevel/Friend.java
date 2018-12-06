package fr.soat.cleancoders.highlevel;

public class Friend {
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
