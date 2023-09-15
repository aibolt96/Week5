import org.junit.Test;

public class MissingNumberPerformanceTest {
    private int[] missingMax = {1,2,3,4,5,6,7,8,9};
    private int[] noneMissing = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] missingANumber = {1,2,3,5,6,7,8,9};
    private int max = 10;
    private MissingNumber mn = new MissingNumber();

    @Test(timeout = 100)
    public void testMissingNumber_Performance(){
        for (int i = 0; i < 1000000; i+= 1){
            mn.missingNumber(missingMax, max);
            mn.missingNumber(noneMissing, max);
            mn.missingNumber(missingANumber, max);
        }
    }

    @Test(timeout = 100)
    public void testMissingNumberSort_Performance(){
        for (int i = 0; i < 1000000; i+= 1){
            mn.missingNumber(missingMax, max);
            mn.missingNumber(noneMissing, max);
            mn.missingNumber(missingANumber, max);
        }
    }

    @Test(timeout = 100)
    public void testMissingNumberSum_Performance(){
        for (int i = 0; i < 1000000; i+= 1){
            mn.missingNumber(missingMax, max);
            mn.missingNumber(noneMissing, max);
            mn.missingNumber(missingANumber, max);
        }
    }
}
