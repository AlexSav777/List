import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AddAllAtIndexTest {
    //TODO assertError is neither with Iterable nor with big size of collection

    @Parameterized.Parameter
    public int index;

    @Parameterized.Parameters
    public static Integer[] testCondintions() {
        return new Integer[] {0, 5, 9};
    }

    @Test
    public void AddAllAtIndexTest() {
        List<String> list = new MyArrayList<>();
        List<String> coll =  new ArrayList<>();
        boolean isAllAdded = true;

        for (int i = 1; i <= 10; i++) {
            list.add("test" + i);
            coll.add("coll" + i);
        }

        int prevSize = list.size();
        list.addAll(index, coll);

        for (int i = 0; i < coll.size(); i++) {
            if (!Objects.equals(coll.get(i), list.get(i + index))) {
                isAllAdded = false;
                break;
            }
        }

        assertTrue(isAllAdded && (prevSize + coll.size() == list.size()));
    }
}
