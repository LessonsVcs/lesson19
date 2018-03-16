package ex5;

import java.util.Random;

class Car{
    private int weight;
    private int length;
    private int height;
    private int speed;
    private int distance;
    public static final int raceLenght=1000;
    Car(int weight, int length, int height){
        this.weight = weight;
        this.height = height;
        this.length = length;
    }
    public void calculateSpeed(){
        Random random = new Random();
        this.speed += 2000/(weight+length+height)* (random.nextInt(4)+1);
    }
    public void calculateDistance(){
        this.distance += this.speed;
        if (this.distance > raceLenght){
            this.distance=raceLenght;
        }
    }

    public int getDistance() {
        return distance;
    }
}
class Race extends Car implements Runnable{


    Race(int weight, int length, int height) {
        super(weight, length, height);
    }

    synchronized public void run() {
        while (getDistance()< raceLenght){
            calculateSpeed();
            calculateDistance();
            System.out.println(getDistance()+ " - "+ Thread.currentThread().getName());
            //System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Thread honda = new Thread(new Race(100,100,100),"Honda");
        Thread BMW =  new Thread(new Race(50,200,100),"BMW");
        Thread mercedes =  new Thread(new Race(150,100,80),"Mercedes");
        BMW.start();
        honda.start();
        mercedes.start();
        while (true){
            if (!honda.isAlive()){
                System.out.println("honda won!");
                break;
            }
            if (!BMW.isAlive()){
                System.out.println("bmw won!");
                break;
            }
            if (!mercedes.isAlive()){
                System.out.println("mercedes won!");
                break;
            }
        }

    }
}
