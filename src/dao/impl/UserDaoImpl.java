package dao.impl;

import dao.UserDao;
import entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/11
 * Time: 14:00
 */
public class UserDaoImpl implements UserDao{
    @Override
    public List<User> showRecords() {
        return null;
    }

    @Override
    public int Count() {
        return 0;
    }

    @Override
    public User findRecordById(long id) {
        return null;
    }

    @Override
    public User findRecordByUserNamePassword(String UserName, String Password) {
        return null;
    }

    @Override
    public boolean isUserInfoExist(String UserName) {
        return false;
    }

    @Override
    public boolean isUserInfoExist(String UserName, String Password) {
        return false;
    }

    @Override
    public boolean update(User userInfo) {
        return false;
    }

    @Override
    public boolean insert(User userInfo) {
        return false;
    }

    @Override
    public boolean delete(User userInfo) {
        return false;
    }
}
