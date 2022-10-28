package web.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager manager;


    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = manager.createQuery("select us from User us").getResultList();
        return users;
    }
}
