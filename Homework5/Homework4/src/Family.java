import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[]{};
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
        Human[] newChildren = Arrays.copyOf(this.children,this.children.length + 1);
        newChildren[newChildren.length-1] = child;
        this.children=newChildren;
    }

    public boolean deleteChild(int index) {
        if (index > this.children.length - 1) return false;
        Human[] newChildren = new Human[this.children.length - 1];
        int counter = 0;
        for (int i = 0; i < this.children.length; i++) {
            if (i != index) {
                newChildren[counter++] = this.children[i];
            }
        }
        this.children[index].setFamily(null);
        this.children = newChildren;
        return true;
    }

    public int countFamily(){
        return this.children.length + (mother != null ? 1 : 0) + (father != null ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }
}
