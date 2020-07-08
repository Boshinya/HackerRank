import java.util.Scanner;
public class CheckDataTypes {

    public static void checkDataType() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number");

        long x = sc.nextLong();

        if(x>=Byte.MIN_VALUE && x<=Byte.MAX_VALUE) {
            System.out.println("* Byte" + "\n" + "* short" + "\n" + "* Integer" + "\n" + "* Long");
        } else if(x>=Short.MIN_VALUE && x<=Short.MAX_VALUE) {
            System.out.println("* short" + "\n" + "* Integer" + "\n" + "* Long");
        } else if(x>=Integer.MIN_VALUE && x<=Integer.MAX_VALUE){
            System.out.println("* Integer" + "\n" + "* Long");
        } else if(x >= Long.MIN_VALUE && x<=Long.MAX_VALUE) {
            System.out.println("* Long");
        }

        double a = Math.pow(Double.valueOf(5),Double.valueOf(2));
        Double.valueOf(a).longValue();

    }

    public static void main(String[] args) {
        checkDataType();
        CheckDataTypes checkDataTypes = new CheckDataTypes();
        checkDataTypes.getClass().getName();
    }
}
