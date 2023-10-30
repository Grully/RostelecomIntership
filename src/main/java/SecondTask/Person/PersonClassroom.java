package SecondTask.Person;

public class PersonClassroom extends Person implements GroupCriterion {

    int key;
    public PersonClassroom(String lastName, String firstName, int age, int group, int physics, int mathematics, int rus, int literature, int geometry, int informatics) {
        super(lastName, firstName, age, group, physics, mathematics, rus, literature, geometry, informatics);
        this.key = this.group;
    }
    @Override
    public int groupKey() {
        return this.key;
    }
}
