package dao;

import entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/11
 * Time: 14:00
 */
public interface UserDao {
    List<User> showRecords();

    int Count();

    User findRecordById(long id);
    User findRecordByUserNamePassword(String UserName, String Password);

    boolean isUserInfoExist(String UserName);
    boolean isUserInfoExist(String UserName, String Password);

    boolean update(User userInfo);
    boolean insert(User userInfo);
    boolean delete(User userInfo);
}
