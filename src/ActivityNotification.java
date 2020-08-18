import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class ActivityNotification {

    public int activityNotifications(int[] expenditure, int d) {

        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });


        PriorityQueue<Integer> highers = new PriorityQueue<>();

        int[] count = new int[201];

        for(int i=0;i<d;i++) {
            count[expenditure[i]]++;
        }

        double median =0;
        int freq = 0;
        int remove =0;

        for(int i=0;i<d;i++) {
            addNumbers(expenditure[i], lowers, highers);
            rebalance(lowers, highers);
        }

        for(int i=d;i<expenditure.length;i++) {
                median = getMedianUsingCounter(expenditure,count,d);
                if (expenditure[i] >=  2 * median) {
                    freq++;
                }
                count[expenditure[i]]++;
                count[expenditure[i-d]]--;
        }

        System.out.println("Frequency" + freq);
        return freq;
    }




    private static void addNumbers(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
            if (lowers.size() == 0 || number < lowers.peek()) {
                lowers.add(number);
            } else {
                highers.add(number);
            }
    }

    private static void removeNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.contains(number)) {
            lowers.poll();
        } else {
            highers.poll();
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap =  lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap =  lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() == smallerHeap.size()) {
            return ((double) (biggerHeap.peek() + smallerHeap.peek()))/2.0;
        } else {
            return biggerHeap.peek();
        }
    }


    private double getMedianUsingCounter(int[] arr,int[] countfreq , int d) {
        double median=0;
        int a = 0;
        int b = 0;

        for(int i=1; i< countfreq.length; i++)// O(1);
        {
            countfreq[i] += countfreq[i-1];
        }

        //d is even -> median = a+b
        if(d%2==0){
            int first = d/2;
            int second = first+1;
            int i = 0;
            for(;i<201;i++){
                if(first<countfreq[i]){
                    a = arr[first];
                    break;
                }
            }
            for(;i<201;i++){
                if(second<countfreq[i]){
                    b = arr[second];
                    break;
                }
            }
            median =((a + b) / 2.0);
        }
        else    //d is odd -> median = a + 0 = 2*(middle elem)
        {
            int first = d/2;
            for(int i=0;i<201;i++){
                if(first<=countfreq[i]){
                    median = arr[first];
                    break;
                }
            }
        }
        return median;
    }


    public static int activityNotificationsMoin(int[] expenditure, int d) {
        int count = 0;
        TreeMap<Integer, Integer> numberCount = new TreeMap<>();
        for (int i=0; i<d; i++) {
            numberCount.compute(expenditure[i], (k, v) -> (v == null) ? 1 : v+1);
        }
        int i=d;
        do {
            int limit=0 ;
            int probableMidPointInArray=0;
            for (Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {
                probableMidPointInArray+=entry.getValue();
                int lookBackDays = probableMidPointInArray * 2;
                if (lookBackDays >= d) {
                    if (lookBackDays == d) { // almost an edge case for even - 1
                        limit = entry.getKey();
                    } else {
                        if (limit != 0) { // almost an edge case for even - 2
                            limit = (limit + entry.getKey());
                        } else {
                            limit = entry.getKey() * 2;
                        }
                        break;
                    }
                }
            }
            int currentDayValue = expenditure[i];
            if (currentDayValue >= limit) {
                count++;
            }
            int valueToBeRemoved = expenditure[i - d];
            Integer orDefault = numberCount.getOrDefault(valueToBeRemoved, 1);
            if (orDefault == 1) {
                numberCount.remove(valueToBeRemoved);
            } else {
                numberCount.put(valueToBeRemoved, orDefault -1);
            }
            numberCount.compute(currentDayValue, (k, v) -> (v == null) ? 1 : v+1);
        } while (++i < expenditure.length);
        return count;
    }

    @Test
    public void testNotification(){
        Scanner scanner = new Scanner(System.in);

//        String[] nd = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nd[0]);
//
//        int d = Integer.parseInt(nd[1]);
//
//        int[] expenditure = new int[n];
//
//        String[] expenditureItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int expenditureItem = Integer.parseInt(expenditureItems[i]);
//            expenditure[i] = expenditureItem;
//        }

        int[] a = new int[] {10, 20, 30, 40, 50 };
        int d1 = 3;
        System.out.println(activityNotificationsMoin(a,d1));
    }
}
