import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AddTest {

    private static int count = 0;
    private boolean expOutput;
    private Object input;

    public AddTest(boolean expOutput, Object input) {
        this.expOutput = expOutput;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCondintions() {
        return Arrays.asList(new Object[][] {
                {true, "test"},
                {false, "test11"},
                {true, 1},
                {false, 10},
                {true, true},
                {false, false},
                {true, 'c'},
                {false, 1.0},
                {true, 1.0F},
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

        int size = testList.size();
        if ((count%2)==0) {
            testList.add(input);
        }
        count++;

        assertEquals(expOutput, ((size + 1) == testList.size()) && (testList.get(size).equals(input)));
    }

}
