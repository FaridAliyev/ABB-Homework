import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    Human mother = new Human("Lorem", "Lorem", 1983);
    Human father = new Human("Lorem", "Lorem", 1979);
    Human child1 = new Human("Lorem", "Lorem", 2003, 99, new String[][]{{DayOfWeek.MONDAY.name(), "study"}});
    Human child2 = new Human("Lorem", "Lorem", 2004, 120, new String[][]{{DayOfWeek.MONDAY.name(), "study"}});

    @Test
    public void testToString() {
        Pet pet = new Pet(Species.DOG, "doge", 2, 34, new String[]{"eat", "drink", "sleep"});
        String result = "DOG{nickname='doge', age=2, trickLevel=34, habits=[eat, drink, sleep]}";
        assertEquals(result, pet.toString());
    }

    @Test
    public void testDeleteChild1() {
        Family family = new Family(mother, father);
        family.addChild(child1);
        family.addChild(child2);
        assertTrue(family.deleteChild(child1));
    }

    @Test
    public void testDeleteChild2() {
        Family family = new Family(mother, father);
        family.addChild(child1);
        family.addChild(child2);
        Human[] oldChildren = family.getChildren();
        family.deleteChild(mother);
        assertEquals(oldChildren, family.getChildren());
    }

    @Test
    public void testDeleteChild3() {
        Family family = new Family(mother, father);
        family.addChild(child1);
        family.addChild(child2);
        assertTrue(family.deleteChild(1));
    }

    @Test
    public void testDeleteChild4() {
        Family family = new Family(mother, father);
        family.addChild(child1);
        family.addChild(child2);
        Human[] oldChildren = family.getChildren();
        assertFalse(family.deleteChild(2));
        assertEquals(oldChildren, family.getChildren());
    }

    @Test
    public void testAddChild() {
        Family family = new Family(mother, father);
        int oldLength = family.getChildren().length;
        family.addChild(child1);
        assertEquals(oldLength + 1, family.getChildren().length);
        assertEquals(child1,family.getChildren()[family.getChildren().length-1]);
        assertEquals(family,child1.getFamily());
    }

    @Test
    public void testCountFamily() {
        Family family = new Family(mother, father);
        family.addChild(child1);
        assertEquals(3,family.countFamily());
        family.addChild(child2);
        assertEquals(4,family.countFamily());
        family.deleteChild(child2);
        assertEquals(3,family.countFamily());
    }
}
