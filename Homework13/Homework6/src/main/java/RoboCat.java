import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class RoboCat extends Pet implements Serializable {

    @Override
    public void respond() {
        System.out.println("Hello");
    }

    public RoboCat() {
    }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public RoboCat(String nickname) {
        super(nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }
}
