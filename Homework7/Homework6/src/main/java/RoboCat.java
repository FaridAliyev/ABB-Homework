public class RoboCat extends Pet {

    @Override
    public void respond() {
        System.out.println("Hello");
    }

    public RoboCat() {
    }

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public RoboCat(String nickname) {
        super(nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }
}
