class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

class Father {
    int age;

    public Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative.");
        }
        this.age = age;
        System.out.println("Father's age is: " + this.age);
    }
}

class Son extends Father {
    int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to father's age.");
        }
        this.sonAge = sonAge;
        System.out.println("Son's age is: " + this.sonAge);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Father father = new Father(50);
            Son son = new Son(50, 45); 
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            Father father = new Father(40);
            Son son = new Son(40, 45); 
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {

            Father father = new Father(-10);
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
