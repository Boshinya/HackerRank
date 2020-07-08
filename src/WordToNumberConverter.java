import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordToNumberConverter {

    public Map<String,Integer> map = new HashMap<>();


    public int getWordToNumber(String str) {
        map = buildWordMap();

        String[] a = str.split("\\s+");

        for(int i = 0; i < a.length; i++){
            if(a[i].equalsIgnoreCase("and")){
                a = removeElementUsingCollection(a, i);
                break;
            }
        }

        int result =0;

        if(a.length ==1) {
            result = getDigits(a,a.length-1);
        }else if(a.length==2) {
            result = getDigits(a,0) * map.get(a[1]);
        } else if(a.length ==3) {
            if(a[2].contains("-")) {
                result = map.get(a[0]) * map.get(a[1]) + getDigits(a, a.length - 1);
            } else {
                if(a[2].equalsIgnoreCase("thousand")) {
                    result = map.get(a[0]) * map.get(a[1]) * map.get(a[2]);
                } else{
                    result = map.get(a[0]) * map.get(a[1]) + map.get(a[2]);
                }
            }
        } else if(a.length == 4) {
            if(a[2].equalsIgnoreCase("thousand")) {
                result = (map.get(a[0]) * map.get(a[1])* map.get(a[2])) + map.get(a[3]);
            } else if(a[a.length-1].equalsIgnoreCase("thousand")){
                result = (map.get(a[0]) * map.get(a[1]) + map.get(a[2])) * map.get(a[3]);
            } else {
                result = map.get(a[0]) * map.get(a[1]) + map.get(a[2]) * map.get(a[3]);
            }
        } else if(a.length ==5) {
            if(a[2].equalsIgnoreCase("thousand")) {
                result = (map.get(a[0]) * map.get(a[1])* map.get(a[2])) + map.get(a[3]) * map.get(a[4]);
            } else if(a[a.length-1].equalsIgnoreCase("thousand")){
                result = (map.get(a[0]) * map.get(a[1]) + map.get(a[2])) * map.get(a[3]);
            } else {
                result = getDigits(a, 0) * map.get(a[1]) + getDigits(a, 2) * map.get(a[3]) + getDigits(a,a.length-1);
            }

        } else if(a.length > 5) {
            result = (map.get(a[0]) * map.get(a[1]) + getDigits(a, 2)) * map.get(a[3]) + map.get(a[4]) * map.get(a[5]) + getDigits(a,a.length-1);
        }


        return result;

    }

    private static String[] removeElementUsingCollection( String[] arr, int index ){
        List<String> tempList = new ArrayList<String>(Arrays.asList(arr));
        tempList.remove(index);
        return tempList.toArray(new String[0]);
    }

    public int getDigits(String[] a, int index) {
        int result=0;
        if(a[index].contains("-")){
            String[] t = a[index].split("-");
            result = map.get(t[0]) + map.get(t[1]);
        } else {
            result = map.get(a[index]);
        }
        return result;
    }


    private Map<String,Integer> buildWordMap() {
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        map.put("ten",10);
        map.put("eleven",11);
        map.put("twelve",12);
        map.put("thirteen",13);
        map.put("fourteen",14);
        map.put("fifteen",15);
        map.put("sixteen",16);
        map.put("seventeen",17);
        map.put("eighteen",18);
        map.put("nineteen",19);
        map.put("twenty",20);
        map.put("thirty",30);
        map.put("forty",40);
        map.put("fifty",50);
        map.put("sixty",60);
        map.put("seventy",70);
        map.put("eighty",80);
        map.put("ninety",90);
        map.put("hundred",100);
        map.put("thousand",1000);
        map.put("million",1000000);
        return map;
    }

    public int codeWarsVersion(String str) {
        String[] numArray = str.split("[ |-]");
        int number=0;
        map = buildWordMap();
        for (int i = 0; i < numArray.length; i++) {
            for (String key : map.keySet()) {
                if (numArray[i].toLowerCase().equals(key)) {
                    if (map.get(key) == 100) {
                        int temp = number % 100;
                        number -= temp;
                        number += temp * (map.get(key));
                    } else if (map.get(key) > 100) number *= (map.get(key));
                    else number += map.get(key);
                    break;
                }
            }
        }
        return number;
    }

    @Test
    public void testWordToNumber() {
        Assert.assertEquals(101, codeWarsVersion("one hundred one"));
        Scanner sc = new Scanner(System.in);

        BigInteger b = sc.nextBigInteger();

        BigInteger a = sc.nextBigInteger();

        b.add(a);
        b.multiply(a);


    }
}
