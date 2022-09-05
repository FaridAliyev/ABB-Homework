import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Human implements Serializable {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Map<DayOfWeek, String> schedule;
    private Family family;

    public Human() {
    }

    public Human(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = convertStringToUnixTimestamp(birthDate);
        this.schedule = new HashMap<>();
    }

    public Human(String name, String surname, String birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = convertStringToUnixTimestamp(birthDate);
        this.iq = iq;
        this.schedule = new HashMap<>();
    }

    public Human(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = convertStringToUnixTimestamp(birthDate);
        this.iq = iq;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void greetPet() {
        System.out.printf("Hello, %s\n", this.getFamily().getPets());
    }

    public int getYear() {
        Date expiry = new Date(birthDate);
        LocalDate localDate = expiry.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        return year;
    }

    public String describeAge() {
        Date expiry = new Date(birthDate);
        LocalDate bornDate = expiry.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear()-bornDate.getYear();
        int month = currentDate.getMonthValue()-bornDate.getMonthValue();
        int day = currentDate.getDayOfMonth()-bornDate.getDayOfMonth();
        return String.format("%d years, %d months, %d days", year, month, day);
    }

    private long convertStringToUnixTimestamp(String birthDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = format.parse(birthDate);
            long timestamp = date.getTime();
            return timestamp;
        } catch (ParseException e) {
            System.out.println("Please provide a dd/MM/yyyy format!");
        }
        return -1;
    }

    private String convertUnixTimestampToString(long timestamp) {
        Date expiry = new Date(timestamp);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(expiry);
        return strDate;
    }

    public String prettyFormat() {
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + convertUnixTimestampToString(birthDate) +
                ", iq=" + iq +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getBirthDate() == human.getBirthDate() && getName().equals(human.getName()) && getSurname().equals(human.getSurname());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getSurname(), getBirthDate());
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + convertUnixTimestampToString(birthDate) +
                ", iq=" + iq +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human has been removed!");
    }
}
