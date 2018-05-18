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
public class SubListTest {

    private int fromIndex;
    private int toIndex;

    public SubListTest(int fromIndex, int toIndex) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    @Parameterized.Parameters
    public static Collection<Integer[]> testCondintions() {
        return Arrays.asList(new Integer[][] {

                {0, 15},
                {15, 30},
                {0, 30},
                {10, 20},
                {15, 15},
        });
    }

    @Test
    public void testSubList() {
        List<String> testList = new MyArrayList<>();

        for (int i = 1; i <= 30; i++) {
            testList.add("test" + i);
        }

        List<String> subList = testList.subList(fromIndex, toIndex);
        int length = toIndex - fromIndex;
        boolean isEqual = true;

        for (String s : subList) {
            if (!Objects.equals(s, testList.get(fromIndex++))) {
                isEqual = false;
            }
        }

        assertTrue((isEqual || subList.isEmpty()) && (subList.size() == length));
    }
}
