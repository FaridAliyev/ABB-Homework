import java.util.*;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDao familyDao = new CollectionFamilyDao();

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyDao.getAllFamilies().forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int num) {
        List<Family> families = familyDao.getAllFamilies().stream().filter(f -> f.countFamily() > num).collect(Collectors.toList());
        families.forEach(System.out::println);
        return families;
    }

    public List<Family> getFamiliesLessThan(int num) {
        List<Family> families = familyDao.getAllFamilies().stream().filter(f -> f.countFamily() < num).collect(Collectors.toList());
        families.forEach(System.out::println);
        return families;
    }

    public long countFamiliesWithMemberNumber(int num) {
        return familyDao.getAllFamilies().stream().filter(f -> f.countFamily() == num).count();
    }

    public Family createNewFamily(Woman mother, Man father) {
        return familyDao.saveFamily(new Family(mother, father));
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        Man father = family.getFather();
        String[] genders = {"male", "female"};
        String randomGender = genders[new Random().nextInt(genders.length)];
        Human child = randomGender.equals(genders[0]) ? new Man(maleName, father.getSurname(), Calendar.getInstance().get(Calendar.YEAR)) :
                new Woman(femaleName, father.getSurname(), Calendar.getInstance().get(Calendar.YEAR));
        family.addChild(child);
        child.setFamily(family);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        child.setFamily(family);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyDao.getAllFamilies().forEach(f -> f.getChildren().removeIf(c -> Calendar.getInstance().get(Calendar.YEAR) - c.getYear() > age));
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int index) {
        if (familyDao.getFamilyByIndex(index) == null) {
            return null;
        }
        return familyDao.getFamilyByIndex(index).getPets();
    }

    public void addPet(int index, Pet pet) {
        if (familyDao.getFamilyByIndex(index) == null) {
            return;
        }
        familyDao.getFamilyByIndex(index).addPet(pet);
    }
}
