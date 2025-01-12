import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits; 
    int[] marks;    

    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);

  
        System.out.print("Enter USN: ");
        usn = scanner.nextLine();
        System.out.print("Enter Name: ");
        name = scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

   
        credits = new int[numSubjects];
        marks = new int[numSubjects];

       
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }


    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);

        System.out.println("\nSubject-wise Credits and Marks:");
        for (int i = 0; i < credits.length; i++) {
            System.out.println("Subject " + (i + 1) + " - Credits: " + credits[i] + ", Marks: " + marks[i]);
        }
    }


    public double calculateSGPA() {
        int totalCredits = 0;
        int totalWeightedMarks = 0;

     
        for (int i = 0; i < credits.length; i++) {
            totalCredits += credits[i];
            totalWeightedMarks += credits[i] * marks[i];
        }

     
        if (totalCredits == 0) {
            return 0.0;
        }
        return (double) totalWeightedMarks / totalCredits;
    }
}

public class StudentSGPA {
    public static void main(String[] args) {
      
        Student student = new Student();

     
        student.acceptDetails();

        student.displayDetails();

        double sgpa = student.calculateSGPA();
        System.out.println("\nSGPA: " + sgpa);
    }
}
