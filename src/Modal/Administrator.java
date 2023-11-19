package Modal;

import java.util.Objects;

public class Administrator extends User {
    private String role;
    private String userName;
    private String password;

    public Administrator(int id, String name, String last_name, String email, String sexe,String role, String userName, String password) {
        super(id, name, last_name, email, sexe);
        this.role = role;
        this.userName = userName;
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(role, that.role) && Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, userName, password);
    }
}
