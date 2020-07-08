import org.junit.Test;

import java.util.BitSet;
import java.util.Scanner;

public class BitSetExample {

    @Test
    public void bitset() {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        BitSet B1 = new BitSet(size);

        BitSet B2 = new BitSet(size);

        int q = sc.nextInt();

        for(int i=0;i<q;i++) {
            String op = sc.next();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int x = sc.nextInt();
            int y = sc.nextInt();
            switch(op) {
                case "AND":
                    if(x == 1) {
                        B1.and(B2);
                    } else {
                        B2.and(B1);
                    }
                    break;
                case "OR":
                    if(x == 1) {
                        B1.or(B2);
                    } else {
                        B2.or(B1);
                    }
                    break;
                case "XOR":
                    if(x == 1) {
                        B1.xor(B2);
                    } else  {
                        B2.xor(B1);
                    }
                    break;
                case "FLIP":
                    if(x == 1) {
                        B1.flip(y);
                    } else {
                        B2.flip(y);
                    }
                    break;
                case "SET":
                    if(x == 1) {
                        B1.set(y);
                    } else {
                        B2.set(y);
                    }
                    break;
            }
            System.out.print(B1.cardinality()+ " " + B2.cardinality());
            System.out.println();
        }
    }
}
