package ThirdTaskDataBases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/* этот класс используется для того, чтобы распарсить файл и добавить его в базу данных. */

public class TransferDataToDatabaseFromCsv {
    public static void main(String[] args) throws SQLException, IOException {
        StudentsDAO.TransactionScript init = StudentsDAO.getInstance();
        init.connect();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\RostelecomEdu\\src\\main\\java\\students.csv"));
        String s;
        PreparedStatement statement = init.jdbcConnection.prepareStatement("INSERT INTO students (lastname, firstname, age, group_id) VALUES  (?, ?, ?, ?) ON CONFLICT DO NOTHING");
        PreparedStatement statement2 = init.jdbcConnection.prepareStatement("INSERT INTO groups (id, studyplan) VALUES (?, ? ) ON CONFLICT DO NOTHING");
        PreparedStatement statement3 = init.jdbcConnection.prepareStatement("INSERT INTO performance (physics, mathematics, russian, literature, geometry, informatics) VALUES  (?, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING");

        while ((s = reader.readLine()) != null) {

            String[] a = s.split(",");
            String LastName = a[0];
            String FirstName = a[1];
            int age = Integer.parseInt(a[2]);
            int group = Integer.parseInt(a[3]);
            int phys = Integer.parseInt(a[4]);
            int mathematics = Integer.parseInt(a[5]);
            int rus = Integer.parseInt(a[6]);
            int literature = Integer.parseInt(a[7]);
            int geometry = Integer.parseInt(a[8]);
            int informatics = Integer.parseInt(a[9]);

            statement2.setInt(1, group);
            String[] arr = new String[]{"phys", "mathematics", "rus", "literature", "geometry", "informatics"};
            Array t = init.jdbcConnection.createArrayOf("varchar", arr);
            statement2.setArray(2, t);
            statement2.executeUpdate();
            statement.setString(1, LastName);
            statement.setString(2, FirstName);
            statement.setInt(3, age);
            statement.setInt(4, group);
            statement.executeUpdate();
            statement3.setInt(1, phys);
            statement3.setInt(2, mathematics);
            statement3.setInt(3, rus);
            statement3.setInt(4, literature);
            statement3.setInt(5, geometry);
            statement3.setInt(6, informatics);
            statement3.executeUpdate();
        }

        init.disconnect();
    }
}

