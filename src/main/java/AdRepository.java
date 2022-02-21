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

    public List<Item> lastDayAnnouncements() {
        Session session = sf.openSession();
        session.beginTransaction();
        List list = session.createQuery("select distinct it from Item it "
                        + "join fetch it.car c "
                        + "join fetch c.mark m "
                        + "join fetch c.body b"
                        + " join fetch c.engine e"
                        + " join fetch c.drivers d"
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
                + " join fetch c.drivers d"
                + " where c.photo <> null ", Item.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public  List<Item> searchByBrand(String name) {
        Session session = sf.openSession();
        session.beginTransaction();
        List list = session.createQuery(
                "select distinct it from Item it "
                        + "join fetch it.car c "
                        + "join fetch c.mark m "
                        + "join fetch c.body b"
                        + " join fetch c.engine e"
                        + " join fetch c.drivers d"
                        + " where m.name = :nameMark ", Item.class
        ).setParameter("nameMark", name).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

}
