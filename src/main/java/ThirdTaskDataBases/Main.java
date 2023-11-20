package ThirdTaskDataBases;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        StudentsDAO dao = new StudentsDAO();
        System.out.println("Введите 1, если хотите вывести статистику средней оценки в 10 и 11 классах, 2 если хотите вывести отличников старше 14 лет, и 3, если хотите вывести среднюю оценку по фамилии");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        switch (a) {
            case 1: dao.printAverageScoreIn10and11groups(); break;
            case 2: dao.printExcellentStudents(); break;
            case 3: dao.printAverageScoreOfLastName(); break;
            default:
                System.out.println("Something goes wrong");
        }
    }
}
