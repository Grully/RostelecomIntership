package ThirdTaskDataBases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* этот класс содержит TransactionScript для подключения к бд,
и методы, которые вытаскивают список всех учеников с их оценками, а также обновляют ученика по id
и еще 3 метода получающие статистику */
public class StudentsDAO {
    public static final class TransactionScript {
        private final String jdbcURL;
        private final String jdbcUser;
        private final String jdbcPassword;
        Connection jdbcConnection;

        public TransactionScript(String jdbcURL, String jdbcUser, String jdbcPassword) {
            this.jdbcURL = jdbcURL;
            this.jdbcUser = jdbcUser;
            this.jdbcPassword = jdbcPassword;
        }

        public void connect() throws SQLException {
            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
            }
        }

        public void disconnect() throws SQLException {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                jdbcConnection.close();
            }
        }
    }

    private static final TransactionScript instance = new TransactionScript("jdbc:postgresql://localhost:5432/students", "postgres", "123");

    public static TransactionScript getInstance() {
        return instance;
    }

    public List<Person> listAllStudents() throws SQLException {
        List<Person> listStudents = new ArrayList<>();
        instance.connect();
        Statement statement = instance.jdbcConnection.createStatement();
        Statement statement1 = instance.jdbcConnection.createStatement();


        ResultSet resultSet = statement.executeQuery("SELECT * FROM students ORDER BY id");
        ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM performance ORDER BY id");


        while (resultSet.next()) {

            resultSet1.next();
            String lastName = resultSet.getString("lastname");
            String firstName = resultSet.getString("firstname");
            int age = resultSet.getInt("age");
            int group = resultSet.getInt("group_id");
            int physics = resultSet1.getInt("physics");
            int mathematics = resultSet1.getInt("mathematics");
            int russian = resultSet1.getInt("russian");
            int literature = resultSet1.getInt("literature");
            int geometry = resultSet1.getInt("geometry");
            int informatics = resultSet1.getInt("informatics");


            Person person = new Person(lastName, firstName, age, group, physics, mathematics, russian, literature, geometry, informatics);
            listStudents.add(person);
        }

        resultSet.close();
        resultSet1.close();
        statement.close();
        statement1.close();
        instance.disconnect();


        return listStudents;
    }

    public Person getStudent(int id) throws SQLException {
        instance.connect();
        Person person = null;
        PreparedStatement statement = instance.jdbcConnection.prepareStatement("SELECT * FROM students WHERE id = ?");
        PreparedStatement statement1 = instance.jdbcConnection.prepareStatement("SELECT * FROM performance WHERE id = ?");
        statement.setInt(1, id);
        statement1.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        ResultSet resultSet1 = statement1.executeQuery();

        resultSet.next();
        resultSet1.next();

            String lastName = resultSet.getString("lastname");
            String firstName = resultSet.getString("firstname");
            int age = resultSet.getInt("age");
            int group = resultSet.getInt("group_id");
            int physics = resultSet1.getInt("physics");
            int mathematics = resultSet1.getInt("mathematics");
            int russian = resultSet1.getInt("russian");
            int literature = resultSet1.getInt("literature");
            int geometry = resultSet1.getInt("geometry");
            int informatics = resultSet1.getInt("informatics");

            person = new Person(lastName, firstName, age, group, physics, mathematics, russian, literature, geometry, informatics);

        resultSet.close();
        resultSet1.close();
        statement.close();
        instance.disconnect();

        return person;
    }

    void printAverageScoreIn10and11groups() throws SQLException {
        System.out.println(listAllStudents().stream().filter(o->o.getGroup() >=10).mapToDouble(o->o.averageScore(o)).average().getAsDouble());
    }

    void printExcellentStudents() throws SQLException {
        listAllStudents().stream().filter(o->o.getAge() >= 14 && o.averageScore(o) == 5 ).forEach(System.out::println);
    }

    void printAverageScoreOfLastName() throws SQLException {
        System.out.println("Введите фамилию: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(listAllStudents().stream().filter(o->o.getLastName().equals(str)).map(o->o.averageScore(o)).mapToDouble(o->o).average().getAsDouble());

    }

}

