import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddAllTest {

    @Test
    public void testAddAll() {
        List<String> list = new MyArrayList<>();
        List<String> coll =  new ArrayList<>();
        boolean isAllAdded = true;

        for (int i = 1; i <= 10; i++) {
            list.add("test" + i);
            coll.add("coll" + i);
        }

        int prevSize = list.size();
        list.addAll(coll);

        for (int i = coll.size() - 1; i >= 0; i--) {
            if (!Objects.equals(coll.get(i), list.get(i + prevSize))) {
                isAllAdded = false;
                break;
            }
        }

        assertTrue(isAllAdded && (prevSize + coll.size() == list.size()));
    }
}
