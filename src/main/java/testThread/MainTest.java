package testThread;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1(1);
        Thread t1 = new Thread(thread1);
        Thread2 thread2 = new Thread2(10);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(thread1.i);
        System.out.println(thread2.j);
    }
}
