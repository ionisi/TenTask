package mine.SpringApp.service;



import mine.SpringApp.repositories.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> getByEmail(String email);
    User getById(int id);
    void save(User user);
    void update(int id, User user);
    void delete(int id);
}
