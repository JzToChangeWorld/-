package testThread;

public class Thread1 implements Runnable {
    public volatile static int i;

//    public int getI() {
//        return i;
//    }
//
//    public void setI(int i) {
//        this.i = i;
//    }

    public Thread1(int i) {
        this.i = i;
    }

    public void run() {
//        while (true) {
            for (int j = 0; j < 10; j++) {
                i = i * j;
            }
//            break;
//        }
    }
}
