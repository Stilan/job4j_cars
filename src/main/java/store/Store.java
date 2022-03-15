package store;

import java.util.Collection;
import java.util.List;

import model.*;

public interface Store {

    List<Item> findAllItem();
    Car findByCar(int id);
    void addItem(Item item);
    List<Mark> findAllMark();
    List<Body> findAllBody();
    List<Engine> findAllEngine();
    User findByNameUser(String name, String email);
    User addUser(User user);
}
