package CIE;

public class Student {
    protected String usn;
    protected String name;
    protected int sem;

    public Student(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }

    
    public String getUsn() {
        return usn;
    }

    public String getName() {
        return name;
    }

    public int getSem() {
        return sem;
    }
}


Internals.java
package CIE;

public class Internals extends Student {
    private int[] internalMarks;

    public Internals(String usn, String name, int sem, int[] internalMarks) {
        super(usn, name, sem);
        this.internalMarks = internalMarks;
    }

    public int[] getInternalMarks() {
        return internalMarks;
    }
}


SEE Package
External.java

package SEE;

import CIE.Student;  

public class External extends Student {
    private int[] externalMarks;

    public External(String usn, String name, int sem, int[] externalMarks) {
        super(usn, name, sem);
        this.externalMarks = externalMarks;
    }

    public int[] getExternalMarks() {
        return externalMarks;
    }
}






Main File
FinalMarks.java 
  
import CIE.Internals;
import SEE.External;

public class FinalMarks {
    public static void main(String[] args) {
        int[] internalMarks1 = {85, 90, 88, 92, 89};
        int[] internalMarks2 = {78, 82, 80, 85, 87};

        int[] externalMarks1 = {70, 75, 80, 72, 78};
        int[] externalMarks2 = {65, 68, 72, 70, 74};

        Internals student1 = new Internals("1MS20CS001", "John Doe", 5, internalMarks1);
        Internals student2 = new Internals("1MS20CS002", "Jane Smith", 5, internalMarks2);

        External student3 = new External("1MS20CS003", "Alice Brown", 5, externalMarks1);
        External student4 = new External("1MS20CS004", "Bob White", 5, externalMarks2);

        printFinalMarks(student1);
        printFinalMarks(student2);
        printFinalMarks(student3);
        printFinalMarks(student4);
    }

    public static void printFinalMarks(Student student) {
        int totalMarks = 0;

        if (student instanceof Internals) {
            Internals internalsStudent = (Internals) student;
            int[] internalsMarks = internalsStudent.getInternalMarks();
            for (int mark : internalsMarks) {
                totalMarks += mark;
            }
        }

        if (student instanceof External) {
            External externalStudent = (External) student;
            int[] externalMarks = externalStudent.getExternalMarks();
            for (int mark : externalMarks) {
                totalMarks += mark;
            }
        }

        System.out.println("Student USN: " + student.getUsn());
        System.out.println("Name: " + student.getName());
        System.out.println("Semester: " + student.getSem());
        System.out.println("Final Marks: " + totalMarks);
    }
}
