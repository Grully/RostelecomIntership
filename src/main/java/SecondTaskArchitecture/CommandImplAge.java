package SecondTaskArchitecture;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class CommandImplAge extends CommandBuilder{
    CommandImplAge(StudentService service) {
        super(service);
    }

    @Override
    public void printCommand() throws IOException {
        DataGroup data = service.dataLoader.parseFile();
        for (int i = 14; i < 18; i++) {
            Arrays.stream(data.getPersons(i)).filter(Objects::nonNull).filter(o -> o.averageScore(o) == 5).forEach(System.out::println);
        }
    }
}
