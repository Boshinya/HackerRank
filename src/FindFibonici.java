import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;

public class FindFibonici {

    public String isFibo(int n) {

        Set<Integer> fibo = getFibo(n);

        if(fibo.contains(n)){
            return "isFibo";
        } else {
            return "isNotFibo";
        }
    }


    public Set<Integer> getFibo(int n) {
        Set<Integer> fibo = new HashSet<>();

        int a =-1;
        int b=1;

        for(int i=0;i<=n;i++) {
            int c = a+b;
            a= b;
            b= c;
            fibo.add(c);
        }

        return fibo;
    }

    @Test
    public void testisFibo() {
        Assert.assertThat("Test failed",isFibo(12),is("isFibo"));
    }
}
