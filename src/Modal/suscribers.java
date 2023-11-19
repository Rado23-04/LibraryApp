package Modal;

import java.util.Objects;

public class suscribers extends User{
    private String number;


    public suscribers(int id, String name, String last_name, String email, String sexe, String number) {
        super(id, name, last_name, email, sexe);
        this.number= number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        suscribers suscribers = (suscribers) o;
        return Objects.equals(number, suscribers.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }
}
