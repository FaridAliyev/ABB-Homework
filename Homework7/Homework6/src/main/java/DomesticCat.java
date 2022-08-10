public class DomesticCat extends Pet{
    @Override
    public void respond() {
        System.out.println("Meow");
    }

    public DomesticCat() {
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public DomesticCat(String nickname) {
        super(nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }
}
