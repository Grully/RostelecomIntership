package SecondTaskArchitecture;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class CommandImplClassroom extends CommandBuilder{
    CommandImplClassroom(StudentService service) {
        super(service);
    }


    public void printCommand() throws IOException {
        DataGroup data = service.dataLoader.parseFile();
        double result = Arrays.stream(data.getPersons(10)).filter(Objects::nonNull).map(o -> o.averageScore(o)).mapToInt(o -> o).average().getAsDouble()
                + Arrays.stream(data.getPersons(11)).filter(Objects::nonNull).map(o -> o.averageScore(o)).mapToInt(o -> o).average().getAsDouble();
        System.out.println(result/2);
    }
}
