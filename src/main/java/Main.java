import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    final static int worker = 4;
    final static int startWorker = 500;

    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue callQueue = new ConcurrentLinkedQueue<String>();
        Thread atc = new Thread(new ATC(callQueue));
        atc.start();
        for (int i = 0; i < worker; i++){
            new Thread(new Specialist(callQueue)).start();
            Thread.sleep(startWorker);
        }
    }
}
