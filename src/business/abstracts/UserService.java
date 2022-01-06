package business.abstracts;

import entities.concretes.User;

public interface UserService {
    boolean checkName(User user);
    boolean checkLastname(User user);
    boolean checkEmailFormat(User user);
    boolean checkEmailNotUsedBefore(User user);
    boolean isEmailValid(User user);
    boolean checkPassword(User user);
    void Register(User user, String link);
    void Login(String emaill, String passwordd);
}
