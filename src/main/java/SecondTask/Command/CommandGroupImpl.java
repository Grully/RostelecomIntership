package SecondTask.Command;

import java.util.Arrays;
import java.util.Objects;

public class CommandGroupImpl implements Command {

    @Override
    public void printCommand(IDataGroups data) {
        double result = Arrays.stream(data.getPersons(10)).filter(Objects::nonNull).map(o -> o.averageScore(o)).mapToInt(o -> o).average().getAsDouble()
                + Arrays.stream(data.getPersons(11)).filter(Objects::nonNull).map(o -> o.averageScore(o)).mapToInt(o -> o).average().getAsDouble();
        System.out.println(result);
    }

}
