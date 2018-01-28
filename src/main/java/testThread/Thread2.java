package testThread;

public class Thread2 implements Runnable {
    public volatile static int j;

    public Thread2(int j) {
        this.j = j;
    }

//    public int getJ() {
//        return j;
//    }
//
//    public void setJ(int j) {
//        this.j = j;
//    }

    public void run() {
//        while (true){
            j = j * j;
//            break;
//        }
    }
}
