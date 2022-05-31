import java.util.concurrent.ConcurrentLinkedQueue;

public class ATC implements Runnable{
    private ConcurrentLinkedQueue<String> callQueue;
    final static private int CALLS = 60;
    final static private int TIMEOUT_CALLS = 60;


    public ATC(ConcurrentLinkedQueue<String> callQueue){
        this.callQueue = callQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < CALLS; i++){
            this.callQueue.add(Integer.toString(i));
            System.out.println("Вызов..."  + Integer.toString(i));
            try {
                Thread.sleep(TIMEOUT_CALLS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
