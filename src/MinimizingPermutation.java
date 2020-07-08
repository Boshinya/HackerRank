import org.testng.annotations.Test;

import java.util.HashMap;

public class MinimizingPermutation {

    @Test
    public void minimumSwap() {
        int[] arr= new int[]{4, 3, 6, 5,1,2};

        boolean[] visited = new boolean[arr.length+1];

        HashMap<Integer,Integer> map = new HashMap<>();

        int swapCount =0;

        for(int i=1;i<visited.length;i++) {
            map.put(i,arr[i-1]);
        }


        for(int j=1;j<map.size();j++) {
            int nextNode;
            if(!visited[j]) {
                visited[j] = true;

                if(map.get(j) == j) {
                    continue;
                } else {
                    int c = map.get(j);
                    while (!visited[c]) {
                        visited[c] = true;
                        nextNode = map.get(c);
                        c = nextNode;
                        ++swapCount;
                    }

                }

            }

        }

        System.out.println(swapCount);
        main(5);
    }

    private static void main(int l) {
        System.out.println(l);
    }

    public void main(String[] args) {
        System.out.println("gkhgghjs");
    }


}


