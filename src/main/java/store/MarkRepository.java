package store;

import model.Mark;
import org.hibernate.query.Query;

import java.util.List;

public class MarkRepository {

    private static final class Lazy {
        private static final MarkRepository INST = new MarkRepository();
    }
    public static MarkRepository instOf() {
        return MarkRepository.Lazy.INST;
    }

    public Mark findMarkId(int ids) {
        return Repository.tx(session -> {
            Query<Mark> query = session.createQuery("select m from Mark m where m.id =: ids");
            query.setParameter("ids", ids);
            return query.uniqueResult();
        });
    }

    public List<Mark> findAllMark() {
        return Repository.tx(
                session -> session.createQuery("select m from Mark m", Mark.class).list()
        );
    }
}
