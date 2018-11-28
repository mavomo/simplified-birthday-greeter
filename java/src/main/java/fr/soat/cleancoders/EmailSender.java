package fr.soat.cleancoders;


public class EmailSender{

    public void send(String emailAdress, String message) {
        System.out.print("To:" + emailAdress + ", Subject: Happy birthday!" + ", Message: " + message);
    }
}
