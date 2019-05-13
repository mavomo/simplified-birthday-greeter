package fr.soat.dip;


public class EmailSender {

    public void send(String emailAddress, String message) {
        System.out.print("To:" + emailAddress + ", Subject: Happy birthday!" + ", Message: " + message);
    }

}
