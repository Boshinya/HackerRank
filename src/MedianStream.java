import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MedianStream {

//    Median Stream
//    You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, for each index i (between 0 and n-1, inclusive), output[i] is equal to the median of the elements arr[0..i] (rounded down to the nearest integer).
//    The median of a list of integers is defined as follows. If the integers were to be sorted, then:
//
//    If there are an odd number of integers, then the median is equal to the middle integer in the sorted order.
//    Otherwise, if there are an even number of integers, then the median is equal to the average of the two middle-most integers in the sorted order.
//
//    Signature
//    int[] findMedian(int[] arr)
//    Input
//    n is in the range [1, 1,000,000].
//    Each value arr[i] is in the range [1, 1,000,000].
//    Output
//    Return a list of n integers output[0..(n-1)], as described above.
//        Example 1
//    n = 4
//    arr = [5, 15, 1, 3]
//    output = [5, 10, 5, 4]
//    The median of [5] is 5, the median of [5, 15] is (5 + 15) / 2 = 10, the median of [5, 15, 1] is 5, and the median of [5, 15, 1, 3] is (3 + 5) / 2 = 4.
//    Example 2
//    n = 2
//    arr = [1, 2]
//    output = [1, 1]
//    The median of [1] is 1, the median of [1, 2] is (1 + 2) / 2 = 1.5 (which should be rounded down to 1).


    public int[] findMedian(int[] a) {
        int[] o = new int[a.length];

        o[0] = a[0];

        for(int i=1;i<a.length;i++) {
            Arrays.sort(a,0,i+1);
            o[i] = getMedian(a,i);
        }

        return o;
    }

    private int getMedian(int[] arr, int i) {
        int med=0;

        if(i%2 ==0) {
            med = arr[i/2];
        } else {
            int left = i/2;
            med = (arr[left] + arr[left+1])/2;
        }
        return med;
    }

    @Test
    public void testMedian() {
        int[] actual = findMedian(new int[] {5, 15, 1, 3});
        Assert.assertArrayEquals(new int[]{5, 10, 5, 4},actual);
    }

    @Test
    public void rangeExtraction() {

        int[] a = new int[] {-22,-19,-17,-14,-11,-10,-9,-7,-6,-5,-4,-2,1,2,3};

        final StringBuilder str = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            int rangeStart = a[i];
            str.append(rangeStart);
            for (int j = i + 1; j <= a.length; j++) {
                if (j == a.length || a[j] != rangeStart + (j - i)) {
                    if (j - i >= 3) {
                        str.append('-').append(a[j - 1]);
                        i = j - 1;
                    }
                    str.append(',');
                    break;
                }
            }
        }
        System.out.println(str.substring(0,str.length()-1));
    }

    @Test
    public void formatDuration() {

        int seconds = 3663;
             String res = seconds == 0 ? "now" :
                   Arrays.stream(
                       new String[]{
                           formatTime("year",  (seconds / 31536000)),
                           formatTime("day",   (seconds / 86400)%365),
                           formatTime("hour",  (seconds / 3600)%24),
                           formatTime("minute",(seconds / 60)%60),
                           formatTime("second",(seconds%3600)%60)})
                         .filter(e->e!="")
                         .collect(Collectors.joining(", "))
                         .replaceAll(", (?!.+,)", " and ");

             System.out.println(res);
        }

    public static String formatTime(String s, int time){
        return time==0 ? "" : Integer.toString(time)+ " " + s + (time==1?"" : "s");
    }


}
