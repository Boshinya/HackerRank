import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class SubArray {

    public static int[] input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter input array");

        int n = sc.nextInt();

        String[] arr = sc.nextLine().split("\\s+");

        int[] input = new int[n];

        for(int i=0;i<arr.length;i++) {
            input[i] = Integer.parseInt(arr[i]);
        }
        return input;
    }

    public int sumOfSubArray(int[] a) {
        int count=0;

        for(int j=0;j<a.length;j++) {
            for(int i=j;i<a.length;i++) {
                int t = getSumOfSubArray(a, j, i);
                if(t < 0) {
                    System.out.println(t);
                    ++count;
                }
            }
        }
        return count;
    }

    private int getSumOfSubArray(int[] a,int start, int end) {
        int sum=0;
        for(int i=start;i<=end;i++) {
            sum = sum + a[i];
        }
        return sum;
    }

    @Test
    public void testSumOfSubArray() {
        int[] array = new int[] {1,-2,4,-5,1};
        Assert.assertEquals(9,sumOfSubArray(array));
    }


}
