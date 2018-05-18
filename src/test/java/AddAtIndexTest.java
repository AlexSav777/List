import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AddAtIndexTest {

    private static int count = 0;

    @Parameterized.Parameter
    public Object input;

//    public AddAtIndexTest(Object input) {
//        this.input = input;
//    }

    @Parameterized.Parameters
    public static Object[] testCondintions() {
        return new Object[] {
            "test", "test11", 1, 10, true, false, 'c', 1.0, 1.0F, Integer.MAX_VALUE, Integer.MIN_VALUE
        };
    }

    @Test
    public void testSize() {
        List<Object> testList = new MyArrayList<>();

        for (int i = 1; i <= 10; i++) {
            testList.add("test" + i);
        }

        int size = testList.size();
        testList.add(count, input);

        assertTrue(((size + 1) == testList.size()) && (Objects.equals(testList.get(count), input)));
        count++;
    }

}
