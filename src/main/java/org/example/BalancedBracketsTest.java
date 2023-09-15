import static org.junit.Assert.*;
import org.junit.Test;
public class BalancedBracketsTest {
    String balancedParenthesis = "()";
    String unbalancedParenthesis = "()(";
    String balancedAngle = "<>";
    String unbalancedAngle = ">><";
    String balancedAssort = "{<[]>}";
    String unbalancedAssort = "<<{[}]";

    BalancedBrackets bb = new BalancedBrackets();

    @Test
    public void testBalancedBrackets_balancedParenthesis(){
        assertTrue(bb.hasBalancedBrackets(balancedParenthesis));
    }

    @Test
    public void testBalancedBrackets_unbalancedParenthesis(){
        assertFalse(bb.hasBalancedBrackets(unbalancedParenthesis));
    }

    @Test
    public void testBalancedBrackets_balancedAngle(){
        assertTrue(bb.hasBalancedBrackets(balancedAngle));
    }

    @Test
    public void testBalancedBrackets_unbalancedAngle(){
        assertFalse(bb.hasBalancedBrackets(unbalancedAngle));
    }

    @Test
    public void testBalancedBrackets_balancedAssort(){
        assertTrue(bb.hasBalancedBrackets(balancedAssort));
    }

    @Test
    public void testBalancedBrackets_unbalancedAssort(){
        assertFalse(bb.hasBalancedBrackets(unbalancedAssort));
    }
}
