import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class UniqueDeque {

    int[] a = new int[] {5,6,7,7,8,4,6,3,5,6};

    HashSet<Integer> set = new HashSet<>();
    int max=0;

    Deque<Integer> deque = new ArrayDeque<>();

    public void addInQueue() {
        for (int i = 0; i < a.length; i++) {
            deque.add(a[i]);
            set.add(a[i]);

            if(deque.size()==3) {
                if(set.size() > Integer.MIN_VALUE) max = set.size();
                int first = (int) deque.remove();
                if (!deque.contains(first)) set.remove(first);
            }

        }
        System.out.println(max);

    }

    public static void main(String[] arg) {
        UniqueDeque u = new UniqueDeque();
        u.addInQueue();
    }

}
