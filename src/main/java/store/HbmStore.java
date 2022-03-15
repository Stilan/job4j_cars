package store;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.function.Function;

public class HbmStore implements Store {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();


    private static final class Lazy {
        private static final Store INST = new HbmStore();
    }
    public static Store instOf() {
        return Lazy.INST;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAllItem() {
        return this.tx(
                session -> session.createQuery("from model.Item").list()
        );
    }

    @Override
    public Car findByCar(int id) {
        return this.tx(
                session ->
                        session.get(Car.class, id)
        );
    }

    @Override
    public void addItem(Item item) {
         this.tx(
                session -> {
                    session.save(item.getCar());
                    session.save(item);
                    return item;
                }
        );
    }

    @Override
    public List<Mark> findAllMark() {
        return this.tx(
                session -> session.createQuery("select m from Mark m", Mark.class).list()
        );
    }
    @Override
    public List<Body> findAllBody() {
        return this.tx(
                session -> session.createQuery("select b from Body b", Body.class).list()
        );
    }
    @Override
    public List<Engine> findAllEngine() {
        return this.tx(
                session -> session.createQuery("select e from Engine e", Engine.class).list()
        );
    }
    @Override
   public User findByNameUser(String name, String email) {
        return this.tx(
                session -> {
                    Query query = session.createQuery("from model.User where name = :nameUser and email = :emailUser");
                    query.setParameter("nameUser", name);
                    query.setParameter("emailUser", email);
                    return (User) query.uniqueResult();
                }
        );
    }

    @Override
    public User addUser(User user) {
        return this.tx(
                session -> {
                    session.save(user);
                    return user;
                }
        );
    }

}
