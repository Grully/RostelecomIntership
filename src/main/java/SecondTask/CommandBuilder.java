package SecondTask;

import java.io.IOException;

public class CommandBuilder implements Command {
    StudentService service;
    CommandBuilder(StudentService service) {
        this.service = service;
    }
    public void printCommand() throws IOException
    {
        System.out.println("default command");
    }
}
