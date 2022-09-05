import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final FamilyController familyController = new FamilyController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String fileName = "menu.txt";
        Optional<List<String>> fileContent = readFile(fileName);
        List<String> menu = fileContent.get();
        while (true) {
            menu.forEach(System.out::println);
            String command = scanner.next();
            if (command.equals("exit")) break;
            int number = Integer.parseInt(command);
            switch (number) {
                case 0 -> loadData();
                case 1 -> saveData();
                case 2 -> familyController.displayAllFamilies();
                case 3 -> displayGreaterThan();
                case 4 -> displayLessThan();
                case 5 -> countFamiliesWithMembers();
                case 6 -> createNewFamily();
                case 7 -> deleteFamilyById();
                case 8 -> editFamily();
                case 9 -> removeChildrenOver();
                default -> System.out.println("Please enter a valid input!");
            }
        }

    }

    private static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("families.bin"))) {
            List<Family> families = (List<Family>) ois.readObject();
            families.forEach(familyController::saveFamily);
        } catch (FileNotFoundException exc) {
            System.out.println("File not found!");
        } catch (IOException | ClassNotFoundException exc) {
            System.out.println("Something went wrong!");
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("families.bin"))) {
            oos.writeObject(familyController.getAllFamilies());
        } catch (FileNotFoundException exc) {
            System.out.println("File not found!");
        } catch (IOException exc) {
            System.out.println("Something went wrong!");
        }
    }

    private static void removeChildrenOver() {
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        familyController.deleteAllChildrenOlderThan(age);
    }

    private static void editFamily() {
        scanner:
        while (true) {
            editMenu();
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> giveBirth();
                case 2 -> adoptChild();
                case 3 -> {
                    break scanner;
                }
                default -> System.out.println("Please enter a valid input!");
            }
        }

    }

    private static void adoptChild() {
        System.out.println("Enter family id: ");
        int id = scanner.nextInt();
        Family family = familyController.getFamilyById(id);
        System.out.println("Enter child's name:");
        String name = scanner.next();
        System.out.println("Enter child's surname:");
        String surname = scanner.next();
        System.out.println("Enter date of birth (format - dd/MM/YYYY):");
        String birthDate = scanner.next();
        System.out.println("Enter child's iq:");
        int iq = scanner.nextInt();
        Human child = new Human(name, surname, birthDate, iq);
        familyController.adoptChild(family, child);
    }

    private static void giveBirth() {
        System.out.println("Enter family id: ");
        int id = scanner.nextInt();
        Family family = familyController.getFamilyById(id);
        System.out.println("Enter male name: ");
        String maleName = scanner.next();
        System.out.println("Enter female name: ");
        String femaleName = scanner.next();
        familyController.bornChild(family, maleName, femaleName);
    }

    private static void deleteFamilyById() {
        System.out.println("Enter family id: ");
        int id = scanner.nextInt();
        familyController.deleteFamilyByIndex(id);
    }

    private static void createNewFamily() {
        System.out.println("Enter mother's name:");
        String motherName = scanner.next();
        System.out.println("Enter mother's surname:");
        String motherSurname = scanner.next();
        System.out.println("Enter mother's birth year:");
        int motherBirthYear = scanner.nextInt();
        System.out.println("Enter mother's birth month (format - 01 / 02 / 03 / ... / 11 / 12):");
        String motherBirthMonth = scanner.next();
        System.out.println("Enter mother's birth day: (format - 01 / 02 / 03 / ... / 30 / 31)");
        String motherBirthDay = scanner.next();
        System.out.println("Enter mother's iq:");
        int motherIq = scanner.nextInt();
        System.out.println("Enter father's name:");
        String fatherName = scanner.next();
        System.out.println("Enter father's surname:");
        String fatherSurname = scanner.next();
        System.out.println("Enter father's birth year:");
        int fatherBirthYear = scanner.nextInt();
        System.out.println("Enter father's birth month (format - 01 / 02 / 03 / ... / 11 / 12):");
        String fatherBirthMonth = scanner.next();
        System.out.println("Enter father's birth day: (format - 01 / 02 / 03 / ... / 30 / 31)");
        String fatherBirthDay = scanner.next();
        System.out.println("Enter father's iq:");
        int fatherIq = scanner.nextInt();

        Woman mother = new Woman(motherName, motherSurname, String.join("/", motherBirthDay, motherBirthMonth, String.valueOf(motherBirthYear)), motherIq);
        Man father = new Man(fatherName, fatherSurname, String.join("/", fatherBirthDay, fatherBirthMonth, String.valueOf(fatherBirthYear)), fatherIq);
        Family family = familyController.createNewFamily(mother, father);
    }

    private static void countFamiliesWithMembers() {
        System.out.println("Enter the number: ");
        int num = scanner.nextInt();
        System.out.println("Count:" + familyController.countFamiliesWithMemberNumber(num));
    }

    private static void displayLessThan() {
        System.out.println("Enter the number: ");
        int num = scanner.nextInt();
        familyController.getFamiliesLessThan(num);
    }

    private static void displayGreaterThan() {
        System.out.println("Enter the number: ");
        int num = scanner.nextInt();
        familyController.getFamiliesBiggerThan(num);
    }

    public static Optional<List<String>> readFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            Stream<String> lines = r.lines();
            return Optional.of(lines.collect(Collectors.toList()));
        } catch (IOException x) {
            return Optional.empty();
        }
    }

    private static void editMenu() {
        System.out.println("- 1. Give birth to a baby");
        System.out.println("- 2. Adopt a child");
        System.out.println("- 3. Return to main menu");
    }

}
