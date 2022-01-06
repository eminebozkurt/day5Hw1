package core.concretes;

import core.abstracts.EmailService;
import entities.concretes.User;

public class EmailManagerAdapter implements EmailService {
    @Override
    public boolean sendLink(String link) {
        String baseLink = "link";
        if(!link.equals(baseLink)) {
            return false;
        }
        return true;
    }

    @Override
    public void sendEmail(String mail) {
        GoogleMailManager googleMailManager = new GoogleMailManager();
        googleMailManager.sendGoogleMail(mail);
    }
}
