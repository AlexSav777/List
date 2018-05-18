import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class IndexOfTest {

    private int expOutput;
    private Object input;

    public IndexOfTest(int expOutput, Object input) {
        this.expOutput = expOutput;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCondintions() {
        return Arrays.asList(new Object[][] {

                {0, "test1"},
                {4, "test5"},
                {9, "test10"},
                {30, Integer.MAX_VALUE},

                {-1, "test"},
                {-1, "test11"},
                {-1, 1},
                {-1, true},
        });
    }

    @Test
    public void testIndexOf() {
        List<Object> testList = new MyArrayList<>();

        for (int i = 0; i < 30; i++) {
            testList.add("test" + ((i % 10) + 1));
        }
        testList.add(Integer.MAX_VALUE);

        assertEquals(expOutput, testList.indexOf(input));
    }

}
