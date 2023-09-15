public class BalancedParenthesis {
    public static boolean balancedParenthesisChecker(String string){
        int parenthesisCount = 0;
        for (int i=0; i<string.length(); i++){
            char c = string.charAt(i);

            if (c == '(') {
                parenthesisCount ++;
            } else if (c == ')') {
                if (parenthesisCount == 0){
                    return false;
                } else {
                    parenthesisCount--;
                }
            }
        }
        return parenthesisCount == 0;
    }
    public static void main(String[] args){
        String string1 = "()";
        String string2 = "((()))";
        String string3 = "())(";

        System.out.println(balancedParenthesisChecker(string1));
        System.out.println(balancedParenthesisChecker(string2));
        System.out.println(balancedParenthesisChecker(string3));
    }
}

//runtime O(n)
