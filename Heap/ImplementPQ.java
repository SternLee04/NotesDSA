import java.util.*;

public class ImplementPQ {
    static class Student implements Comparable<Student> {// now we can compare objects.
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student o) { // overridden : Implement by child class(Student) mentioned in parent class.
            return this.rank - o.rank; // return rank lesser(-ve) than has higher priority.
        }
    }
    public static void main(String[] args) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqRL = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(1);
        pq.add(2);
        pq.add(3);
        pqRL.add(1);
        pqRL.add(2);
        pqRL.add(3);

        while (!pq.isEmpty()) {// By default acending order priority.
            System.out.println(pq.peek());
            pq.remove();
        }
        System.out.println("--------------------------------");
        while (!pqRL.isEmpty()) {
            System.out.println(pqRL.peek());
            pqRL.remove();
        }
        System.out.println("--------------------------------");

        PriorityQueue<Student> prefrence = new PriorityQueue<>();
        PriorityQueue<Student> prefrenceRL = new PriorityQueue<>(Comparator.reverseOrder());

        prefrence.add(new Student("A", 4));
        prefrence.add(new Student("B", 3));
        prefrence.add(new Student("C", 2));
        prefrence.add(new Student("D", 1));
        prefrence.add(new Student("E", 5));
        prefrenceRL.add(new Student("A", 4));
        prefrenceRL.add(new Student("B", 3));
        prefrenceRL.add(new Student("C", 2));
        prefrenceRL.add(new Student("D", 1));
        prefrenceRL.add(new Student("E", 5));

        while (!prefrence.isEmpty()) {
            System.out.println(prefrence.peek().name + "->" + prefrence.peek().rank);
            prefrence.remove();
        }
        System.out.println("--------------------------------");
        while (!prefrenceRL.isEmpty()) {
            System.out.println(prefrenceRL.peek().name + "->" + prefrenceRL.peek().rank);
            prefrenceRL.remove();
        }
        System.out.println("--------------------------------");
    }
}
