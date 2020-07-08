import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ParameterizedTestNG {

  @Test(dataProvider = "provideNumbers")
  public void test(int number, int expected) {
      assertEquals(number + 10, expected);
  }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][] {
            { 10, 20 },
            { 100, 110 },
            { 200, 210 }
        };
    }

    @Test(dataProvider = "provideString")
    public void testPalindrome(String actual, String pal) {
      assertEquals(isPalindrome(actual),pal);
    }

    @DataProvider(name = "provideString")
    public Object[][] data() {
      return new Object[][] {
          {"tenet", "tenet"},
          {"kayak","kayak"},
          {"madam","madam"}
      };
    }

    public String isPalindrome(String s) {
      StringBuffer str = new StringBuffer(s);
      return str.reverse().toString();
    }

  public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

    if(lstOfArt.length==0 || lstOf1stLetter.length==0 ) {
      return "";
    }

    StringBuilder strb = new StringBuilder();

    String p = "(%s : %d)";

    Map<String,Integer> map = new HashMap<>();
    for(String s : lstOfArt) {
      String[] a = s.split(" ");
      String key = a[0].substring(0,1);
      int cnt = Integer.parseInt(a[1]);
      if(map.containsKey(key)){
        cnt = cnt + map.get(key);
        map.put(key,cnt);
      } else {
        map.put(key,cnt);
      }
    }

    for(String str : lstOf1stLetter) {
      if(map.containsKey(str)){
        strb.append(String.format(p,str,map.get(str))).append(" - ");
      } else {
        strb.append(String.format(p,str,0)).append(" - ");
      }
    }
    return strb.substring(0,strb.length()-2).trim();
  }

  @Test(dataProvider = "providerStock")
  public void testStockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
    assertEquals("(A : 200) - (B : 1140)",stockSummary(lstOfArt, lstOf1stLetter));
  }

  @DataProvider(name = "providerStock")
  public Object[][] datatest() {
    return new Object[][] {
        {new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"}, new String[]{"A", "B"}},
    };
  }

}
