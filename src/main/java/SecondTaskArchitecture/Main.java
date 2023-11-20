package SecondTaskArchitecture;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Command commandImplClassroom = new CommandImplClassroom(new StudentService(new LoadDataGroup()));
        Command commandImplAge = new CommandImplAge(new StudentService(new LoadDataAge()));
        Command commandImplLastName = new CommandImplLastName(new StudentService(new LoadDataLastname()));
        commandImplClassroom.printCommand();
        commandImplAge.printCommand();
        commandImplLastName.printCommand();

    }
}
