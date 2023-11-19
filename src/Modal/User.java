package Modal;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String last_name;
    private String email;
    private String sexe;

    public User(int id, String name, String last_name, String email, String sexe) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.sexe = sexe;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getSexe() {
        return sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(last_name, user.last_name) && Objects.equals(email, user.email) && Objects.equals(sexe, user.sexe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, last_name, email, sexe);
    }
}
