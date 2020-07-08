import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SudokuValidator {

    public boolean isSudokuValid(int[][] sudoku) {
        int grid=0;

        List<Integer> gridSum= new ArrayList<>();

        for(int row=0;row<sudoku.length;row++) {
            int[] rowcount = new int[sudoku.length+1];
            int[] colcount = new int[sudoku.length+1];
            if (row == 0 || row == 3 || row == 6) {
                gridSum.clear();
            }
            for (int col = 0; col < sudoku.length; col++) {
                int t = row;
                rowcount[sudoku[row][col]]++;
                colcount[sudoku[t][col]]++;
                grid = grid + sudoku[col][t];
                if (col == 2) {
                    if (gridSum.size() >= 3) {
                        gridSum.set(0, gridSum.get(0) + grid);
                    } else {
                        gridSum.add(grid);
                    }
                    grid = 0;
                } else if (col == 5) {
                    if (gridSum.size() >= 3) {
                        gridSum.set(1, gridSum.get(1) + grid);
                    } else {
                        gridSum.add(grid);
                    }
                    grid = 0;
                } else if (col == 8) {
                    if (gridSum.size() >= 3) {
                        gridSum.set(2, gridSum.get(2) + grid);
                    } else {
                        gridSum.add(grid);
                    }
                    grid = 0;
                }
                ++t;
            }
            if (row == 2 || row == 5 || row == 8) {
                for (int s : gridSum) {
                    if (s != 45) {
                        return false;
                    }
                }
            }

            for(int j=0;j<rowcount.length;j++) {
                if(rowcount[j] > 1 || colcount[j] > 1) {
                    return false;
                }
            }
        }

        return true;
    }


    public int sequence(int[] arr) {

        if(arr.length==0) {
            return 0;
        }

        int max_ending_here = 0, max_so_far = 0;
        for (int v : arr) {
            max_ending_here = Math.max(0, max_ending_here + v);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;

    }


    @Test
    public void testSudoku() {
        int[][] s = new int[][] {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        s[0][0]++;
        s[1][1]++;
        s[0][1]--;
        s[1][0]--;
       Assert.assertFalse(isSudokuValid(s));
    }

    @Test
    public void testSubArray() {
        Assert.assertEquals(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}),6);

    }
}
