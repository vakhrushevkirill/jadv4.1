import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    final static int WORKER = 4;
    final static int START_WORKER = 500;

    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue callQueue = new ConcurrentLinkedQueue<String>();
        Thread atc = new Thread(new ATC(callQueue));
        atc.start();
        for (int i = 0; i < WORKER; i++){
            new Thread(new Specialist(callQueue)).start();
            Thread.sleep(START_WORKER);
        }
    }
}
