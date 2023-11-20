package ThirdTaskDataBases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;


/* этот класс считывает построчно скрипт initscript, чтобы создать структуру бд.
Первоначально я не совсем понял условие, поэтому не сделал таблицу с оценками в виде many-to-many, но позже исправлять уже не стал */

public class InitClass {

    public static void main(String[] args) throws SQLException, IOException {
       StudentsDAO.TransactionScript init = StudentsDAO.getInstance();
        init.connect();
        Statement statement = init.jdbcConnection.createStatement();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\RostelecomEdu\\src\\main\\java\\ThirdTaskDataBases\\initScript.sql"));
        String s;
        StringBuilder result = new StringBuilder();
        while ((s = reader.readLine()) != null) {
            result.append(s);
        }
        statement.execute(result.toString());
        init.disconnect();
    }
}
