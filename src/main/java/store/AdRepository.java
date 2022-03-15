package store;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class AdRepository implements Store {


    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    private static final class Lazy {
        private static final Store INST = new AdRepository();
    }

    public static Store instOf() {
        return Lazy.INST;
    }
/**
    public List<Item> lastDayAnnouncements() {
        Session session = sf.openSession();
        session.beginTransaction();
        List list = session.createQuery("select distinct it from Item it "
                        + "join fetch it.car c "
                        + "join fetch c.mark m "
                        + "join fetch c.body b"
                        + " join fetch c.engine e"
                        + " where it.created  > current_date() - 1", Item.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public  List<Item> adsWithPhoto() {
        Session session = sf.openSession();
        session.beginTransaction();
        List list = session.createQuery("select distinct it from Item it "
                + "join fetch it.car c "
                + "join fetch c.mark m "
                + "join fetch c.body b"
                + " join fetch c.engine e"
                + " where c.photo <> null ", Item.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public List<Item> searchByBrand(String name) {
        Session session = sf.openSession();
        session.beginTransaction();
        List list = session.createQuery(
                "select distinct it from Item it "
                        + "join fetch it.car c "
                        + "join fetch c.mark m "
                        + "join fetch c.body b"
                        + " join fetch c.engine e"
                        + " where m.name = :nameMark ", Item.class
        ).setParameter("nameMark", name).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
**/
    public List<Item> findAllItem() {
        Session session = sf.openSession();
        session.beginTransaction();
        List list = session.createQuery(
                "select distinct it from Item it "
                        + "join fetch it.car c "
                        + "join fetch c.mark m "
                        + "join fetch c.body b"
                        + " join fetch c.engine e").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
   public Car findByCar(int id) {
       Session session = sf.openSession();
       session.beginTransaction();
       Car car = session.createQuery(
               "select distinct it from Car it "
                       + "join fetch it.mark m "
                       + "join fetch it.body b"
                       + " join fetch it.engine e"
                      + " where it.id = :id ", Car.class).setParameter("id", id).uniqueResult();
       session.getTransaction().commit();
       session.close();
       return car;
   }

    @Override
    public void addItem(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("insert into Item (description, created, car) "
                        + "select distinct it "
                        + "from Item it"
                        + " join fetch it.car c"
                        + " join fetch c.mark m "
                        + " join fetch c.body b"
                        + " join fetch c.engine e").uniqueResult();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Mark> findAllMark() {
        Session session = sf.openSession();
        session.beginTransaction();
        List list = session.createQuery(
                "select distinct m from Mark m ").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Body> findAllBody() {
        return null;
    }

    @Override
    public List<Engine> findAllEngine() {
        return null;
    }

    @Override
    public User findByNameUser(String name, String email) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }


}
