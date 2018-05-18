import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetTest {

    private String expOutput;
    private int index;

    public GetTest(String expOutput, int input) {
        this.expOutput = expOutput;
        this.index = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCondintions() {
        return Arrays.asList(new Object[][] {
                {"test1", 0},
                {"test5", 4},
                {"test10", 9}
        });
    }

    @Test
    public void testGet() {
        List<String> testList = new MyArrayList<>();

        for (int i = 1; i <= 10; i++) {
            testList.add("test" + i);
        }

        assertEquals(expOutput, testList.get(index));
    }
}
