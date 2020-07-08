import org.junit.Assert;
import org.junit.Test;

public class ProductOfArrayExceptSelf {

    public int[] productOfArray(int[] a) {

        int N = a.length;

        int[] leftArray = new int[N];

        int[] rightArray = new int[N];

        int[] output = new int[N];

        leftArray[0] = 1;
        rightArray[N-1] = 1;

        for(int i=1;i<N;i++) {
            leftArray[i] = a[i-1] * leftArray[i-1];
        }

        for(int i=N-2;i>=0;i--) {
            rightArray[i] = a[i+1] * rightArray[i+1];
        }

        for(int i=0;i<N;i++) {
            output[i] = leftArray[i] * rightArray[i];
        }

        return output;
    }

    @Test
    public void testProductOfArray() {
        int[] in = new int[] {1,2,3,4};
        int[] out = new int[] {24,10,8,6};
        Assert.assertArrayEquals(out,productOfArray(in));
    }
}
