import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LCMGCD {


    public int betweenTwoSets(List<Integer> a , List<Integer> b) {
        a.sort(Comparator.naturalOrder());
        b.sort(Comparator.naturalOrder());
        int count=0;

        int l = lcm(a);
        int g = gcd(b);

        for(int i = l, j =2; i<=g; i=l*j,j++){
            if(g%i==0){ count++;}
        }
        System.out.println(count);

        return count;
    }

    public int getGCD(int a , int b) {
        if (a == 0 || b == 0) {
            return a + b;
        } else {
            int absNumber1 = Math.abs(a);
            int absNumber2 = Math.abs(b);
            int biggerValue = Math.max(absNumber1, absNumber2);
            int smallerValue = Math.min(absNumber1, absNumber2);
            return getGCD(biggerValue % smallerValue, smallerValue);
        }
    }

    public int getLCM(int a , int b) {
        return (a*b) / getGCD(a,b);
    }

    public int lcm(List<Integer> a) {
        int result = a.get(0);

        for(int i=1;i<a.size();i++) {
            result = getLCM(result,a.get(i));
        }

        return result;
    }

    public int gcd(List<Integer> b) {
        int result = b.get(0);

        for(int i=1;i<b.size();i++) {
            result = getGCD(result,b.get(i));
        }

        return result;
    }

    @Test
    public void testBetweenTwoSets() {
        betweenTwoSets(Arrays.asList(2,4), Arrays.asList(16, 32, 96));
    }

}
