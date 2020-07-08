import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student {

    private String name;
    private int id;
    private double cgpa;

    public Student(String name, int id, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCGPA() {
        return this.cgpa;
    }
}

class Priorities {


    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue(10,new MyComparator());

        int i=0;
        while(i < events.size())  {
            if (events.get(i).equals("SERVED")) {
                pq.poll();
            } else {
                String[] attributes = events.get(i).split("\\s");
                Student student = new Student(
                    attributes[1],
                    Integer.parseInt(attributes[3]),
                    Double.parseDouble(attributes[2])
                );
                pq.offer(student);
            }
            i++;
        }

        List<Student> l = new ArrayList<Student>();
        while (!pq.isEmpty()) {
            l.add(pq.poll());
        }
        return l;
    }

}


class MyComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        double cgpa1=s1.getCGPA();
        double cgpa2=s2.getCGPA();
        String n1=s1.getName();
        String n2=s2.getName();
        Integer i1=s1.getID();
        Integer i2=s2.getID();

        if(Double.compare(cgpa2,cgpa1) ==0) {
            if(n1.compareTo(n2) ==0) {
                return i1.compareTo(i2);
            }else {
                return n1.compareTo(n2);
            }

        } else {
            return Double.compare(cgpa2,cgpa1);
        }
    }
}


public class QueueStudentCompare {

    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);


        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
