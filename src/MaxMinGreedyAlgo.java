import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxMinGreedyAlgo {

    public int minMaxFromSubArray(int[] a, int k) {
        int result =Integer.MAX_VALUE;
        Arrays.sort(a);
        for(int i=0;i< a.length-k+1;i++) {
            if(a[i+k-1] - a[i] < result)
                result = a[i+k-1] - a[i];
        }
        return result;
    }

    @Test
    public void testMinMax() {
        Assert.assertEquals(0, minMaxFromSubArray(new int[] {4504,1520,5857,4094,4157,3902,822,6643,2422,7288,9948,2822,1784,7802,3142,9739,5629,5413,7232
        },5));
    }
}
