import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Factorial {

    public void getFactorial(int n) {
        TreeMap<Integer, Integer > primefact = new TreeMap<>();

        StringBuilder stringBuilder = new StringBuilder();


        for(int i=2;i<=n;i+=1) {
            if(isPrime(i)) {
                primefact.put(i,getpowers(i,n));
            }
        }

        String seperator = " *";

        for(int key : primefact.keySet()) {
            if(primefact.get(key) == 1) {
                stringBuilder.append(key + seperator + " ");
            } else {
                stringBuilder.append(key + "^" + primefact.get(key) + seperator + " ");
            }
        }

        System.out.println(stringBuilder.substring(0,stringBuilder.length()-2));
    }

    private boolean isPrime(int j) {
        for(int i=2;i<=Math.sqrt(j);i+=1) {
            if(j % i ==0)
                return false;
        }
        return true;
    }

    private int getpowers(int f,int n) {
        List<Integer> temp = new ArrayList<>();
        int count =0;
        for (int i = 1; i <= n; i++) {
                if (i % f == 0) {
                    ++count;
                    temp.add(i / f);
                }
            }

        List<Integer> ff = getpowerFromList(f,temp);
         count = count + ff.size();

        while(ff.size() >=1) {
            ff = getpowerFromList(f,ff);
            count = count + ff.size();
        }

        return count;
    }

    private List<Integer> getpowerFromList(int f, List<Integer> t) {
        List<Integer> temp = new ArrayList<>();
        for(int i : t) {
            if(i % f ==0) {
                temp.add(i/f);
            }
        }
        return temp;
    }

// CodeWars solution
    public String decomp(int n) {
        int[] exponentsOfPrimes = new int[n+1];
        while (n>1) {
            int x = n--;
            for (int i=2; i<=Math.sqrt(x); i++)
                if (x % i == 0) {
                    x /= i;
                    exponentsOfPrimes[i]++;
                    i = 1;
                }
            exponentsOfPrimes[x]++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < exponentsOfPrimes.length; i++) {
            if (exponentsOfPrimes[i] == 0) continue;
            if (exponentsOfPrimes[i] == 1) result.append(i + " * ");
            if (exponentsOfPrimes[i] >  1) result.append(i + "^" + exponentsOfPrimes[i] + " * ");
        }
        return result.substring(0,result.length()-3);
    }

    @Test
    public void testFactorial() {
        getFactorial(25);
    }
}
