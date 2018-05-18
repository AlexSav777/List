import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ContainsTest {

    private boolean expOutput;
    private Object input;

    public ContainsTest(boolean expOutput, Object input) {
        this.expOutput = expOutput;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCondintions() {
        return Arrays.asList(new Object[][] {
                {true, "test1"},
                {true, "test10"},
                {false, "test100"},
                {true, 1},
                {true, 10},
                {false, 100},
                {true, false}
        });
    }

    @Test
    public void testSize() {
        List<Object> testList = new MyArrayList<>();

        for (int i = 1; i <= 10; i++) {
            testList.add("test" + i);
            testList.add(i);
        }
        testList.add(false);

        assertEquals(expOutput, testList.contains(input));
    }
}
