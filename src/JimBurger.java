import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class JimBurger {


    public int[] jimOrders(int[][] orders) {

        int col = orders[0].length;
        int b=0;
        for(int a=0;a< orders.length;a++) {
            System.out.println(orders[a][b] + " : " + orders[a][b+1]);
            b=0;
        }

        int sum=0;

        TreeMap<Integer, TreeSet<Integer>> endTimeAndOrderNoMap = new TreeMap<Integer, TreeSet<Integer>>();
        List<Integer> delivery = new ArrayList<>();

        b=0;

        for(int j=0;j< orders.length;j++) {
            sum = orders[j][b] + orders[j][b+1];
            if(endTimeAndOrderNoMap.containsKey(sum)) {
                endTimeAndOrderNoMap.get(sum).add(j+1);
            } else {
                TreeSet<Integer> orderNoSet = new TreeSet<Integer>();
                orderNoSet.add(j+1);
                endTimeAndOrderNoMap.put(sum,orderNoSet);
            }
            b=0;
        }

        for(TreeSet<Integer> set : endTimeAndOrderNoMap.values()) {
            for(Integer order : set) {
                delivery.add(order);
            }
        }

        int[] result;

        result = delivery.stream().mapToInt(k->k).toArray();

        Arrays.stream(result).forEach(System.out::println);
        return result;
    }


    @Test
    public void testJimBurger() {
        int[] result = jimOrders(new int[][] {{1,2,3},{3,3,3}});
        Arrays.stream(result).forEach(System.out::println);
    }
}
