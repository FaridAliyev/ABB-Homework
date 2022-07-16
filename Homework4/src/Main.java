public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Lorem", "Lorem", 1983);
        System.out.println(mother);
        Human father = new Human("Lorem", "Lorem", 1979);
        System.out.println(father);
        Pet pet = new Pet("dog", "doge", 2, 34, new String[]{"eat", "drink", "sleep"});
        System.out.println(pet);
        Human child = new Human("Lorem", "Lorem", 2003, 99, pet, mother, father, new String[][]{{"monday", "study"}});
        System.out.println(child);
        child.greetPet();
        child.describePet();
        pet.eat();
        pet.respond();
        pet.foul();
    }
}
