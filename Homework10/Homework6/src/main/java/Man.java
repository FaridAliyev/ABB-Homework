import java.util.Map;

final public class Man extends Human {
    public Man() {
    }

    public Man(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Man(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    public void repairCar(){
        System.out.println("Car is repaired");
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello from man, %s\n", this.getFamily().getPets());
    }
}
