import java.util.List;
import java.util.Set;

public class Dog extends Pet{
    @Override
    public void respond() {
        System.out.println("Woof");
    }

    public Dog() {
    }

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Dog(String nickname) {
        super(nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }
}
