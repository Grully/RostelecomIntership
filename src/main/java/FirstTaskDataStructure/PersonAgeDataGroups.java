package FirstTaskDataStructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


public class PersonAgeDataGroups {

    Person[][] groupsData;
    final int CAPACITY = 18;


    PersonAgeDataGroups() {
        groupsData = new Person[CAPACITY][];
        for (int i = 0; i < CAPACITY; i++) {
            groupsData[i] = new Person[10000];
        }

    }

    public void addPerson(Person person) {
        for (int i = 0; i < 10000; i++) {
            if (groupsData[person.age][i] == null) {
                groupsData[person.age][i] = person;
                break;
            }
        }

    }

    public Person[] getPersons(int age) {

        return groupsData[age];
    }

    static PersonAgeDataGroups parseFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\RostelecomEdu\\src\\main\\java\\students.csv"));
        String s;
        PersonAgeDataGroups pa = new PersonAgeDataGroups();
        while ((s = reader.readLine()) != null) {
            String[] a = s.split(",");
            pa.addPerson(new Person(a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4]),
                    Integer.parseInt(a[5]), Integer.parseInt(a[6]), Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9])));

        }
        return pa;
    }

    public static void solveTaskTwo() throws IOException {
        PersonAgeDataGroups pa = parseFile();

        Arrays.stream(pa.getPersons(14)).filter(Objects::nonNull).filter(o -> o.averageScore(o) == 5).forEach(System.out::println);
        Arrays.stream(pa.getPersons(15)).filter(Objects::nonNull).filter(o -> o.averageScore(o) == 5).forEach(System.out::println);
        Arrays.stream(pa.getPersons(16)).filter(Objects::nonNull).filter(o -> o.averageScore(o) == 5).forEach(System.out::println);
        Arrays.stream(pa.getPersons(17)).filter(Objects::nonNull).filter(o -> o.averageScore(o) == 5).forEach(System.out::println);


    }

}
