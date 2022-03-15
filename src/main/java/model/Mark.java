package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Mark(String name) {
        this.name = name;
    }

    public Mark(int id) {
        this.id = id;
    }

    public Mark() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mark mark = (Mark) o;
        return id == mark.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Mark{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
