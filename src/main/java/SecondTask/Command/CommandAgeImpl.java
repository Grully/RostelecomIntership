package SecondTask.Command;

import java.util.Arrays;
import java.util.Objects;

public class CommandAgeImpl implements Command {

    @Override
    public void printCommand(IDataGroups data) {
        for(int i = 14; i < 17; i++) {
            Arrays.stream(data.getPersons(i)).filter(Objects::nonNull).filter(o -> o.averageScore(o) == 5).forEach(System.out::println);
        }


    }

}
