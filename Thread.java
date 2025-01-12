class BMSCollegeThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("BMS College of Engineering");
            try {
                Thread.sleep(10000); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class CSEThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("CSE");
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        BMSCollegeThread thread1 = new BMSCollegeThread();
        CSEThread thread2 = new CSEThread();
        
        thread1.start();
        thread2.start();
    }
}
