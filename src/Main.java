import business.concretes.UserManager;
import core.concretes.EmailManagerAdapter;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.HibernateUserManager;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        User user1 = new User("dfsd","sdfsd","sdf@gmail.com","1234567");
        User user2 = new User("sdfs","sdfsd","sdf@gmail.com","234567");
        User user3 = new User("sdf","sdf","sdf@gmail.com","0987654098");
        User user4 = new User("sfs","sdf","sdf@gmail.com","1234567");
        User user5 = new User("sdfs","sdf","gfghfh@gmail.com","868jguu");

        UserManager userManager = new UserManager(new HibernateUserManager(), new EmailManagerAdapter());

        userManager.Register(user1,"link");
        //System.out.println("********");
        //userManager.Login("eminebozkurtbe@gmail.com","1234567");
        //System.out.println("********");
        //userManager.Register(user3,"link");
        //userManager.Register(user5,"link");
        userManager.Login("sfdsw@gmail.com","1234567");


    }
}
