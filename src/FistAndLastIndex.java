import org.junit.Assert;
import org.junit.Test;

public class FistAndLastIndex {

    public int[] findFirstAndLastIndexOfANumberInSortedArray(int[] a, int target) {
        int[] result = new int[2];

        result[0] = findFirstIndex(a, target);
        result[1] = findEndIndex(a,target);
        return result;
    }

    private int findFirstIndex(int[] a , int target) {
        int start = 0;
        int end = a.length;
        int index =-1;

        while (start<=end) {
            int mid = start + (end-start)/2;
            if(a[mid]>=target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        if(a[mid] == target) index = mid;
        }
        return index;

    }


    private int findEndIndex(int[] a , int target) {
        int start = 0;
        int end = a.length;
        int index =-1;

        while (start<=end) {
            int mid = start + (end-start)/2;
            if(a[mid]<=target) {
                start = mid +1;
            } else {
                end = mid -1;
            }
            if(a[mid] == target) index = mid;
        }
        return index;
    }
    @Test
    public void testFirstAndLastIndex() {
        int[] in = new int[] {1,1,3,4,5,8,8,8,8,15,19};

        int[] out = new int[] {5,8};

        Assert.assertArrayEquals(out,findFirstAndLastIndexOfANumberInSortedArray(in,8));
    }

}
