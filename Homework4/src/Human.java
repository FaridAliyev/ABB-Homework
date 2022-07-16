import java.util.Arrays;

public class Human {
    String name;
    String surname;
    int year;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;

    public Human() {
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public void greetPet() {
        System.out.printf("Hello, %s", pet.nickname);
        System.out.println();
    }

    public void describePet() {
        System.out.printf("I have a %s, he is %d years old, he is " + (pet.trickLevel >= 50 ? "very sly" : "almost not sly"), pet.species, pet.age);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", mother=" + (mother != null ? mother.name + " " + mother.surname : null ) +
                ", father=" + (father != null ? father.name + " " + father.surname : null ) +
                ", pet=" + pet +
                '}';
    }
}
