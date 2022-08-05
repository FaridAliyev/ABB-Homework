enum Species {
    CAT,
    DOG
}

enum DayOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Lorem", "Lorem", 1983);
        System.out.println(mother);
        Human father = new Human("Lorem", "Lorem", 1979);
        System.out.println(father);
        Pet pet = new Pet(Species.DOG, "doge", 2, 34, new String[]{"eat", "drink", "sleep"});
        System.out.println(pet);
        Human child1 = new Human("Lorem", "Lorem", 2003, 99, new String[][]{{DayOfWeek.MONDAY.name(), "study"}});
        Human child2 = new Human("Lorem", "Lorem", 2004, 120, new String[][]{{DayOfWeek.MONDAY.name(), "study"}});
        Human human;
        for (int i = 0; i < 150684; i++) {
            human = new Human("Lorem", "Lorem", 2003, 99, new String[][]{{DayOfWeek.MONDAY.name(), "study"}});
        }
        System.out.println(child1);
        pet.eat();
        pet.respond();
        pet.foul();
        Family family = new Family(mother, father);
        family.setPet(pet);
        family.addChild(child1);
        family.addChild(child2);
        System.out.println(family.countFamily());
        System.out.println(family);
        System.out.println(child1.getFamily());
        family.deleteChild(child1);
        System.out.println(family.countFamily());
        System.out.println(family);
        System.out.println(child1.getFamily());
    }
}
