package Modal;

import java.util.Objects;

public class Author {
    private int id;
    private String name ;
    private String last_name;
    private String sexe;

    public Author(int id, String name, String last_name, String sexe) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.sexe = sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(name, author.name) && Objects.equals(last_name, author.last_name) && Objects.equals(sexe, author.sexe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, last_name, sexe);
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
