import java.util.Map;

final public class Man extends Human {
    public Man() {
    }

    public Man(String name, String surname, int year, int iq, Map<String, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public void repairCar(){
        System.out.println("Car is repaired");
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello from man, %s\n", this.getFamily().getPets());
    }
}
