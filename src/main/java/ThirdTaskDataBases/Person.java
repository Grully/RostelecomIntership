package ThirdTaskDataBases;

public class Person {
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public int getGroup() {
        return group;
    }

    public int getPhysics() {
        return physics;
    }

    public int getMathematics() {
        return mathematics;
    }

    public int getRus() {
        return rus;
    }

    public int getLiterature() {
        return literature;
    }

    public int getGeometry() {
        return geometry;
    }

    public int getInformatics() {
        return informatics;
    }

    private String lastName;
    private String firstName;
    private final int age;
    private final int group;
    private final int physics;
    private final int mathematics;
    private final int rus;
    private final int literature;
    private final int geometry;
    private final int informatics;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", group=" + group +
                ", physics=" + physics +
                ", mathematics=" + mathematics +
                ", rus=" + rus +
                ", literature=" + literature +
                ", geometry=" + geometry +
                ", informatics=" + informatics +
                '}';
    }

    public Person(String lastName, String firstName, int age, int group, int physics, int mathematics, int rus, int literature, int geometry, int informatics) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.group = group;
        this.physics = physics;
        this.mathematics = mathematics;
        this.rus = rus;
        this.literature = literature;
        this.geometry = geometry;
        this.informatics = informatics;
    }

    int averageScore(Person person) {
        return (person.physics + person.geometry + person.informatics + person.literature + person.rus + person.mathematics) / 6;
    }
}
