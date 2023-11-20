package SecondTaskArchitecture;

import java.io.IOException;

public class LoadDataLastname  implements DataLoader{
    @Override
    public DataGroup parseFile() throws IOException {
        DataGroup data = new DataGroup(o->o.lastName.charAt(0) - 1040);
        return parse(data);
    }
}
