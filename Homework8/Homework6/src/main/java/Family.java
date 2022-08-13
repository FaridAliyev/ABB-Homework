import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
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

    public Family(Human mother, Human father) {
        this.mother = mother;
        mother.setFamily(this);
        this.father = father;
        father.setFamily(this);
        this.children = new ArrayList<>();
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
