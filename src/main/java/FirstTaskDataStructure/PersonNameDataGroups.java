package FirstTaskDataStructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class PersonNameDataGroups {

    Person[][] groupsData;
    final int CAPACITY = 33;


    PersonNameDataGroups() {
        groupsData = new Person[CAPACITY][];
        for (int i = 0; i < CAPACITY; i++) {
            groupsData[i] = new Person[10000];
        }

    }

    public void addPerson(Person person) {
        for (int i = 0; i < 10000; i++) {
            if (groupsData[person.lastName.charAt(0) - 1040][i] == null) {
                groupsData[person.lastName.charAt(0) - 1040][i] = person;
                break;
            }
        }

    }


    public Person[] getPersons(char firstLetter) {

        return groupsData[firstLetter - 1040];
    }

    static PersonNameDataGroups parseFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\RostelecomEdu\\src\\main\\java\\students.csv"));
        String s;
        PersonNameDataGroups pn = new PersonNameDataGroups();
        while ((s = reader.readLine()) != null) {
            String[] a = s.split(",");
            pn.addPerson(new Person(a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4]),
                    Integer.parseInt(a[5]), Integer.parseInt(a[6]), Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9])));

        }
        return pn;
    }

    public static void solveTaskThree() throws IOException {
        System.out.println("Введите фамилию: ");
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        PersonNameDataGroups pn = parseFile();

        Arrays.stream(pn.getPersons(lastName.charAt(0))).filter(Objects::nonNull).filter(o -> o.lastName.equals(lastName)).forEach(System.out::println);


    }



}

