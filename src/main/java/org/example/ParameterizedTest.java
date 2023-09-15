import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.testng.AssertJUnit.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    private String input;
    private boolean expectedOutput;
    BalancedBrackets bb = new BalancedBrackets();

    public ParameterizedTest(String input, boolean expectedOutput){
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        String balancedParenthesis = "()";
        String unbalancedParenthesis = "()(";
        String balancedAngle = "<>";
        String unbalancedAngle = ">><";
        String balancedAssort = "{<[]>}";
        String unbalancedAssort = "<<{[}]";

        Object[][] expectedOutputs = {
                {balancedParenthesis, true},
                {unbalancedParenthesis, false},
                {balancedAngle, true},
                {unbalancedAngle, false},
                {balancedAssort, true},
                {unbalancedAssort, false}
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testBalancedBrackets(){
        assertEquals(expectedOutput, bb.hasBalancedBrackets(input));
    }
}
