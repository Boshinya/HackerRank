import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinarySearch {

    public int searchUsingBST(int[] a, int item) {
        Arrays.sort(a);
        int left = 0;
        int right = a.length-1;

        while(left<=right) {
            int middle = left + (right-left)/2;
            if(a[middle] == item) {
                return middle;
            } else if(a[middle] > item) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }
        return -1;
    }

    @Test
    public void testBST() {
        Assert.assertEquals(5, searchUsingBST(new int[] {10, 5, 8, 9, 50, 100 },100));
    }

}
