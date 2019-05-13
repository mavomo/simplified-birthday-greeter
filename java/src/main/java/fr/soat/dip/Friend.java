package fr.soat.dip;

public class Friend {
    private final String name;
    private final String contact;

    Friend(String name, String email) {
        this.name = name;
        this.contact = email;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}
