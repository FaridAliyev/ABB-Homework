public class Fish extends Pet{

    @Override
    public void respond() {
        System.out.println("Fish sound");
    }

    public Fish() {
    }

    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Fish(String nickname) {
        super(nickname);
    }
}
