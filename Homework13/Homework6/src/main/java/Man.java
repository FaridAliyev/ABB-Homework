import java.io.Serializable;
import java.util.Map;

final public class Man extends Human implements Serializable {
    public Man() {
    }

    public Man(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Man(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public void repairCar(){
        System.out.println("Car is repaired");
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello from man, %s\n", this.getFamily().getPets());
    }
}
