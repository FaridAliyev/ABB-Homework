import java.io.Serializable;
import java.util.Map;

final public class Woman extends Human implements Serializable {
    public Woman() {
    }

    public Woman(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Woman(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public void makeup(){
        System.out.println("Makeup is done");
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello from woman, %s\n", this.getFamily().getPets());
    }
}
