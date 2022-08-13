import java.util.Map;

final public class Woman extends Human {
    public Woman() {
    }

    public Woman(String name, String surname, int year, int iq, Map<String, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public void makeup(){
        System.out.println("Makeup is done");
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello from woman, %s\n", this.getFamily().getPets());
    }
}
