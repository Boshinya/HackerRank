import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    private final String s;

    private final char a;

    @Parameterized.Parameters(name = "{index}: Test with str={0} , result:{1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"aaabcccdeeef",'b'},
            {"abcdba",'c'},
            {"abcdeabcde",'-'}
        });
    }


    public ParameterizedTest(String s, char a) {
        this.s=s;
        this.a=a;
    }

    public char firstNonReapeatingChar(String s) {
        char[] c = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();

        for(char i : c) {

            if(map.containsKey(i)) {
                int count = map.get(i);
                map.put(i,++count);
            }else {
                map.put(i,1);
            }
        }

        for(char a : c) {
            if(map.get(a) == 1) {
                return a;
            }
        }

        return '-';
    }

    @Test
    public void testFirstNonRepeatingChar() {
        Assert.assertEquals(a, firstNonReapeatingChar(s));
    }

}
