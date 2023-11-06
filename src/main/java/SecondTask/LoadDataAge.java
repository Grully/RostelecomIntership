package SecondTask;

import java.io.IOException;

public class LoadDataAge implements DataLoader{

    @Override
    public DataGroup parseFile() throws IOException {
        DataGroup data = new DataGroup(o->o.age);
        return parse(data);
    }
}
