package business.concretes;

import business.abstracts.UserService;
import core.abstracts.EmailService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {

    private UserDao userDao;
    private EmailService emailService;

    public UserManager(UserDao userDao, EmailService emailService) {
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @Override
    public boolean checkName(User user) {
        if(user.getFirstName().length()<=2){
          return false;
        }
        return true;
    }

    @Override
    public boolean checkLastname(User user) {
        if(user.getLastName().length()<=2){
            return false;
        }
        return true;
    }

    @Override
    public boolean checkEmailFormat(User user) {
        String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = user.getEmail();

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

    @Override
    public boolean checkEmailNotUsedBefore(User user) {
        for(User check : userDao.getAll()){
            if(check.getEmail().equals(user.getEmail())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmailValid(User user) {
        if(!checkEmailFormat(user)){
            return false;
        }
        return true;
    }

    @Override
    public boolean checkPassword(User user) {
        if(user.getPassword().length()<6){
            return  false;
        }
        return true;
    }

    @Override
    public void Register(User user, String link) {
        if(checkName(user) && checkLastname(user) && checkEmailFormat(user) && checkEmailNotUsedBefore(user) && isEmailValid(user) && checkPassword(user)){
            if(emailService.sendLink(link)){
                System.out.println("Girilen bilgiler dogrudur. Doğrulama linkine tiklanmistir: " + user.getEmail());
                emailService.sendEmail(user.getEmail());
                userDao.add(user);
                return;
            }
            else{
                System.out.println("Dogrulama linkine tiklayiniz.");
                return;
            }
        }
            System.out.println("Lütfen bilgileri doğru formatta giriniz.");
        return;
    }

    @Override
    public void Login(String emaill, String passwordd) {
        for(User user : userDao.getAll()){
            if(emaill.equals(user.getEmail()) && passwordd.equals(user.getPassword())){
                System.out.println("Giris basarili: " + emaill);
                return;
            }
            else{
                System.out.println("Giris basarisiz.");
            }
        }
    }
}
