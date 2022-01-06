package core.abstracts;

import entities.concretes.User;

public interface EmailService {
    boolean sendLink(String link);
    void sendEmail(String mail);

}
