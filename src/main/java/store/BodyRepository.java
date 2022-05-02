package store;

import model.Body;
import org.hibernate.query.Query;

import java.util.List;

public class BodyRepository {

    private static final class Lazy {
        private static final BodyRepository INST = new BodyRepository();
    }
    public static BodyRepository instOf() {
        return BodyRepository.Lazy.INST;
    }
    public List<Body> findAllBody() {
        return Repository.tx(
                session -> session.createQuery("select b from Body b", Body.class).list()
        );
    }

    public Body findBodyId(int ids) {
        return Repository.tx(session -> {
            Query<Body> query = session.createQuery("select m from Body m where m.id =: ids");
            query.setParameter("ids", ids);
            return query.uniqueResult();
        });
    }
}
