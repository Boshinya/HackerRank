import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SumOfIntervals {


    public int sumOfIntervals(int[][] intervals) {
        Set<Integer> set = new HashSet<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            for (int i = start; i < end; i++) {
                set.add(i);
            }
        }

        return set.size();
    }

    public int codeWarriorSolution(int[][] intervals) {
        return intervals == null ? 0 : (int) Arrays.stream(intervals)
                                             .flatMapToInt(interval -> IntStream.range(interval[0], interval[1]))
                                                       .distinct()
                                                       .count();
    }

    @Test
    public void testSumOfIntervals() {
        int[][] intervals = new int[][] {{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}};
        Assert.assertEquals(sumOfIntervals(intervals), 19);
        Assert.assertEquals(codeWarriorSolution(new int[][]{{1, 2}, {6, 10}, {11, 15}}),9);
    }

}



