import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {
    public static int missingNumber(int[] nums, int maxNumber) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 1; i<= maxNumber; i++){
            set.add(i);
        }
        for (int num : nums){
            set.remove(num);
        }
        if (set.isEmpty())
            return 0;
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 4, 3, 6, 5, 7, 10, 9};
        int maxNum = 10;
        int missingNumber = missingNumber(numbers, maxNum);

        if (missingNumber == 0) {
            System.out.println("There is no missing number.");
        } else {
            System.out.println("The missing number is: " + missingNumber);
        }
    }
}