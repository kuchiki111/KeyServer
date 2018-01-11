package service;

import entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/11
 * Time: 14:12
 */
public interface UserService {
    int Count();
    List<User> showRecords();
    User findRecordById(long id);

    boolean isUserExist(String UserName);
    boolean Login(String UserName, String Password);
    boolean Register(String UserName, String Password);

    boolean doUpdate(User userInfo);
    boolean doInsert(User userInfo);
    boolean doDelete(User userInfo);
}
