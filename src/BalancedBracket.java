import org.junit.Test;
import org.testng.Assert;

import java.util.Stack;

public class BalancedBracket {

    public boolean isBracketsBalanced(String str) {

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.toCharArray().length;i++) {
            switch (str.charAt(i)) {
                case '{':
                case '(':
                case '[':
                    stack.push(str.charAt(i));
                    break;
                case '}':
                      if(!stack.empty()) {
                          if (!stack.pop().equals('{')) {
                           }
                      } else {
                          return false;
                      }
                break;
                case ')':
                    if(!stack.isEmpty()) {
                        if (!stack.pop().equals('(')) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                break;
                case ']':
                    if(!stack.isEmpty()) {
                        if (!stack.pop().equals('[')) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                break;
                default:
                    return false;
            }
        }
        return stack.empty();

    }

    @Test
    public void testBalancedBrackets() {
        Assert.assertTrue(isBracketsBalanced("[]{}(){()}((())){{{}}}{()()}{{}{}}"),"Brackets are not balanced");
        Assert.assertFalse(isBracketsBalanced("}}}}"),"Brackets are balanced");
        Assert.assertFalse(isBracketsBalanced("{"),"Brackets are balanced");
    }
}
