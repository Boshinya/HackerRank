import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinAbsDiffInArray {

    public int getMinAbsDiffernce(int[] arr) {
        Arrays.sort(arr);
        int diff = Math.abs(arr[0]- arr[1]);

        for(int i=1;i<arr.length-1;i++) {
            if(diff > Math.abs(arr[i]- arr[i+1])) {
                diff = Math.abs(arr[i]- arr[i+1]);
            }
        }

        return diff;
    }

    @Test
    public void testDiff() {
        int[] a = new int[] {1, -3, 71, 68, 17};
        Assert.assertEquals(3, getMinAbsDiffernce(a));
    }
}
