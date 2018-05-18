import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RemoveByIndexTest {

    @Parameter
    public int index;

    @Parameterized.Parameters
    public static Iterable<? extends Object> testCondintions() {
        return Arrays.asList(0, 5, 8);
    }

    @Test
    public void testRemoveByIndex() {
        List<Object> testList = new MyArrayList<>();

        for (int i = 1; i <= 10; i++) {
            testList.add("test" + i);
        }

        int prevSize = testList.size();
        Object element = testList.remove(index);

        //ArrayIndexOutOfBoundExc. when index is 9 (the last for an array)
        assertTrue(!(Objects.equals(element, testList.get(index))) &&
                ((prevSize - 1) == testList.size()));

    }
}
