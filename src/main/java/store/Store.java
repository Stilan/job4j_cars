package store;

import java.util.List;

import model.*;

public interface Store {

    List<Ads> findAllItem();
    Car findByCar(int id);
    void addItem(Ads item);
    List<Mark> findAllMark();
    List<Body> findAllBody();
    List<Engine> findAllEngine();
    User findByNameUser(String name, String email, String passwordUser);
    User addUser(User user);
}
