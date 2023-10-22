package FirstTaskDataStructure;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

class ClassroomDataGroups {
    Person[][] groupsData;
    final int CAPACITY = 13;


    ClassroomDataGroups() {
        groupsData = new Person[CAPACITY][];
        for (int i = 0; i < CAPACITY; i++) {
            groupsData[i] = new Person[10000];
        }

    }

    public void addPerson(Person person) {
        for (int i = 0; i < 10000; i++) {
            if (groupsData[person.group][i] == null) {
                groupsData[person.group][i] = person;
                break;
            }
        }

    }

    public Person[] getPersons(int groupNum) {

        return groupsData[groupNum];
    }
    static ClassroomDataGroups parseFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\RostelecomEdu\\src\\main\\java\\students.csv"));
        String s;
        ClassroomDataGroups cr = new ClassroomDataGroups();
        while ((s = reader.readLine()) != null) {
            String[] a = s.split(",");
            cr.addPerson(new Person(a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4]),
                    Integer.parseInt(a[5]), Integer.parseInt(a[6]), Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9])));

        }
        return cr;
    }

    public static double solveTaskOne() throws IOException {
        ClassroomDataGroups cr = parseFile();
        double result = Arrays.stream(cr.getPersons(10)).filter(Objects::nonNull).map(o -> o.averageScore(o)).mapToInt(o -> o).average().getAsDouble()
        + Arrays.stream(cr.getPersons(11)).filter(Objects::nonNull).map(o -> o.averageScore(o)).mapToInt(o -> o).average().getAsDouble();
        return result/2;

    }

}

