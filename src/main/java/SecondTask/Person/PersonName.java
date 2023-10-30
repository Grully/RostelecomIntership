package SecondTask.Person;

public class PersonName extends Person implements GroupCriterion {

    int key;

    public PersonName(String lastName, String firstName, int age, int group, int physics, int mathematics, int rus, int literature, int geometry, int informatics) {
        super(lastName, firstName, age, group, physics, mathematics, rus, literature, geometry, informatics);
        this.key = this.lastName.charAt(0) - 1040;
    }

    @Override
    public int groupKey() {
        return this.key;
    }
}
