import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeNumbers {

    public boolean isPrime(int n) {
        if(n <=3 ) {
            return true;
        }

        for(int i=3;i*i<n;i+=2) {

            if(n%i==0) {
                return false;
            }
        }

        return true;
    }


    public void readJsonFile() throws FileNotFoundException {
       String fileName = System.getProperty("user.dir")+"/src"+ "/sampleJson.json";
       File file = new File(fileName);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line="";

        try {
            line = bufferedReader.readLine();
            while (line!= null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.readJsonFile();
        assert primeNumbers.isPrime(100);
        assertThat("OK",primeNumbers.isPrime(17),is(true));
        assertThat("OK",primeNumbers.isPrime(19),is(true));
        assertThat("OK",primeNumbers.isPrime(125),is(false));
        System.out.println("Test Passed");
    }
}
