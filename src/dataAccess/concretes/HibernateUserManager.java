package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserManager implements UserDao {

    List<User> list = new ArrayList<User>();

    @Override
    public void add(User user) {
        System.out.println("Uyelik tamamlandi. " + user.getEmail());
        list.add(user);
    }

    @Override
    public List<User> getAll() {
        return list;
    }
}
