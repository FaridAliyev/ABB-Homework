import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Fish extends Pet implements Serializable {

    @Override
    public void respond() {
        System.out.println("Fish sound");
    }

    public Fish() {
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Fish(String nickname) {
        super(nickname);
    }
}
