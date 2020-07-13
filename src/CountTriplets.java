import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    public long getTriplets(long[] arr, int r) {

        long count=0;

        Map<Long,Long> rightMap = new HashMap<>();

        Map<Long,Long> leftMap = new HashMap<>();

        for (long value : arr) {
          rightMap.put(value,rightMap.getOrDefault(value,0L) + 1L);
        }

        for(long value : arr) {
            long left = value / r;
            long right = value * r;
            long l =0;
            long rr =0;

            rightMap.put(value,rightMap.get(value)-1);

            if(leftMap.containsKey(left) && value % r ==0) {
                l = leftMap.get(left);
            }

            if(rightMap.containsKey(right)){
                rr = rightMap.get(right);
            }

            leftMap.put(value,leftMap.getOrDefault(value,0L)+1L);

            count = count + (l*rr);
        }
        return count;
    }


    public long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> squareValues = new HashMap<>();
        Map<Long, Long> cubeValues = new HashMap<>();
        Long count = 0L;
        for (Long singleValue : arr) {
            Long square = singleValue * r;
            count += cubeValues.getOrDefault(singleValue, 0L);
            Long squareCount = squareValues.getOrDefault(singleValue, 0L);
            if(squareCount != 0) {
                cubeValues.put(square, cubeValues.getOrDefault(square, 0L) + squareCount);
            }
            squareValues.put(square, squareValues.getOrDefault(square, 0L) + 1);
        }
        return count;
    }


    @Test
    public void testTriplets() {
        long[] input = new long[] {1, 2, 2, 4};

        List<Long> in = Arrays.asList(1L, 5L, 5L, 25L, 125L);

        long count = countTriplets(in,5);

        System.out.println(count);
    }
}
