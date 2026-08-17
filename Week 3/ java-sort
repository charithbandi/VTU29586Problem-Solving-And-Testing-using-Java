import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        // Sort using custom Comparator logic
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // 1. Primary rule: Highest CGPA first (Decreasing order)
                if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) {
                    return Double.compare(s2.getCgpa(), s1.getCgpa());
                } 
                // 2. Secondary rule: Alphabetical order by first name
                else if (!s1.getFname().equals(s2.getFname())) {
                    return s1.getFname().compareTo(s2.getFname());
                } 
                // 3. Tertiary rule: Ascending order by ID
                else {
                    return Integer.compare(s1.getId(), s2.getId());
                }
            }
        });

        // Print sorted student names
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }

        in.close();
    }
}
