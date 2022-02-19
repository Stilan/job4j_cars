import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmRun {
    public static void main(String[] args) {
        List<Item> rsl = null;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
/**
            Driver driver1 = Driver.of("Водитель1");
            Driver driver2 = Driver.of("Водитель2");
            Driver driver3 = Driver.of("Водитель3");
            Driver driver4 = Driver.of("Водитель4");

            session.persist(driver1);
            session.persist(driver2);
            session.persist(driver3);
            session.persist(driver4);

            Engine engine1 = Engine.of("V8");
            Engine engine2 = Engine.of("V6");

            session.persist(engine1);
            session.persist(engine2);

            Body body1 = Body.of("Седан");
            Body body2 = Body.of("Универсал");

            session.persist(body1);
            session.persist(body2);

            Mark mark1 = Mark.of("Лада");
            Mark mark2 = Mark.of("kia");

            session.persist(mark1);
            session.persist(mark2);

            Car car1 = Car.of();

            car1.getDrivers().add(driver1);
            car1.getDrivers().add(driver2);
            car1.setEngine(engine1);
            car1.setBody(body1);
            car1.setMark(mark1);

            Car car2 = Car.of();

            car2.getDrivers().add(driver3);
            car2.getDrivers().add(driver4);
            car2.setEngine(engine2);
            car2.setBody(body2);
            car2.setMark(mark2);

            session.persist(car1);
            session.persist(car2);

            Item item = Item.of("Серый седан");
            item.setCar(car1);

            session.persist(item);
**/

            rsl = AdRepository.instOf().lastDayAnnouncements();

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        System.out.println(rsl);
    }
}
