import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CountingSort {

    public int[] sortUsingCountMethod(int[] a, int range) {

        int[] count = new int[range+1];

        int[] sorted = new int[a.length];

        for(int value : a) {
            count[value]+=1;
        }

        for(int i=1;i<count.length;i++) {
            count[i]+=count[i-1];
        }

        for(int i=a.length-1;i>=0;i--) {
            int n = a[i];
            sorted[count[n]-1] = n;
            count[n]-=1;
        }

        Arrays.stream(sorted).forEach(System.out::println);

        return sorted;
    }


    @Test
    public void testSorting() {
        int[] a = new int[] {10,90,50,32,67,87};
        Assert.assertArrayEquals(new int[]{10,32,50,67,87,90},sortUsingCountMethod(a, 90));
    }

}
