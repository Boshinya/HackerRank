import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckBalance {

    public int luckBalance(int k, int[][] contests) {

        int row = contests.length;

        List<Integer> luck = new ArrayList<>();
        int total =0;

        for(int i=0;i<row;i++) {
                if(contests[i][1]==0) {
                   total = total+contests[i][0];
                } else {
                    luck.add(contests[i][0]);
                }

        }

        Collections.sort(luck);

        for(int j=0;j<luck.size();j++) {
            if(j< luck.size()-k) {
                total=total-luck.get(j);
            } else {
                total = total+luck.get(j);
            }
        }

        return total;
    }

    @Test
    public void testLuckBalance() {
        int[][] a = new int[][] {{5,1},
                                 {2,1},
                                 {1,1},
                                 {8,1},
                                 {10,0},
                                 {5,0}};
        int k=3;
        System.out.println(luckBalance(k,a));
    }

}
