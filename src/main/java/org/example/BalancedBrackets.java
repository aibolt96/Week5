import java.util.Stack;

public class BalancedBrackets {
    public static boolean hasBalancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        int length = str.length();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            if (isOpenBracket(c)) {
                stack.push(c);
            } else if (isCloseBracket(c)) {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '{' || c == '[' || c == '<';
    }

    private static boolean isCloseBracket(char c) {
        return c == ')' || c == '}' || c == ']' || c == '>';
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']') ||
                (open == '<' && close == '>');
    }

    public static void main(String[] args) {
        String str1 = "{[()]}";
        String str2 = "{[(])}";
        String str3 = "([)]";

        System.out.println(hasBalancedBrackets(str1)); // true
        System.out.println(hasBalancedBrackets(str2)); // false
        System.out.println(hasBalancedBrackets(str3)); // false
    }
}

//runtime O(n)
// the runtime for the solutions is also O(n)
//all the runtimes are the same I believe but the solutions look a little more readable, so I could improve there.
//the runtime would remain the same O(n) even if a queue was implemented as well
