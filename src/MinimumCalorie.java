import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;


public class MinimumCalorie {

    public long marcsCakewalk(int[] calorie) {

        Arrays.sort(calorie);

        long sum =0L;
        int i=0;

        for(int j=calorie.length-1;j>=0;j--) {
            sum = sum + (long) (Math.pow(2,i) * calorie[j]);
            i++;
        }
        return sum;
    }

    @Test
    public void testCalorieCount() {
        int[] a = new int[] {7, 4, 9, 6};
        Assert.assertEquals(79,marcsCakewalk(a));
    }
}
