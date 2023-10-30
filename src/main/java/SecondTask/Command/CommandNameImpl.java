package SecondTask.Command;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CommandNameImpl implements Command {

    @Override
    public void printCommand(IDataGroups data) {
        System.out.println("Введите фамилию: ");
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        Arrays.stream(data.getPersons(lastName.charAt(0))).filter(Objects::nonNull).filter(o -> o.lastName.equals(lastName)).forEach(System.out::println);
    }
}
