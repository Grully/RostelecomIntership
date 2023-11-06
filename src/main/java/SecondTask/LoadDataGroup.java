package SecondTask;

import java.io.IOException;

public class LoadDataGroup implements DataLoader{


    @Override
    public DataGroup parseFile() throws IOException {
        DataGroup data = new DataGroup(o->o.group);
        return parse(data);
    }
}
