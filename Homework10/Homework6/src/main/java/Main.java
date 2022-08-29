import java.util.*;

public class Main {
    public static void main(String[] args) {
        FamilyController familyController = new FamilyController();
        Woman mother = new Woman("Lorem", "Lorem", "01/01/1983");
        Man father = new Man("Lorem", "Lorem", "01/01/1979");
        Human child1 = new Human("Lorem", "Lorem", "01/01/2003", 99, Map.of(
                DayOfWeek.MONDAY, "study"
        ));
        Human child2 = new Human("Lorem", "Lorem", "01/01/2004", 120, Map.of(
                DayOfWeek.MONDAY, "study"
        ));
        Dog dog = new Dog("doge", 2, 34, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        Family family = familyController.createNewFamily(mother, father);
        System.out.println(familyController.getAllFamilies());
        familyController.getFamiliesBiggerThan(1);
        familyController.getFamiliesLessThan(3);
        System.out.println(familyController.countFamiliesWithMemberNumber(2));
        familyController.bornChild(family, "Male", "Female");
        familyController.adoptChild(family, child1);
        familyController.deleteAllChildrenOlderThan(10);
        System.out.println(familyController.count());
        System.out.println(familyController.getFamilyById(0));
        familyController.addPet(0, dog);
        System.out.println(familyController.getPets(0));
        familyController.displayAllFamilies();
        familyController.deleteFamilyByIndex(0);

        System.out.println(father.describeAge());
    }
}
