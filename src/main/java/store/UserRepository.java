package store;

import model.User;
import org.hibernate.query.Query;

public class UserRepository {

    private static final class Lazy {
        private static final UserRepository INST = new UserRepository();
    }
    public static UserRepository instOf() {
        return UserRepository.Lazy.INST;
    }

    public User findByNameUser(String name, String email, String password) {
        return Repository.tx(
                session -> {
                    Query query = session.createQuery(
                            "from model.User where name = :nameUser and email = :emailUser and password = :passwordUser");
                    query.setParameter("nameUser", name);
                    query.setParameter("emailUser", email);
                    query.setParameter("passwordUser", password);
                    return (User) query.uniqueResult();
                }
        );
    }

    public User addUser(User user) {
        return Repository.tx(
                session -> {
                    session.save(user);
                    return user;
                }
        );
    }
}
