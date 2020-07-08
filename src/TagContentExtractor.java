import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

    @Test
    public void tagContentExtract() {
        String str = "<h1>this is a test</h1>";

        String regex = "<(.+)>([^<]+)</\\1>";

        Pattern r = Pattern.compile(regex);

        boolean matchFound = false;

        Matcher m = r.matcher(str);

        while(m.find()) {
            System.out.println(m.group(2));
            matchFound = true;
        }

        if(!matchFound) {
            System.out.println("None");
        }
    }
}
