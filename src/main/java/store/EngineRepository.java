package store;

import model.Engine;
import org.hibernate.query.Query;

import java.util.List;

public class EngineRepository {

    private static final class Lazy {
        private static final EngineRepository INST = new EngineRepository();
    }
    public static EngineRepository instOf() {
        return EngineRepository.Lazy.INST;
    }


    public List<Engine> findAllEngine() {
        return Repository.tx(
                session -> session.createQuery("select e from Engine e", Engine.class).list()
        );
    }

    public Engine findEngineId(int ids) {
        return Repository.tx(session -> {
            Query<Engine> query = session.createQuery("select m from Engine m where m.id =: ids");
            query.setParameter("ids", ids);
            return query.uniqueResult();
        });
    }
}
