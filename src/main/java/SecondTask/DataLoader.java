package SecondTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface DataLoader {
    default DataGroup parse(DataGroup data) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\RostelecomEdu\\src\\main\\java\\students.csv"));
        String s;
        while ((s = reader.readLine()) != null) {
            String[] a = s.split(",");
            data.addPerson(new Person(a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4]),
                    Integer.parseInt(a[5]), Integer.parseInt(a[6]), Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9])));

        }
        return data;
    }

    DataGroup parseFile() throws IOException;
 }
