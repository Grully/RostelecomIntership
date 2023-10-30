package SecondTask.Person;

public class PersonAge extends Person implements GroupCriterion {

    int key;
    public PersonAge(String lastName, String firstName, int age, int group, int physics, int mathematics, int rus, int literature, int geometry, int informatics) {
        super(lastName, firstName, age, group, physics, mathematics, rus, literature, geometry, informatics);
        this.key = this.age;
    }

    @Override

    public int groupKey() {
        return this.key;
    }
}
