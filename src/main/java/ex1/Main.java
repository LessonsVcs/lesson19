package ex1;
class Multi extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class Main {
    public static void main(String[] args) {
        new Multi().start();
    }
}
