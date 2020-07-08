import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Main {

        private static final Scanner scanner = new Scanner(System.in);


        void selectionSort() {
            int arr[] = {10, 20, 55, 3, 4, 1};
            int length = arr.length;

            for (int i = 0; i < length - 1; i++) {

                int min_index = i;

                for (int j = i + 1; j < length; j++) {
                    if (arr[j] > arr[min_index]) {
                        min_index = j;
                    }
                }
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }

            for (int i = 0; i < length - 1; i++) {
                System.out.println("sorted array" + arr[i]);
            }
        }

        public void sumOftheArrayElements() {
            int arr[] = {9, 9, 9, 9};

            int carry = 1;

            int result[] = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                int total = arr[i] + carry;

                if (total == 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }

                result[i] = total % 10;

                if (carry == 1) {
                    result = new int[arr.length + 1];
                    result[i] = 1;
                }
            }

            for (int i = 0; i < result.length; i++) {
                System.out.println("sorted array" + result[i] + "\n");
            }
        }


        public void bubbleSort() {
            int arr[] = {3,1,2};
            int length = arr.length;

            int temp;
            int count = 0;

            int diff = Math.abs(arr[0] - arr[1]);

            for (int i = 0; i < length - 1; i++) {
                if (diff < Math.abs(arr[i] - arr[i + 1])) {
                    diff = Math.abs(arr[i] - arr[i + 1]);
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    count++;
                }
            }

            System.out.println("sorted array");
            for (int i = 0; i < length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            System.out.println("Number of Swaps   " + count);
        }


        public void fizzBuzz(int number) {
            for (int i = 1; i < 101; i++) {

                if (i > 2 && ((i % 3 == 0) || (i % 10 == 3) || (i / 10 == 3))) {
                    System.out.println("Fizz" + i + "\n");
                } else if (i > 4 && ((i % 5 == 0) || (i / 10 == 5))) {
                    System.out.println("Buzz" + i + "\n");
                }
                if ((i % 15 == 0) || (i == 35) || (i == 53)) {
                    System.out.println("Fizz & Buzz" + i + "\n");
                }
            }
        }


        public void checkPalindrome() {
            String test = "Idhaya";

            String reverse = "";

            for (int i = test.length() - 1; i >= 0; i--) {
                reverse = reverse + test.charAt(i);
            }
            boolean flag = false;
            for (int i = 0; i < reverse.length(); i++) {
                if (test.charAt(i) != reverse.charAt(i)) {
                    System.out.println("No Palindrome");
                    break;
                }
                flag = true;
            }

            if (flag == true) {
                System.out.println("Palindrome");
            }
        }

        @Test
        public void revereseRecursion() {
            String s = "imreverse";

            System.out.println(reverse(s));
        }

        public String reverse(String str) {
            if (str.isEmpty()) {
                return str;
            }
            // saves the last letter of the word in the variable c
            char c = str.charAt(str.length() - 1);
            // take the last letter saved in c and joins the sub string of everything without the first letter and runs it again.
            return c + reverse((str.substring(0, str.length() - 1)));
        }


        public void printMissingNumber() {
            int[] numbers = {1, 2, 3, 3, 7};
            int count = 7;

            int missingCount = count - numbers.length;
            BitSet bitSet = new BitSet(count);
            for (int number : numbers) {
                bitSet.set(number - 1);
            }
            System.out
                .printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);

            int lastMissingIndex = 0;
            for (int i = 0; i < missingCount; i++) {
                lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
                System.out.println(++lastMissingIndex);
            }
        }


        public void bruteforce() {
            String[] input = {"one", "two", "three", "four"};

            boolean flag = false;
            for (int i = 0; i < input.length; i++) {
                for (int j = i + 1; j < input.length; j++) {
                    if (input[i].equals(input[j])) {
                        System.out.println("Duplicate found" + true);
                        flag = true;
                        break;
                    }
                }
            }
            if (false == flag) {
                System.out.println("Duplicate Not found" + false);
            }
        }


    public boolean isPrimeNumber(int num) {
            if(num< 2)
                return false;
            if(num <= 3) {
                return true;
            } else if(num % 2 ==0) {
                return false;
            }

            for(int i = 3;i<=Math.sqrt(num); i+=2) {
                if(num % i == 0) {
                  return false;
                }
            }
        return true;
    }

    @Test
    public void testPrimeNumber() {
        Assert.assertTrue(isPrimeNumber(17));
        Assert.assertFalse(isPrimeNumber(10));
    }


        public void duplicateNumberinArray() {
            int[] intarr = {1, 2, 3, 7, 5, 7};

            int prev = intarr[0];

            int duplicate = 0;

            for (int i = 0; i < intarr.length; i++) {
                for (int j = i + 1; j < intarr.length; i++) {
                    if (prev != intarr[j]) {
                        prev = intarr[j];
                    } else {
                        duplicate = prev;
                        break;
                    }
                }
                prev = intarr[i];
            }

            int[] revarr = new int[intarr.length];

            for (int i = intarr.length - 1; i >= 0; --i) {
                revarr[(intarr.length - 1) - i] = intarr[i];
            }

            for (int j = 0; j < revarr.length; j++) {
                System.out.println("reverse" + revarr[j]);
            }
            System.out.println("duplicate" + duplicate);
        }


        public void twoDArray() throws IOException {

            int[][] twodarray = new int[6][6];

            for (int i = 0; i < 6; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 6; j++) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    twodarray[i][j] = arrItem;
                }
            }
            int[][] hourglass = new int[6][6];

            int colShift = 0;
            int columnInc;
            int rowShift = 0;
            int rowInc;
            int max;

            int sumOfHourGlass = 0;
            int[] sum = new int[16];
            int count = 0;
            int sum1d = 0;
            for (int j = 0; j < twodarray[0].length - 2; j++) {
                rowInc = rowShift + 3;
                for (int i = 0; i < twodarray[1].length - 2; i++) {
                    columnInc = colShift + 3;
                    for (int row = rowShift; row < rowInc; row++) {
                        for (int column = colShift; column < columnInc; column++) {
                            if ((row == rowShift + 1) && (column != colShift + 1)) {
                                hourglass[row][column] = 0;
                            } else {
                                hourglass[row][column] = twodarray[row][column];
                            }
                            sum1d = sum1d + hourglass[row][column];
                            System.out.print(hourglass[row][column]);
                        }
                        System.out.print("Su of 1d-->" + sum1d);
                        sumOfHourGlass = sumOfHourGlass + sum1d;
                        sum1d = 0;
                        System.out.print("\n");
                    }
                    System.out.print("sumOfHourGlass-->" + sumOfHourGlass);
                    sum[count] = sumOfHourGlass;
                    count++;
                    sumOfHourGlass = 0;
                    colShift++;
                    System.out.print("\t");
                }
                rowShift++;
                colShift = 0;
            }

            for (int i = 0; i < sum.length; i++) {
                System.out.print("Hour Glass total-->" + sum[i]);
                System.out.print("\n");
            }

            max = sum[0];

            for (int i = 1; i < sum.length; i++) {
                if (sum[i] > max) {
                    max = sum[i];
                }
            }
            System.out.print("Max of the hour Glass-->" + max);
        }


    @Test
    public void twoDArrayHourGlass() {
        int[][] a = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                a[i][j] = arrItem;
            }
        }

        int rows = a.length;
        int col = a[0].length;
        int max = -63;

        for(int i=0;i<rows-2;i++) {
            for(int j=0;j<col-2;j++) {
                int current_sum = a[i][j] + a[i][j+1]+ a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1]+ a[i+2][j+2];
                max = Math.max(max,current_sum);
            }
        }
        System.out.println("Max sum of the hour glass " + max);
    }


        public void reverseArray() {
            int[] a = {1, 4, 3, 2};
            int[] reverse = new int[a.length];
            for (int i = a.length - 1, j = 0; i >= 0; i--, j++) {
                reverse[j] = a[i];
            }

            for (int i = 0; i < reverse.length; i++) {
                System.out.println("Reverse" + reverse[i]);
            }
        }

        public void sparseArrays() {
            String[] strArray = new String[]{"aba", "baba", "aba", "xzxb"};
            String[] query = new String[]{"aba", "xzxb", "ab"};
            int count = 0;
            int[] results = new int[query.length];

            for (int i = 0; i < query.length; i++) {
                count = 0;
                for (int j = 0; j < strArray.length; j++) {
                    if (strArray[j].equals(query[i])) {
                        ++count;
                    }
                }
                results[i] = count;
            }

            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i]);
            }
        }


        public void arrayManipulation() {

            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] queries = new int[m][3];

            for (int i = 0; i < m; i++) {
                String[] queriesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int queriesItem = Integer.parseInt(queriesRowItems[j]);
                    queries[i][j] = queriesItem;
                }
            }
            long[] result = new long[n + 1];
            long[] temp = new long[queries[0].length];
            long max = 0;

            for (int i = 0; i < queries.length; i++) {
                for (int j = 0; j < queries[0].length; j++) {
                    temp[j] = queries[i][j];
                }
                result = fillArray(temp, result);
                max = findMaxinArray(result);
            }
            System.out.print(max);
        }

        private static long[] fillArray(long[] arr, long[] result) {
            int index1 = (int) arr[0];
            int index2 = (int) arr[1];
            long value = arr[2];

            for (int i = index1; i <= index2; i++) {
                result[i] = result[i] + value;
            }
            return result;
        }

        private static long findMaxinArray(long[] arr) {
            long max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }

        public void getAnagram() {
            String str1 = "cde";
            String str2 = "abc";
            int count = 0;
            int minimum = 0;

            Map<Character, Integer> count1 = getcount(str1);
            Map<Character, Integer> count2 = getcount(str2);

            for (char key : count1.keySet()) {
                count = count + count1.get(key);
            }

            for (char key : count2.keySet()) {
                count = count + count2.get(key);
            }

            System.out.println("count character" + count);
            minimum = count;

            for (char key : count1.keySet()) {
                if (!count2.containsKey(key)) {
                    count = count - count1.get(key);
                }
            }

            for (char key : count2.keySet()) {
                if (!count1.containsKey(key)) {
                    count = count - count2.get(key);
                }
            }

            for (char key : count2.keySet()) {
                if (count1.containsKey(key)) {
                    if (count2.get(key) > count1.get(key)) {
                        count = count - (count2.get(key) - count1.get(key));
                    } else if (count1.get(key) > count2.get(key)) {
                        count = count - (count1.get(key) - count2.get(key));
                    }
                }
            }
            System.out.println("count character" + (minimum - count));
        }

        private Map<Character, Integer> getcount(String str1) {
            Map<Character, Integer> count1 = new HashMap<>();
            int count = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (count1.containsKey(str1.charAt(i))) {
                    count1.put(str1.charAt(i), (count1.get(str1.charAt(i))) + 1);
                } else {
                    count = 1;
                    count1.put(str1.charAt(i), count);
                }
            }
            return count1;
        }

        public void isValid() throws IOException {

            String s = scanner.nextLine();

            Map<Character, Integer> occurance = new HashMap<>();
            int count = 0;
            int temp = 0;
            int max = 0;
            int diff = 0;
            int commoncount;
            for (int i = 0; i < s.length(); i++) {
                if (occurance.containsKey(s.charAt(i))) {
                    count = occurance.get(s.charAt(i));
                    occurance.put(s.charAt(i), ++count);
                } else {
                    count = 1;
                    occurance.put(s.charAt(i), count);
                }
            }

            System.out.println(occurance);

            commoncount = occurance.get(s.charAt(0));
            for (int value : occurance.values()) {
                if (value != commoncount) {
                    temp++;
                    max = value;
                }
            }

            if (temp == 1) {
                if (commoncount > max) {
                    diff = commoncount - max;
                } else {
                    diff = max - commoncount;
                }
                if (diff == 1 || max == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (temp == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        public void specialString() {

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String s = scanner.nextLine();

            long index = 1;
            long count = 0;
            long occu = 0;
            Boolean flag = false;
            Map<Character, ArrayList<Long>> sublist = new HashMap<Character, ArrayList<Long>>();
            char[] chararr = s.toCharArray();

            for (char c : chararr) {
                ArrayList tempList = null;
                if (sublist.containsKey(c)) {
                    tempList = sublist.get(c);
                    if (tempList == null) tempList = new ArrayList();
                    tempList.add(index);
                } else {
                    tempList = new ArrayList();
                    tempList.add(index);
                }
                sublist.put(c, tempList);
                index++;
            }

            for (char key : sublist.keySet()) {

            }

            if (sublist.size() != 1) {
                count = count + s.length();
            }

            System.out.println("count is" + count);
        }


        public void activityNotifications() {
            int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5, 9};

            int d = 4;
            double median = 0.0;
            int notification = 0;
    //        String[] nd = scanner.nextLine().split(" ");
    //
    //        int n = Integer.parseInt(nd[0]);
    //
    //        int d = Integer.parseInt(nd[1]);
    //
    //        int[] expenditure = new int[n];
            int index = d;

    //        String[] expenditureItems = scanner.nextLine().split(" ");
    //        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    //
    //        for (int i = 0; i < n; i++) {
    //            int expenditureItem = Integer.parseInt(expenditureItems[i]);
    //            expenditure[i] = expenditureItem;
    //        }

            int lastElement = expenditure.length - 1;

            int t = 0;

            for (int i = index; i < lastElement; i++) {
                int[] count = getCounts(expenditure, i, t);
                median = getMedian(count, d);
                if (expenditure[i] >= (2 * median)) {
                    notification++;
                }
                t++;
            }
            System.out.println("Notification--->" + notification);
        }

        private static double getMedian(int[] count, int d) {
            int sum = 0;
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (2 * sum < d) continue;
                else if (2 * sum == d) return (2 * i + 1) / 2.0;
                else return i * 1.0;
            }
            return -1.0;
        }

        private static int[] getCounts(int[] arr, int d, int init) {
            int[] count = new int[10];

            for (int i = init; i < d; i++) {
                count[arr[i]]++;
            }
            return count;
        }

        public void smallestNumber() {
    //        int[] arr = {5, 4, 3, 2 };

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            Arrays.sort(arr);
            int index = 0;
            int count = 0;

            int diff = Math.abs(arr[0] - arr[1]);
            for (int i = 1; i < arr.length - 1; i++) {
                if (diff > Math.abs(arr[i] - arr[i + 1])) {
                    diff = Math.abs(arr[i] - arr[i + 1]);
                }
            }
            int[] subarr = new int[2 * arr.length];

            for (int i = 0; i < arr.length - 1; i++) {
                if (diff == Math.abs(arr[i] - arr[i + 1])) {
                    subarr[index] = arr[i];
                    subarr[index + 1] = arr[i + 1];
                    index = index + 2;
                }
            }

            for (int i = 0; i < subarr.length; i++) {
                if (subarr[i] != 0) {
                    count++;
                }
            }

            int[] result = new int[count];
            for (int i = 0; i < result.length; i++) {
                result[i] = subarr[i];
                System.out.println("fhdsjfs diff " + result[i]);
            }

            System.out.println("Minimum diff " + diff);
        }

        @Test
        public void testQuickSort() {
            int[] a = {4, 7, 3, 2, 9, 5, 10, 1};

            quickSort(a, 0, a.length - 1);

            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }

        private void quickSort(int[] a, int left, int right) {
            if (left >= right) {
                return;
            }
            int pivot = a[(left + right) / 2];

            int index = partition(a, left, right, pivot);
            quickSort(a, 0, index - 1);
            quickSort(a, index, right);
        }

        private int partition(int[] a, int left, int right, int pivot) {
            while (left <= right) {

                while (a[left] < pivot) {
                    left++;
                }

                while (a[right] > pivot) {
                    right--;
                }

                if (left <= right) {
                    swap(a, left, right);
                    left++;
                    right--;
                }
            }
            return left;
        }

        private void swap(int[] a, int left, int right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }


        public Boolean isAnagram(String str1, String str2) {
            Map<Character, Integer> charcount2 = getCharactersCount(str2);

            if (str1 == null || str2 == null || str1 == "" || str2 == "") {
                return false;
            }

            if (str1.length() != str2.length()) {
                return false;
            }

            for (int i = 0; i < str1.length(); i++) {
                if (!charcount2.containsKey(str1.charAt(i))) return false;

                int temp = charcount2.get(str1.charAt(i));
                if (temp == 0) {
                    return false;
                } else {
                    charcount2.put(str1.charAt(i), --temp);
                }
            }
            return true;
        }

        private Map<Character, Integer> getCharactersCount(String str) {
            Map<Character, Integer> charCount = new HashMap<>();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                char key = str.charAt(i);
                if (charCount.containsKey(key)) {
                    count = charCount.get(key);
                    charCount.put(key, ++count);
                } else {
                    count = 1;
                    charCount.put(key, count);
                }
            }
            return charCount;
        }


        @Test
        public void anagramTest() {
            String str1 = "anagramm".replaceAll("[\\s+]", "").toLowerCase();
            String str2 = "marganaa".replaceAll("[\\s+]", "").toLowerCase();
            assertThat(isAnagram(str1, str2), equalTo(false));
            assertFalse(isAnagram(str1, str2));
        }

        @Test
        public void anagramTest2() {
            String str1 = "Debit card ".replaceAll("[\\s+]", "").toLowerCase();
            String str2 = "Bad credit".replaceAll("[\\s+]", "").toLowerCase();
            assertThat(isAnagram(str1, str2), equalTo(true));
            assertTrue(isAnagram(str1, str2));
        }

        public void anagramTest3() {
            String str1 = "".replaceAll("[\\s+]", "").toLowerCase();
            String str2 = "".replaceAll("[\\s+]", "").toLowerCase();
            assertThat(isAnagram(str1, str2), equalTo(false));
            assertFalse(isAnagram(str1, str2));
        }

        @Test
        public void icecreamParlor() {
            int m = 4;
            int[] arr = {1, 4, 5, 3, 2};
            int[] result = new int[2];
            for (int i = 0; i < arr.length; i++) {
                int diff = m - arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (diff == arr[j]) {
                        result[0] = i + 1;
                        result[1] = j + 1;
                        break;
                    }
                }
            }

            for (int i = 0; i < result.length; i++) {
                System.out.println("gdjsgs   " + result[i]);
            }
        }

        @Test
        public void missingNumbers() {

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] brr = new int[m];

            String[] brrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                int brrItem = Integer.parseInt(brrItems[i]);
                brr[i] = brrItem;
            }

            Arrays.sort(arr);

            Map<Integer, Integer> list1 = new HashMap<>();

            Map<Integer, Integer> list2 = new HashMap<>();

            Arrays.sort(brr);

            List<Integer> output = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                int count = 1;
                if (list1.containsKey(arr[i])) {
                    count = list1.get(arr[i]);
                    list1.put(arr[i], ++count);
                } else {
                    list1.put(arr[i], ++count);
                }
            }

            for (int i = 0; i < brr.length; i++) {
                int count = 1;
                if (list2.containsKey(brr[i])) {
                    count = list2.get(brr[i]);
                    list2.put(brr[i], ++count);
                } else {
                    list2.put(brr[i], ++count);
                }
            }

            for (int key : list2.keySet()) {
                if (list1.containsKey(key)) {
                    if (!list1.get(key).equals(list2.get(key))) {
                        output.add(key);
                    }
                } else {
                    output.add(key);
                }
            }

            int[] array = output.stream().mapToInt(i -> i).toArray();

            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }

        @Test
        public void testFibonoci() {
            int a = fibo(8);
            System.out.println(a);
        }

        public int fibo(int number) {

            if (number == 0) {
                return 0;
            }

            if (number == 1) {
                return 1;
            }

            return fibo(number - 1) + fibo(number - 2);
        }

        @Test
        public void testlcs() {

            String a = "HARRY";
            String b = "SALLY";
            System.out.println(a.substring(0, a.length() - 2));

    //       lcs(a,b);

            System.out.println(recurlcs(a, b));
        }

        public void lcs(String a, String b) {
            int[][] C = new int[a.length() + 1][b.length() + 1];

            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    if (a.charAt(i) == b.charAt(j)) {
                        C[i + 1][j + 1] = C[i][j] + 1;
                    } else {
                        C[i + 1][j + 1] = Math.max(C[i + 1][j], C[i][j + 1]);
                    }
                }
            }
            System.out.println(C[a.length()][b.length()]);
        }

        public int recurlcs(String a, String b) {

            if (a.length() == 0 || b.length() == 0) {
                return 0;
            }

            int l = a.length();

            int m = b.length();

            if (a.charAt(l - 1) == b.charAt(m - 1)) {
                return recurlcs(a.substring(0, l - 1), b.substring(0, m - 1)) + 1;
            } else {
                return Math.max(recurlcs(a.substring(0, l - 1), b.substring(0, m)),
                                recurlcs(a.substring(0, l), b.substring(0, m - 1)));
            }
        }

        @Test
        public void regex() {
            String str = "000.12.12.034";
            String zeroToFiftyFive = "(\\d{1,2}|[0|1]\\d{2}|2[0-4]\\d|25[0-5])";

            String pattern = zeroToFiftyFive + "\\." + zeroToFiftyFive + "\\." + zeroToFiftyFive + "\\." + zeroToFiftyFive;

            Pattern pat = Pattern.compile(pattern);

            System.out.println(str.matches(pattern));
        }

        @Test
        public void minBribes() {
            int[] q = {1, 2, 3, 4, 5};

            int count = 0;

            boolean isSorted = false;

            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < q.length - 1; i++) {

                    if (q[i] - (i + 1) > 2) {
                        System.out.println("Too Chaotic");
                    }

                    if (q[i] > q[i + 1]) {
                        int temp = q[i];
                        q[i] = q[i + 1];
                        q[i + 1] = temp;
                        ++count;
                        isSorted = false;
                    }
                }
            }
            System.out.println(count);
        }

        long lastInvocation = 0l;

        @Test
        public void testFunctionCall() throws InterruptedException {
            wasIcalledinLast5sec();
            Thread.sleep(50001);
            assertThat(wasIcalledinLast5sec(), is(true));
        }

        private boolean wasIcalledinLast5sec() {
            boolean status = false;
            long currenms = System.currentTimeMillis();
            status = currenms - lastInvocation >= 5000l;
            lastInvocation = currenms;
            return status;
        }

        public static class ScheduleTask extends TimerTask {

            public void run() {
                executeAtevery5sec();
                System.out.println(System.currentTimeMillis());
            }

            public static void executeAtevery5sec() {
                System.out.println(System.currentTimeMillis());
            }

            public static void testfu() {
                Timer timer = new Timer();
                TimerTask task = new ScheduleTask();
                timer.schedule(task, 2000, 5000);  // 2000 - delay (can set to 0 for imme
            }
        }

        @Test
        public void test() {
            ScheduleTask.testfu();
        }

        @Test
        public void valley() {
            String s = "UDDDUDUU";
            int v = 0;     // # of valleys
            int lvl = 0;   // current level
            for (char c : s.toCharArray()) {
                if (c == 'U') ++lvl;
                if (c == 'D') --lvl;

                // if we just came UP to sea level
                if (lvl == 0 && c == 'U') ++v;
            }
            System.out.print(v);
        }

        @Test
        public void maxSumOfSubsets() {
            int[] a = {1, 2, 3, 4, 5};
            int len = a.length;
            List<Integer> sum = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {

                for (int j = i; j < a.length; j++) {
                    if (len > 0) {
                        sum.add(subset(a, i, len));
                    }
                    len = len - 1;
                }
                len = a.length;
            }
            System.out.println(sum);

            System.out.println(sum.stream().mapToInt(value -> value).max().getAsInt());
        }

        private int subset(int[] a, int start, int end) {
            int[] subset = new int[end];
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum = sum + a[i];
            }
            for (int i = start; i < subset.length; i++) {
                System.out.print(subset[i]);
            }
            System.out.println();
            return sum;
        }

        @Test
        public void MaxSumOfSubsetwithKadeneAlgo() {
            int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

            int max_current = a[0];

            int max_global = a[0];

            for (int i = 1; i < a.length; i++) {
                max_current = Math.max(a[i],max_current+a[i]);

                if (max_current > max_global) {
                    max_global = max_current;
                }
            }

            System.out.println(max_global);
        }

        @Test
        public void testMissingNumber() {
            System.out.print(testgsdgd());
        }

        public int testgsdgd() {
            int[] A = {2, 3, 7, 6, 8, -1, -10, 15};

            Arrays.sort(A);
            int missing = 0;

            if (A[0] < 0) {
                return 1;
            }

            for (int i = 0; i < A.length - 1; i++) {
                if (A[i + 1] - A[i] > 1) {
                    missing = A[i] + 1;
                }
            }
            if (missing == 0) {
                missing = A[A.length - 1] + 1;
            }
            return missing;
        }

        @Test
        public void sibling() {
            int N = 5678;

            int maxNumber = 0;

            int multiply = 1;

            int[] digitOccurance = new int[10];

            String intToStr = Integer.toString(N);

            for (int i = 0; i < intToStr.length(); i++) {
                digitOccurance[intToStr.charAt(i) - '0']++;
            }

            for (int i = 0; i <= 9; i++) {
                while (digitOccurance[i] > 0) {
                    maxNumber = maxNumber + (i * multiply);
                    digitOccurance[i]--;
                    multiply = multiply * 10;
                }
            }

            System.out.println(maxNumber);
        }

        @Test // Nexmo Technical test
        public void widePath() {

            int[] x = {5, 5, 5, 7, 7, 7};

            int[] y = {3, 4, 5, 1, 3, 7};

            int xAxisMax = x[0];

            for (int i = 1; i < x.length; i++) {
                if (x[i] > xAxisMax) {
                    xAxisMax = x[i];
                }
            }

            Map<Integer, ArrayList<Integer>> coOrdinates = new HashMap<>();

            for (int i = 0, j = 0; j < y.length; i++, j++) {
                ArrayList tempList;
                if (coOrdinates.containsKey(x[i])) {
                    tempList = coOrdinates.get(x[i]);
                    if (tempList == null) new ArrayList<>();
                    tempList.add(y[i]);
                } else {
                    tempList = new ArrayList();
                    tempList.add(y[i]);
                }
                coOrdinates.put(x[i], tempList);
            }

            System.out.println(coOrdinates);

            List<Integer> width = new ArrayList<>();
            for (int i = 1; i <= xAxisMax; i++) {
                if (coOrdinates.containsKey(i)) {
                    width.add(i);
                }
            }

            System.out.println(width);

            int max = width.get(1) - width.get(0) > 1 ? width.get(1) - width.get(0) : 0;

            for (int i = 1; i < width.size() - 1; i++) {
                int diff = width.get(i + 1) - width.get(i);
                if (diff > 1 && diff > max) {
                    max = diff;
                }
            }

            System.out.println(max);
        }

        @Test
        public void extractDigits() {
            int i = 9853767;

            List<Integer> number = new ArrayList<>();
            while (i > 0) {
                number.add(i % 10);
                i = i / 10;
            }
            number.sort(Comparator.reverseOrder());
            for (int j = 0; j < number.size(); j++) {
                System.out.println(number.get(j));
            }
        }

        @Test
        public void equalizer() {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int maxInA = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > maxInA) {
                    maxInA = arr[i];
                }
            }

            int[] count = new int[maxInA + 1];

            for (int i = 0; i < arr.length; i++) {
                count[arr[i]]++;
            }

            int max = count[arr[0]];

            for (int i = 1; i < arr.length; i++) {
                if (count[arr[i]] > max) {
                    max = count[arr[i]];
                }
            }

            System.out.println(arr.length - max);
        }

        @Test
        public void maxSpacestationDist() {
            int n = 20;
            int[] c = {13, 1, 11, 10, 6};
            Arrays.sort(c);
            if (n == c.length) {
                System.out.println(0);
            }

            Arrays.sort(c);
            int maxDistance = c[0];
            for (int i = 1; i < c.length; i++) {
                int distance = (c[i] - c[i - 1]) / 2;
                if (maxDistance < distance) maxDistance = distance;
            }
            int lastGap = (n - 1) - c[c.length - 1];
            int dist = (lastGap < maxDistance) ? maxDistance : lastGap;

            System.out.print(dist);
        }

        @Test
        public void roundedGrade() {
            List<Integer> grades = Arrays.asList(73, 67, 38, 33);
            List<Integer> roundedGrades = new ArrayList<>();

            for (int grade : grades) {

                if (grade >= 38) {
                    int rem = grade % 5;
                    if ((grade + (5 - rem) - grade) < 3) {
                        roundedGrades.add(grade + (5 - rem));
                    } else {
                        roundedGrades.add(grade);
                    }
                } else {
                    roundedGrades.add(grade);
                }
            }
            System.out.println(roundedGrades);
        }

        @Test
        public void kangarooMeetingPoint() {
            int x1 = 0;
            int v1 = 2;
            int x2 = 5;
            int v2 = 3;

            int firstK;
            int secondK;

            firstK = x1 + v1;
            secondK = x2 + v2;

            while (secondK != firstK) {
                firstK = firstK + v1;
                secondK = secondK + v2;
                if ((firstK - secondK) > firstK) {
                    System.out.println("NO");
                    break;
                }
            }

            System.out.println("YES");

            String date = "%s.09.%s";
            String.format(date, 12, 1907);
        }

        @Test
        public void checkMagazine() {
    //      String[] magazine = {"two", "times", "three" ,"is" ,"not" ,"four"};
    //      String[] note = {"two", "times","two","is","four"};

            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0]);

            int n = Integer.parseInt(mn[1]);

            String[] magazine = new String[m];

            String[] magazineItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                String magazineItem = magazineItems[i];
                magazine[i] = magazineItem;
            }

            String[] note = new String[n];

            String[] noteItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                String noteItem = noteItems[i];
                note[i] = noteItem;
            }

            Hashtable<String, Integer> magWordCount = new Hashtable<>();
            int count;
            boolean flag = false;

            for (int i = 0; i < magazine.length; i++) {
                if (magWordCount.containsKey(magazine[i])) {
                    count = magWordCount.get(magazine[i]);
                    magWordCount.put(magazine[i], count++);
                } else {
                    count = 1;
                    magWordCount.put(magazine[i], count);
                }
            }

            for (String key : note) {
                if (!magWordCount.containsKey(key)) {

                }
                int counter = magWordCount.get(key) - 1;

                if (counter == 0) {
                    magWordCount.remove(key);
                } else {
                    magWordCount.put(key, counter);
                }
            }
        }

        @Test
        public void subString() {

            String s1 = "hello";
            String s2 = "hi";
            List<String> subset1 = subset(s1);
            List<String> subset2 = subset(s2);
            boolean flag = false;

            for (String s : subset1) {
                for (String m : subset2) {
                    if (s.equalsIgnoreCase(m)) {
                        flag = true;
                        break;
                    }
                }
            }

            for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                {
                    if (s1.indexOf(c) > -1 && s2.indexOf(c) > -1) flag = true;
                }
            }
            if (flag) {
                System.out.print("Yes");
            } else {
                System.out.print("No");
            }
        }

        private List<String> subset(String s1) {
            int len = s1.length();

            List<String> subset = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                while (len > i) {
                    subset.add(s1.substring(i, Math.max(0, len--)));
                }
                len = s1.length();
            }
            return subset;
        }

        @Test
        public void freqQueries() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> queries = new ArrayList<>();

            IntStream.range(0, q).forEach(i -> {
                try {
                    queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            List<Integer> result = new ArrayList<>();

            Map<Integer, Integer> freq = new HashMap<>();
            int count = 0;

            for (List<Integer> l : queries) {

                if (l.get(0) == 1) {
                    if (freq.containsKey(l.get(1))) {
                        count = freq.get(l.get(1));
                        freq.put(l.get(1), ++count);
                    } else {
                        count = 1;
                        freq.put(l.get(1), count);
                    }
                } else if (l.get(0) == 2) {
                    if (freq.containsKey(l.get(1))) {
                        if (freq.get(l.get(1)) > 0) {
                            count = freq.get(l.get(1));
                            freq.put(l.get(1), --count);
                        }
                    }
                } else if (l.get(0) == 3) {
                    if (freq.containsValue(l.get(1))) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                }
            }

            System.out.println(result);
        }

        @Test
        public void countTriplets() {
            List<Long> arr = (List<Long>) Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);
            long r = 3L;

            Map<Long, Long> rightMap = getOccurenceMap(arr);
            Map<Long, Long> leftMap = new HashMap<>();
            long numberOfGeometricPairs = 0;

            for (long val : arr) {
                long countLeft = 0;
                long countRight = 0;
                long lhs = 0;
                long rhs = val * r;
                if (val % r == 0) {
                    lhs = val / r;
                }
                Long occurence = rightMap.get(val);
                rightMap.put(val, occurence - 1L);

                if (rightMap.containsKey(rhs)) {
                    countRight = rightMap.get(rhs);
                }
                if (leftMap.containsKey(lhs)) {
                    countLeft = leftMap.get(lhs);
                }
                numberOfGeometricPairs += countLeft * countRight;
                insertIntoMap(leftMap, val);
            }
            System.out.println(numberOfGeometricPairs);
        }

        private static Map<Long, Long> getOccurenceMap(List<Long> test) {
            Map<Long, Long> occurenceMap = new HashMap<>();
            for (long val : test) {
                insertIntoMap(occurenceMap, val);
            }
            return occurenceMap;
        }

        private static void insertIntoMap(Map<Long, Long> occurenceMap, Long val) {
            if (!occurenceMap.containsKey(val)) {
                occurenceMap.put(val, 1L);
            } else {
                Long occurence = occurenceMap.get(val);
                occurenceMap.put(val, occurence + 1L);
            }
        }

        @Test
        public void spinWords() {
            String sentence = "emocleW";
            String spin = "";
            String[] temp = sentence.split("\\s+");

            for (int i = 0; i < temp.length; i++) {
                if (temp[i].length() >= 5) {
                    temp[i] = revers(temp[i]);
                }

                spin = spin + temp[i];
                if (temp.length > 1) {
                    spin = spin + " ";
                }
            }

            System.out.println(spin);
        }

        private String revers(String s) {
            String t = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                t = t + s.charAt(i);
            }
            return t;
        }

        @Test
        public void possibleSubString() {
            String s = "kkkk";

            Map<Integer, List<String>> map = new HashMap<>();

            List<String> list = new ArrayList<>();

            List<String> substring = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                int len = s.length();
                while (len > i) {
                    substring.add(s.substring(i, len));
                    len--;
                }
            }
            System.out.print(substring);
            System.out.print(substring.size());

            for (String str : substring) {
                if (map.containsKey(str.length())) {
                    if (list.isEmpty()) {
                        list = new ArrayList<>();
                    } else {
                        list = map.get(str.length());
                        list.add(str);
                        map.put(str.length(), list);
                    }
                } else {
                    list = new ArrayList<>();
                    list.add(str);
                    map.put(str.length(), list);
                }
            }
            System.out.println(map);

            int totalAnagram = 0;
            for (int key : map.keySet()) {
                List<String> temp = map.get(key);
                totalAnagram = totalAnagram + anagram(temp);
            }
            System.out.println(totalAnagram);
        }

        private int anagram(List<String> list) {
            int anagrm = 0;

            System.out.println(list);

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    char[] a = list.get(i).toCharArray();
                    char[] b = list.get(j).toCharArray();
                    Arrays.sort(a);
                    Arrays.sort(b);
                    if (Arrays.equals(a, b)) {
                        anagrm = anagrm + 1;
                    }
                }
            }
            return anagrm;
        }

        @Test
        public void digital_root() {
            int n = 456;

            int res = rec(n);
            System.out.print(res);
        }

        private int rec(int n) {
            if (n < 10) {
                return n;
            }
            int singledigit = 0;
            while (n > 0) {
                int r = n % 10;
                singledigit = singledigit + r;
                n = n / 10;
            }
            return rec(singledigit);
        }

        @Test
        public void tribonacci() {

            double[] s = {1, 1, 1};

            int n = 10;

            double[] result = new double[n];

            for (int i = 0; i < n; i++) {
                if (i < 3) {
                    result[i] = s[i];
                } else {
                    result[i] = result[i - 1] + result[i - 2] + result[i - 3];
                }
            }

            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }

        @Test
        public void isPalindrome() {
            String s = "aaab";

            StringBuffer stringBuffer = new StringBuffer(s);
            int len = stringBuffer.length();

            for (int i = 0, j = len - 1; i < len / 2; i++) {
                if (stringBuffer.charAt(i) == stringBuffer.charAt(j)) {
                    j--;
                } else {
                   if(palindrome(stringBuffer.deleteCharAt(i))) {
                       System.out.print(i);
                       break;
                    } else {
                       System.out.print(j);
                       break;
                   }
                }
            }
        }

        private boolean palindrome(StringBuffer s) {
            for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }

        @Test
        public void alternate() {
            String s ="beabeefeab";
            Set<Character> char_set = new HashSet<Character>();

            for (int i = 0; i < s.length(); i++) {
                char_set.add(s.charAt(i));
            }

            Character[] char_arr = char_set.toArray(new Character[char_set.size()]);
            int max = 0;

            for (int j = 0; j < char_arr.length - 1; j++) {
                for (int k = j + 1; k < char_arr.length; k++) {
                    String pattern = "(^[" + char_arr[j] + char_arr[k] + "])";
                    String trimmedStr = s.replaceAll(pattern, "");
                    if (isTwoCharacter(trimmedStr) && trimmedStr.length() > max) {
                        max = trimmedStr.length();
                    }
                }
            }
            System.out.print(max);
        }

        static boolean isTwoCharacter(String s) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    return false;
                }
            }
            return true;
        }

        @Test
        public void longestAltString() {
            final int NUM_LETTERS=  26;
            String str ="beabeefeab";
            int length = str.length();
            /* Edge case */
            if (length <= 1) {
                System.out.println(0);
                return;
            }

            /* Create arrays representing the 26^2 subproblems */
            int [][] pair  = new int[NUM_LETTERS][NUM_LETTERS];
            int [][] count = new int[NUM_LETTERS][NUM_LETTERS];

            for (int i = 0; i < length; i++) {
                char letter   = str.charAt(i);
                int letterNum = letter - 'a';

                /* Update row */
                for (int col = 0; col < NUM_LETTERS; col++) {
                    if (pair[letterNum][col] == letter) {
                        count[letterNum][col] = -1;
                    }
                    if (count[letterNum][col] != -1) {
                        pair[letterNum][col] = letter;
                        count[letterNum][col]++;
                    }
                }

                /* Update column */
                for (int row = 0; row < NUM_LETTERS; row++) {
                    if (pair[row][letterNum] == letter) {
                        count[row][letterNum] = -1;
                    }
                    if (count[row][letterNum] != -1) {
                        pair[row][letterNum] = letter;
                        count[row][letterNum]++;
                    }
                }
            }

            /* Find max in "count" array */
            int max = 0;
            for (int row = 0; row < NUM_LETTERS; row++) {
                for (int col = 0; col < NUM_LETTERS; col++) {
                    max = Math.max(max, count[row][col]);
                }
            }
            System.out.println(max);
        }

        @Test
        public void encode(){

            String word = "   ()(   ".toLowerCase();

            word = word.toLowerCase();

            StringBuilder str = new StringBuilder(word);

            Map<Character,List<Integer>> map = new HashMap<>();
            List<Integer> index = new ArrayList<>();

            for(int i=0;i<word.length();i++) {
                char key = word.charAt(i);
                if(map.containsKey(key)) {
                    if(index.isEmpty())
                        index = new ArrayList<>();
                    index = map.get(key);
                    index.add(i);
                    map.put(key,index);
                } else {
                    index = new ArrayList<>();
                    index.add(i);
                    map.put(key,index);
                }
            }


            for(char key : map.keySet()) {
                if(map.get(key).size() > 1) {
                    for(int i : map.get(key)) {
                        str.setCharAt(i, ')');;
                    }

                } else {
                    str.setCharAt(map.get(key).get(0),'(');
                }
            }

            System.out.println(str.toString());
        }

       @Test
        public void encodetest(){
            String word = "   ()(   ".toLowerCase();

            String dup = "aabbcdef";
            Set<Character> ch = new HashSet<>();

            for(int i=0;i<dup.length();i++) {

                if(!ch.add(dup.charAt(i))) {
                    System.out.print(dup.charAt(i));
                }
            }

            word = word.toLowerCase();
            String result = "";
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
            }
            System.out.println( result);

            ch.forEach(System.out::print);
        }

        @Test
        public void anagramMinTest() {

            String s = "asdfjoieufoa";

            int len = s.length();

            String str1 = s.substring(0,(len/2));
            String str2 = s.substring(len/2,len);

            System.out.println(str1 + str2);


            Map<Character, Integer> charcount2 = getCharactersCount(str2);
            Map<Character, Integer> charcount1 = getCharactersCount(str1);

            int min=0;
            int count=0;

            for (int i = 0; i < str1.length(); i++) {
                if (!charcount2.containsKey(str1.charAt(i))) {
                    min = min+1;
                } else {
                    if(charcount2.get(str1.charAt(i)) < charcount1.get(str1.charAt(i))) {
                        min = min + (charcount1.get(str1.charAt(i)) - charcount2.get(str1.charAt(i)));
                        charcount2.put(str1.charAt(i),charcount1.get(str1.charAt(i)));
                    }
                }
            }
            System.out.println(min);
        }

        @Test
        public void writeAFile() throws IOException {
            List<String> fruits = Arrays.asList("banana","Apple","orange","berry");
            List<String> veg = Arrays.asList("carrot","cabbage");
            File file = new File("/Users/bothi/text.txt");

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file,true), "utf-8"))) {
                for(String str : fruits) {
                    writer.write(str);
                    writer.write("\n");
                }
                for(String str : veg) {
                    writer.append(str);
                    writer.write("\n");
                }
            }
        }

        @Test
       public void sumOfPowers() {
         long a =1;
         long b = 100;
        List<Long> result = new ArrayList<>();

        long sum=0;

        for(long i=a;i<=b;i++) {
            long j=1L;
            String number = String.valueOf(i);
                for(int k=0;k<number.length();k++,j++) {
                    long digit = Character.getNumericValue(number.charAt(k));
                    sum = sum + (long) Math.pow(digit,j);
                }
            if(sum == i) {
                result.add(i);
            }
        sum =0;
        }

        if(result.isEmpty()) {
            System.out.println( "Emptyy");
        }

        System.out.println( result);
    }
        @Test
        public void challenge() {
            List<Integer> a = Arrays.asList(17,28,30);
            List<Integer> b = Arrays.asList(99,16,8);
            List<Integer> points = new ArrayList<>();

            int bob=0;
            int alice=0;

            for(int i=0;i<a.size();i++) {
                if(a.get(i) > b.get(i)) {
                    ++alice;
                 } else {
                    ++bob;
                }
            }

            points.add(alice);
            points.add(bob);
            points.stream().forEach(System.out::println);
        }

        @Test
        public void plusMinus() {

            int[] arr = {-4, 3, -9, 0, 4, 1};
            double pos =0;
            double neg=0;
            double zero=0;
            int len = arr.length;

            for(int i=0;i<len;i++) {
                if(arr[i] > 0) {
                    pos++;
                } else if(arr[i] < 0) {
                    neg++;
                } else if(arr[i] ==0){
                    zero++;
                }
            }

            System.out.println((pos) / len);
            System.out.println(String.format("%.6f",( neg) / len));
            System.out.println(String.format("%.6f",( zero) / len));
        }
        @Test
        public void staircase() {
            int n = 4;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j < n - 1 - i) {
                        System.out.print(" ");
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
        }
        @Test
        public void timeConversion() {

            String s = "12:40:22AM";

            String f = "%02d:%s:%s";

            int hour=0;

            String[] time = s.split(":");

            if(time[2].substring(2,4).equals("PM")) {
                hour = Integer.parseInt(time[0]) + 12;
            } else {
                hour = Integer.parseInt(time[0]) - 12;
            }

            System.out.println(String.format(f,hour,time[1],time[2].substring(0,2)));

        }

        @Test
        public void counterGame() {
            long n = 132;
            if(n ==1 ) {
                System.out.println( "Richard");
            }

            String name = "Louise";
            while (n >=1) {
                n = callGame(n, name);
                if( n == 1 ) {
                    break;
                }
                if(name.equals("Louise")) {
                    name = "Richard";
                } else {
                    name = "Louise";
                }
            }
            System.out.println(name);
        }

        private static long callGame(long n, String name) {
            long temp = n;
            if(Long.bitCount(n) == 1) {
                n = n /2 ;
            } else {
                n = temp - Long.highestOneBit(n);
            }
            return n;
        }

        public List<Character> duplicate(String str) {

            Map<Character,Integer> map = new HashMap<>();
            char[] cha = str.toCharArray();

            List<Character> dupchars = new ArrayList<>();

            for(int i=0;i<cha.length;i++) {
                if(map.containsKey(cha[i])) {
                    int count = map.get(cha[i]);
                    map.put(cha[i], ++count);
                } else {
                    map.put(cha[i],1);
                }
            }

            for(char key : map.keySet()) {
                if(map.get(key) > 1) {
                    dupchars.add(key);
                }
            }

            return dupchars;
        }

        @Test
        public void testDup() {

            assertThat("fdgdsj",duplicate("jvfaff"),hasItems('a','f'));
        }

        public boolean isDigitsOnly(String str) {

            char[] a = str.toCharArray();

           String reg = "^[a-z0-9]+$";

           Pattern p = Pattern.compile(reg);

            Matcher m = p.matcher(str);

            if(m.matches()) {
                return true;
            } else {
                return false;
            }
        }

        @Test
        public void testDigitsOnly() {
            assertEquals(true, isDigitsOnly("aa123455bb"));
        }
        @Test
        public void replaceChar() {
            String str ="Java is Great";

            System.out.println(str.replaceAll(" ","%20"));
        }
        @Test
        public void removeDuplicate() {
            String str = "bananas";
            StringBuilder stringBuilder = new StringBuilder();
            Set<Character> s = new LinkedHashSet<>();

            for(int i=0;i<str.length();i++) {
                s.add(str.charAt(i));

            }

            Iterator iterator = s.iterator();

            while (iterator.hasNext()){
                stringBuilder.append(iterator.next());
            }

            System.out.println(stringBuilder);

        }
        @Test
        public void findSubString() {
            String str1 = "this";
            String str2 ="hi";

            System.out.print(str1.indexOf(str2));
        }

        @Test
        public void areTheySame() {
            int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
            int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};

            if(a == null || b == null) {
                System.out.println(false);
            }

            int[] aa = Arrays.stream(a).map(t -> t *t).toArray();

            Arrays.sort(aa);
            Arrays.sort(b);

           System.out.println(aa.length == b.length && Arrays.equals(aa,b));
        }

        @Test
        public void primeNumbers() {
            int n =100;

            for(int i=1;i<n;i+=1) {
                if(i%2 !=0 || i%3 !=0) {
                   System.out.println(i);
                }
            }

        }

        @Test
        public void breakingRecords() {

                int[] scores = {10, 5, 20, 20, 4, 5, 2, 25, 1};

                int[] count = new int[2];

                int min = scores[0];

                int max = scores[0];

                int high =0;

                int low =0;

                for(int i=1;i<scores.length;i++) {
                    if(scores[i] > max) {
                        high++;
                        max= scores[i];
                    } else if(scores[i] < min ) {
                        low++;
                        min = scores[i];
                    }
                }
                count[0] = high;
                count[1] = low;

            Arrays.stream(count).forEach(System.out::println);
        }

        @Test
        public void birdsCount() {
            List<Integer> arr = Arrays.asList(1,1,2,2,3);
            arr.sort(Comparator.naturalOrder());
            int[] count = new int[arr.size()+1];

            for(int b : arr) {
                count[b]++;
            }

            int maxCount = count[1];
            int t=0;

            for(int i=2;i< count.length;i++) {
                if(count[i] >= maxCount) {
                    maxCount = count[i];
                    t=i;
                }
            }

            System.out.println(t-1);

            for(int i=1;i<count.length;i++) {
                if(maxCount == count[i]) {
                    System.out.println(i);
                    break;
                }
            }
        }

        @Test
        public void bonappttie() {
            List<Integer> bill = Arrays.asList(3, 10, 2, 9);
            int k =1;
            int b =12;

            int actual =0;

            for(int a: bill) {
                actual+=a;
            }
            actual = actual-(bill.get(k)) / 2;

            if(actual == b) {
                System.out.println("Bon Appetit");
            } else {
                if (actual > b) {
                    System.out.println(actual - b);
                } else {
                    System.out.println(b - actual);
                }
            }

        }

        @Test
        public void sockMerchant() {
            int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20 };
            Arrays.sort(ar);
            Map<Integer,Integer> count = new HashMap<>();

            int pair =0;

            for(int i=0;i<ar.length;i++) {
                if(count.containsKey(ar[i])){
                    int c = count.get(ar[i]);
                    count.put(ar[i],++c);
                }else{
                    count.put(ar[i],1);
                }
            }

            for(int key : count.keySet()) {
                pair += count.get(key) /2;
            }

            System.out.println(pair);
        }


        public int firstDuplicate() {
            int[] a = {2,1,3,2,1};

            /* Solution with HashMap, it has space complexity*/


    //        LinkedHashSet<Integer> s = new LinkedHashSet<>();
    //
    //        for(int value : a ) {
    //            if(s.contains(value)) {
    //                return value;
    //            } else {
    //                s.add(value);
    //            }
    //        }

            for(int i=0;i<a.length;i++) {
               if(a[Math.abs(a[i])-1] <0){
                   return (a[i]);
               } else {
                   a[Math.abs(a[i])-1] = - a[Math.abs(a[i])-1];
               }
            }
            return -1;
        }
        @Test
        public void testFirstDuplicate() {
            Assert.assertEquals(2, firstDuplicate());
        }

        @Test
        public void squareRootOfNumbers() {
            int[] a = { -6,-4,1,3,2,5};

            int[] result = new int[a.length];

            int left=0;
            int right = a.length-1;

            for(int i= a.length-1;i>=0;i--) {
                if(Math.abs(a[left]) > a[right]) {
                    result[i] = a[left] * a[left];
                    left++;
                } else {
                    result[i] = a[right] * a[right];
                    right--;
                }
            }
            Arrays.stream(result).forEach(System.out::println);
        }
        @Test
        public void pigIt() {
            String str = "Hello world '";
    //        StringBuffer strb = new StringBuffer();
    //
    //        String re = "[!?\\']";
    //
    //        String[] a = str.split("\\s+");
    //
    //        for(String s : a) {
    //            String temp = "";
    //            if(s.matches(re)) {
    //                temp = s;
    //            } else {
    //                temp = s.substring(1) + s.charAt(0) + "ay";
    //            }
    //            strb.append(temp+" ");
    //        }
    //        strb.toString().trim();


            String t = Arrays.stream(str.split("\\s+")).map(j ->j.matches("[a-zA-Z]+")?j.substring(1).concat(j.substring(0,1)):j).collect(
                Collectors.joining(" "));

            System.out.println(t);


        }

        @Test
        public void greedy(){
            int[] dice = new int[] { 2, 4, 4, 5, 4};

            int[] count = new int[dice.length+2];

            int total = 0;

            for (int die : dice) {
                count[die]++;
            }

            total = count[1] / 3*1000 + count[1] %3 *100 + count[2]/3 * 200 + count[3]/3 * 300 +
                    count[4] / 3 * 400 + count[5] / 3 * 500 + count[5] % 3 * 50 + count[6] /3 * 600;
            System.out.println(total);
        }

        @Test
        public void sumIntervals() {
            int[][] intervals = new int[][] {{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}};

            int start = intervals[0][0];
            int end = intervals[0][1];
            int diff = end - start;
            int sum= diff;

            for(int i=0;i<intervals.length-1;i++) {
                for(int j=i+1;j<intervals.length;j++) {
                    if(intervals[i][0] > intervals[j][0]) {
                        int[] temp = intervals[i];
                        intervals[i] = intervals[j];
                        intervals[j] = temp;
                    }
                }
            }


            for(int i=1;i<intervals.length;i++) {
                if( end < intervals[i][1] && end > intervals[i][0] ){
                    int temp = end-start;
                    sum = sum - temp;
                    diff = intervals[i][1] - start;
                    start = intervals[i][0];
                    end = intervals[i][1];
                } else {
                    diff = intervals[i][1] - intervals[i][0];
                }
                sum = sum + diff;
            }

            System.out.println(sum);
        }

        @Test
        public  void findDay() {
            int month = 05;
            int day = 20;
            int year = 2005;
            System.out.println(LocalDate.of(year,month,day).getDayOfWeek().name());
        }

        @Test
        public void CurrecnyFormatConversion() {
            double c = 12340.134;
            System.out.println(NumberFormat.getCurrencyInstance(Locale.FRANCE).format(c));
            System.out.println(NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(c));


        }
        @Test
        public void testSeries() {
            int a = 5;
            int b =3;
            int n =5;

            int s= a + b;

            System.out.print(s + " ");

            for(int i=1;i<n;i++) {
                s = s + (2 << (i-1)) * b;
                System.out.print(s + " ");
            }

        }

        @Test
        public void perimeter() {
            BigInteger n = new BigInteger("5");
            BigInteger result;

            int v  = n.intValue();

            result = fibobig(++v).multiply(BigInteger.valueOf(4));

            System.out.println(result);

        }

        private BigInteger fibobig(int n) {
            BigInteger result = BigInteger.ZERO;
            BigInteger a = new BigInteger("-1");
            BigInteger b = BigInteger.ONE;
            BigInteger sum = new BigInteger("0");

            for(int i=0;i<=n;i++) {
                result = a.add(b) ;
                a = b;
                b = result;
                sum = sum.add(result);
            }
            return sum;
        }


    public void add(int ... d) {
        int total=0;

        String seperator="";

        for(int i=0;i<d.length;i++) {
            total = total + d[i];
            System.out.print(seperator+d[i]);
            seperator="+";
        }
        System.out.println("=" +total);
    }

   @Test
    public void testAdd() {
            int[] test = new int[] {1,2,3,4,5};
            int[] test1 = new int[] {1,2,3,4};
            int[] test2 = new int[] {1,2,3};
            int[] test3 = new int[] {1,2};
            add(test);
            add(test1);
            add(test2);
            add(test3);
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
        String temp="";

        for (int i = 1; i < s.length(); i++) {
            if (i <= (s.length() - k)) {
                temp = s.substring(i, i + k);
                if (smallest.compareTo(temp) > 0) {
                    String t = smallest;
                    smallest = temp;
                    temp = t;
                }
                if (largest.compareTo(temp) < 0) {
                    largest = temp;
                }
            }
        }
        return smallest + "\n" + largest;
    }

    @Test
    public void testgetSmallestAndLargest() {
        String s = "fsdfsDLJFSJGIHEKHIPEINNNFIGHKkjgksfgjrotyotoyjtkjkLJOIOEHEKHKKDJGKFGJkfjhglfhjtrhkjfkhjnfglhkjflgjhtrljhfljhfgljhfgljhfgljhtrklyjhtrkjhfgkljhfgjhfljhtrljlfjhfgljhfglkjhflyjtljtrlyjhtryjtrtykhrktherktjhtrkyjhkujhtykhtryhrthHKLJHLHRLHTLRHLKHTRLKHLHRLHLKHLKHKLHLKHLHKLHKHJKHKJHKJHJKHKHJKHKHHLHLHLHKHKJHKJKKHKHKHKHKHHKHKHKHKHkhktryhtlhtklhtrkyhtrkyhtrkjyhtrkyhrekthtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkrtkyhtrklyhjrOEOHKDHFksdhfklHLHKHLHKKJHJHKGKLHLHJLJHLHLHLHLHHLHLHLHH";
        int k = 100;
        System.out.println(getSmallestAndLargest(s, k));
    }

    @Test
    public void DuplicateWordRegEx() {
            String word = "This thiS is IS duplicate Duplicate Word wOrD";

            String regex = "\\b(\\w+)(\\s+\\1\\b)+";

            Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);

            Matcher m = p.matcher(word);

            while(m.find()) {
                word = word.replaceAll(m.group(), m.group(2));
                System.out.println(word);
            }
    }
    @Test
    public void setExample() {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        List<HashSet<String>> setLeft = new ArrayList<>();

        HashSet<String> setRight = new HashSet<>();

        for(int i=0;i<pair_left.length;i++) {
            HashSet<String> set = new HashSet<>();
            set.add(pair_right[i]);
            set.add(pair_left[i]);
            setLeft.add(set);
            System.out.println(setLeft.size());
        }

        setLeft.forEach(System.out::println);
        BitSet B1 = new BitSet(10);
        BitSet B2 = new BitSet(10);
        B1.set(4);
    }

    @Test
    public void arrayGame() {
        int leap =5;
        int[] game = new int[] {0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1 };

        System.out.println(isSolvable(leap, game, 1));
    }

    private boolean isSolvable(int l, int[] g, int i) {
        if (i < 0 || g[i] == 1) return false;
            if(i>=g.length-1 || i+l>=g.length-1) {
                return true;
            }

         g[i] = 1;

         return isSolvable(l,g,i+1) || isSolvable(l,g,i-1) || isSolvable(l,g,i+l);
    }

    @Test
    public void fiboseries() {
           System.out.print( fib(6));
    }

    private int fib(int n) {
            if(n<=0 ) {
                return 0;
            }
        if(n ==1 ){
            return  1;
        }

        return fib(n-1) + fib(n-2);
    }

    @Test
    public void fact() {
            System.out.println(factorial(10));
    }

    private int factorial(int n) {
          if(n <=0) {
              return 1;
          }
        return  n * factorial(n-1);
    }
}
