import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyServiceTest {
    FamilyController familyController = new FamilyController();
    Woman mother = new Woman("Lorem", "Lorem", "01/01/1983");
    Man father = new Man("Lorem", "Lorem", "01/01/1979");
    Human child1 = new Human("Lorem", "Lorem", "01/01/2003", 99, Map.of(
            DayOfWeek.MONDAY, "study"
    ));
    Human child2 = new Human("Lorem", "Lorem", "11/11/2004", 120, Map.of(
            DayOfWeek.MONDAY, "study"
    ));
    Dog dog = new Dog("doge", 2, 34, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));

    @Test
    public void testGetAllFamilies() {
        Family family = familyController.createNewFamily(mother, father);
        assertEquals(1, familyController.getAllFamilies().size());
    }

    @Test
    public void testGetFamiliesBiggerThan() {
        Family family = familyController.createNewFamily(mother, father);
        assertEquals(1, familyController.getFamiliesBiggerThan(1).size());
    }

    @Test
    public void testGetFamiliesLessThan() {
        Family family = familyController.createNewFamily(mother, father);
        assertEquals(0, familyController.getFamiliesLessThan(2).size());
    }

    @Test
    public void testCountFamiliesWithMemberNumber() {
        Family family = familyController.createNewFamily(mother, father);
        assertEquals(1, familyController.countFamiliesWithMemberNumber(2));
    }

    @Test
    public void testCreateNewFamily() {
        Family family = familyController.createNewFamily(mother, father);
        assertEquals(1, familyController.getAllFamilies().size());
    }

    @Test
    public void testDeleteFamilyByIndex() {
        Family family = familyController.createNewFamily(mother, father);
        familyController.deleteFamilyByIndex(0);
        assertEquals(0, familyController.getAllFamilies().size());
    }

    @Test
    public void testBornChild() {
        Family family = familyController.createNewFamily(mother, father);
        familyController.bornChild(family, "Male", "Female");
        assertEquals(3, familyController.getFamilyById(0).countFamily());
    }

    @Test
    public void testAdoptChild() {
        Family family = familyController.createNewFamily(mother, father);
        familyController.adoptChild(family, child1);
        assertEquals(3, familyController.getFamilyById(0).countFamily());
    }

    @Test
    public void testDeleteAllChildrenOlderThan() {
        Family family = familyController.createNewFamily(mother, father);
        familyController.bornChild(family, "Male", "Female");
        familyController.adoptChild(family, child1);
        familyController.deleteAllChildrenOlderThan(10);
        assertEquals(3, familyController.getFamilyById(0).countFamily());
    }

    @Test
    public void testCount() {
        Family family = familyController.createNewFamily(mother, father);
        assertEquals(1, familyController.count());
    }

    @Test
    public void testGetFamilyById() {
        Family family = familyController.createNewFamily(mother, father);
        assertEquals(family, familyController.getFamilyById(0));
    }

    @Test
    public void testAddPet() {
        Family family = familyController.createNewFamily(mother, father);
        familyController.addPet(0, dog);
        assertTrue(familyController.getPets(0).contains(dog));
    }

    @Test
    public void testGetPet() {
        Family family = familyController.createNewFamily(mother, father);
        familyController.addPet(0, dog);
        assertEquals(Optional.of(dog), familyController.getPets(0).stream().findFirst());
    }
}
