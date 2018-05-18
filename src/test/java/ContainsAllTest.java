import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ContainsAllTest {
    //TODO why emptyList() is true?

    private boolean expOutput;
    private Collection input;

    public ContainsAllTest(boolean expOutput, Collection input) {
        this.expOutput = expOutput;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCondintions() {
        return Arrays.asList(new Object[][] {

                {true, Collections.emptyList()},
                {true, Collections.singletonList("A")},
                {true, Arrays.asList("A", "A", "A")},
                {true, Arrays.asList("A", "B", "C")},
                {true, Arrays.asList("C", "D", "E")},
                {true, Arrays.asList("B", "C", "D")},
                {true, Arrays.asList("A", "B", "C", "D", "E")},
                {false, Arrays.asList("G")},
                {false, Arrays.asList("A", "B", "C", "D", "G")},
        });
    }

    @Test
    public void testContainsAll() {
        List<Object> list =
                new MyArrayList<>(Arrays.asList("A","B","C","D","E"));

        assertEquals(expOutput, list.containsAll(input));
    }
}
