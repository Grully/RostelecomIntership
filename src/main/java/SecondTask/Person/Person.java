package SecondTask.Person;

public class Person {

    public String lastName;
    String firstName;
    int age;
    public int group;
    int physics;
    int mathematics;
    int rus;
    int literature;
    int geometry;
    int informatics;

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

    public int averageScore(Person person) {
        return (person.physics + person.geometry + person.informatics + person.literature + person.rus + person.mathematics) / 6;
    }

}
