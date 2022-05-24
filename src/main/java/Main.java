import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue callQueue = new ConcurrentLinkedQueue<String>();
        Thread atc = new Thread(new ATC(callQueue));
        atc.start();
        for (int i = 0; i < 4; i++){
            new Thread(new Specialist(callQueue)).start();
            Thread.sleep(500);
        }
    }
}
