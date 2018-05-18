import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RemoveAllTest {
    //TODO add test for null

    private boolean expOutput;
    private Object input;

    public RemoveAllTest(boolean expOutput, Object input) {
        this.expOutput = expOutput;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCondintions() {
        return Arrays.asList(new Object[][] {
                {true, "test1"},
                {false, "test11"},
                {true, 1},
                {false, 11},
                {true, true},
                {false, false}
        });
    }

    @Test
    public void testRemoveAll() {
        List<Object> testList = new MyArrayList<>();

        for (int i = 1; i <= 10; i++) {
            testList.add("test" + i);
            testList.add(i);
        }
        testList.add(true);
        testList.add(null);

//        int prevSize = 0;
//        if ((count % 2) == 0) {
//            prevSize = testList.size();
//            testList.add(count, input);
//        }
//
//        assertEquals(expOutput, (testList.remove(input) &&
//                !(Objects.equals(testList.get(count), input) &&
//                        (prevSize == testList.size()))));

    }
}
