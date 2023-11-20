package SecondTaskArchitecture;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CommandImplLastName extends CommandBuilder{
    CommandImplLastName(StudentService service) {
        super(service);
    }

    @Override
    public void printCommand() throws IOException {
        DataGroup data = service.dataLoader.parseFile();
        System.out.println("Введите фамилию: ");
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();
        Arrays.stream(data.getPersons(lastName.charAt(0) - 1040)).filter(Objects::nonNull).filter(o -> o.lastName.equals(lastName)).forEach(System.out::println);
    }
}
