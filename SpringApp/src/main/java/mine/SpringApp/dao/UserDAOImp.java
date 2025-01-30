package mine.SpringApp.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mine.SpringApp.repositories.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    @Transactional
    public Optional<User> getByEmail(String email) {
        return entityManager.createQuery("SELECT p FROM User p WHERE p.email = :email", User.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }

    @Transactional(readOnly = true)
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(int id, User user) {
        User existingUser = entityManager.find(User.class, id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setAge(user.getAge());
            existingUser.setEmail(user.getEmail());
        }
    }

    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

}
