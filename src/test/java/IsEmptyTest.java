import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IsEmptyTest {

    private boolean expOutput;
    private int input;

    public IsEmptyTest(boolean expOutput, int input) {
        this.expOutput = expOutput;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCondintions() {
        return Arrays.asList(new Object[][] {
                {true, 0},
                {false, 7},
                {false, 100500}
        });
    }

    @Test
    public void testSize() {
        List<Object> testList = new MyArrayList<>();

        for (int i = 0; i < input; i++) {
            testList.add(new Object());
        }

        assertEquals(expOutput, testList.isEmpty());
    }
}
