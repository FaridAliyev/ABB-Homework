import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> familyList = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index > familyList.size() - 1) return null;
        return familyList.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index > familyList.size() - 1) return false;
        familyList.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        if (!familyList.contains(family)) return false;
        familyList.remove(family);
        return true;
    }

    @Override
    public Family saveFamily(Family family) {
        if (familyList.contains(family)) {
            for (Family f : familyList) {
                if (f.equals(family)) {
                    f = family;
                    return family;
                }
            }
        }
        familyList.add(family);
        return family;
    }
}
