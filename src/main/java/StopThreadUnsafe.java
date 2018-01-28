public class StopThreadUnsafe {

    public static User u = new User();
    public static class User{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User() {
            this.id = 0;
            this.name = "0";
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public static class ChangeObjectThread extends Thread{
        public volatile boolean stopme = false;

        public void stopMe(){
            stopme = true;
        }

        @Override
        public void run(){
            while (true){
                synchronized (u){
                    if (stopme){
                        System.out.println("exit!");
                    }
                    int v = (int) (System.currentTimeMillis()/1000);
                    u.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String .valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectTread extends Thread{
        @Override
        public void run(){
            while (true){
                synchronized (u){
                    if (u.getId() != Integer.parseInt(u.getName())){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectTread().start();
        while (true){
            StopThreadUnsafe.ChangeObjectThread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            t.stopMe();
        }
    }
}