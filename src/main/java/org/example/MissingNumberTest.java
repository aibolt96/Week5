import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {
    private int[] missingMax = {1,2,3,4,5,6,7,8,9};
    private int[] noneMissing = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] missingANumber = {1,2,3,5,6,7,8,9};
    private MissingNumber mn = new MissingNumber();

    @Test
    public void testMissingNumber_missingMax() {
        assertEquals(10, mn.missingNumber(missingMax, 10));
    }

    @Test
    public void testMissingNumber_noneMissing() {
        assertEquals(10, mn.missingNumber(noneMissing, 10));
    }

    @Test
    public void testMissingNumber_missingANumber(){
        assertEquals(10, mn.missingNumber(missingANumber, 10));
    }
}
