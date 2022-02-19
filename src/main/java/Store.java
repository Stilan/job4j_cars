import java.util.List;

public interface Store {

    List<Item> lastDayAnnouncements();
    List adsWithPhoto();
    List<Item> searchByBrand(String name);
}
