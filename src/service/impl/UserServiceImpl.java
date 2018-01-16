package service.impl;

import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/11
 * Time: 14:13
 */
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao;

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public int Count() {
        return userDao.Count();
    }

    @Override
    public List<User> showRecords() {
        List<User> list = userDao.showRecords();
        return list;
    }

    @Override
    public User findRecordById(long id) {
        User user = userDao.findRecordById(id);
        return user;
    }

    @Override
    public boolean isUserExist(String UserName) {
        return userDao.isUserInfoExist(UserName);
    }

    @Override
    public boolean Login(String UserName, String Password) {
        return userDao.isUserInfoExist(UserName,Password);
    }

    @Override
    public boolean Register(String UserName, String Password) {
        User userInfo = null;
        userInfo.setUsername(UserName);
        userInfo.setPassword(Password);
        return doInsert(userInfo);
    }

    @Override
    public boolean doUpdate(User userInfo) {
        return userDao.update(userInfo);
    }

    @Override
    public boolean doInsert(User userInfo) {
        return userDao.insert(userInfo);
    }

    @Override
    public boolean doDelete(User userInfo) {
        return userDao.delete(userInfo);
    }
}
