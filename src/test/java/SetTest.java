import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SetTest {

    private boolean expOutput;
    private Object input;
    private static int count = 0;

    public SetTest(boolean expOutput, Object input) {
        this.expOutput = expOutput;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCondintions() {
        return Arrays.asList(new Object[][] {
                {true, "test"},
                {false, "test1"},
                {true, "test100"},
                {false, 1},
                {true, 100},
                {false, 1.0},
                {true, true},
                {false, Integer.MAX_VALUE},
                {true, Integer.MIN_VALUE}
        });
    }

    @Test
    public void testSize() {
        List<Object> testList = new MyArrayList<>();

        for (int i = 1; i <= 10; i++) {
            testList.add("test" + i);
        }

        int prevSize = testList.size();
        if ((count % 2) == 0) {
            testList.set(count, input);
        }

        assertEquals(expOutput, (Objects.equals(input, testList.get(count)) &&
                (prevSize == testList.size())));

        count++;
    }
}
