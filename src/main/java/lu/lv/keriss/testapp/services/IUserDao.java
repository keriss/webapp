package lu.lv.keriss.testapp.services;

import lu.lv.keriss.testapp.model.User;
import java.util.List;

public interface IUserDao {
    List<User> getAll();
    void updateUser(User user);
    void deleteUser(Long id);
    void addUser(User user);
    User findUserById(Long id);
}
