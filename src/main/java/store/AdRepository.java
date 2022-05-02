package store;

import model.*;

import java.util.List;

public class AdRepository {

    private static final class Lazy {
        private static final AdRepository INST = new AdRepository();
    }
    public static AdRepository instOf() {
        return Lazy.INST;
    }


    public List<Ads> findAllItem() {
        return Repository.tx(
                session -> session.createQuery("from model.Ads").list()
        );
    }

    public void addItem(Ads item) {
        Repository.tx(
                session -> {
                    session.save(item.getCar());
                    session.save(item);
                    return item;
                }
        );
    }

}
