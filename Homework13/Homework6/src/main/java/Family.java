import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class Family implements Serializable {

    private Woman mother;
    private Man father;
    private List<Human> children;
    private Set<Pet> pets;

    public Woman getMother() {
        return mother;
    }

    public void setMother(Woman mother) {
        this.mother = mother;
    }

    public Man getFather() {
        return father;
    }

    public void setFather(Man father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public Family(Woman mother, Man father) {
        this.mother = mother;
        mother.setFamily(this);
        this.father = father;
        father.setFamily(this);
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return getMother().equals(family.getMother()) && getFather().equals(family.getFather());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMother(), getFather());
    }

    public void addChild(Human child) {
        if (this.countFamily() == 6) {
            throw new FamilyOverflowException("Family is full! Cannot add more members!");
        }
        child.setFamily(this);
        this.children.add(child);
    }

    public boolean deleteChild(int index) {
        if (index > this.children.size() - 1) return false;
        this.children.get(index).setFamily(null);
        this.children.remove(index);
        return true;
    }

    public boolean deleteChild(Human child) {
        if (!this.children.contains(child)) {
            return false;
        }
        child.setFamily(null);
        this.children.remove(child);
        return true;
    }

    public int countFamily() {
        return this.children.size() + (mother != null ? 1 : 0) + (father != null ? 1 : 0);
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("family:\n\tmother: ");
        sb.append(mother.prettyFormat() + ",\n\tfather: ");
        sb.append(father.prettyFormat() + ",\n\tchildren:");
        children.forEach(c -> {
            String gender = c instanceof Man ? "boy" : "girl";
            sb.append("\n\t\t").append(gender).append(": ").append(c.prettyFormat());
        });
        sb.append("\n\tpets: [");
        pets.forEach(p -> {
            sb.append(p.prettyFormat());
        });
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children +
                ", pets=" + pets +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family has been removed!");
    }
}
