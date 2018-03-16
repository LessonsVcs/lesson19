package ex2;

public class Main {
    public static void main(String[] args) {
        //new Multi3().run();
        System.out.println(Thread.currentThread().getName());
        Multi3 multi3 = new Multi3();
        Thread thread = new Thread(multi3,"multi3");
        thread.start();
    }
}
class Multi3 implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
