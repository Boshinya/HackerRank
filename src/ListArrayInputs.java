import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListArrayInputs {

    public void arrayInputProcess() {

        Scanner sc = new Scanner(System.in);

        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> queries = new ArrayList<>();

        int n = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        while(n>0) {
            String[] input = sc.nextLine().split(" ");
            List<Integer> temp = new ArrayList<>();
            for(int i=1;i<input.length;i++) {
                temp.add(Integer.parseInt(input[i]));
            }
            list.add(temp);
            n--;
        }

        int q = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        while (q>0) {
//            String[] input = sc.nextLine().split(" ");
//            List<Integer> temp = new ArrayList<>();
//            for (String s : input) {
//                temp.add(Integer.parseInt(s));
//            }
//            queries.add(temp);
//            q--;
//        }

        for(int j=0;j< q;j++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            try {
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }


//        for(List<Integer> qu : queries) {
//                if(list.get(qu.get(0)-1).size() > 0 && list.get(qu.get(0)-1).size() >= qu.get(1)) {
//                    System.out.println(list.get(qu.get(0)-1).get(qu.get(1)-1));
//                } else {
//                    System.out.println("ERROR!");
//                }
//        }

    }

    @Test
    public void testArrayList() {
        arrayInputProcess();
    }
}
