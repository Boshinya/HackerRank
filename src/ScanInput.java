import org.junit.Test;

import java.util.Scanner;

public class ScanInput {


    @Test
    public void getInputFromStdIn() {

        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();

        double d = scanner.nextDouble();

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        StringBuffer stringBuffer = new StringBuffer();
        String[] s = scanner.nextLine().split(" ");

        for(int j=0;j<s.length;j++) {
            stringBuffer.append(s[j]);
            if(j < s.length-1) {
                stringBuffer.append(" ");
            }
        }
        System.out.println("String: " + stringBuffer);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
