import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVFileReader {

    public void readCSVFile() throws IOException{
        File file = new File(System.getProperty("user.dir") + "/src" + "/WL-Bothi-test_7-3-2018_11.50.47.csv");

        List<List<String>> lines = new ArrayList<>();

        String line="";

        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {

            while((line = bf.readLine()) !=null) {
                String[] l = line.split(",");
                lines.add(Arrays.asList(l));
            }

        } catch (IOException e) {
            throw new IOException("Problem with reading files");
        }

        lines.forEach(System.out::println);

    }


    public static void main(String[] args) throws IOException {
        CSVFileReader csvFileReader = new CSVFileReader();

        csvFileReader.readCSVFile();

    }
}
