import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class ClearTest {

    @Test
    public void testClear() {
        List<Object> testList = new MyArrayList<>();
        boolean isClear = true;

        for (int i = 0; i < 10; i++) {
            testList.add(new Object());
        }

        testList.clear();

        for (Object o : testList) {
            if (o != null) {
                isClear = false;
            }
        }

        assertTrue(testList.isEmpty() && isClear);
    }
}
