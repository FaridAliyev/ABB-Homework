import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    Woman mother = new Woman("Lorem", "Lorem", 1983);
    Man father = new Man("Lorem", "Lorem", 1979);
    Man child1 = new Man("Lorem", "Lorem", 2003, 99, Map.of(
            DayOfWeek.MONDAY, "study"
    ));
    Woman child2 = new Woman("Lorem", "Lorem", 2004, 120, Map.of(
            DayOfWeek.MONDAY, "study"
    ));

    @Test
    public void testToString() {
        Dog dog = new Dog("doge", 2, 34, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        String result = "DOG{nickname='doge', age=2, trickLevel=34, habits=[sleep, eat, drink]}";
        assertEquals(result, dog.toString());
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
        List<Human> oldChildren = family.getChildren();
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
        List<Human> oldChildren = family.getChildren();
        assertFalse(family.deleteChild(2));
        assertEquals(oldChildren, family.getChildren());
    }

    @Test
    public void testAddChild() {
        Family family = new Family(mother, father);
        int oldLength = family.getChildren().size();
        family.addChild(child1);
        assertEquals(oldLength + 1, family.getChildren().size());
        assertEquals(child1,family.getChildren().get(family.getChildren().size()-1));
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
