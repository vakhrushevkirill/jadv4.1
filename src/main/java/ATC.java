import java.util.concurrent.ConcurrentLinkedQueue;

public class ATC implements Runnable{
    private ConcurrentLinkedQueue<String> callQueue;
    final private int calls = 60;
    final private int timeoutCalls = 60;


    public ATC(ConcurrentLinkedQueue<String> callQueue){
        this.callQueue = callQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < calls; i++){
            this.callQueue.add(Integer.toString(i));
            System.out.println("Вызов..."  + Integer.toString(i));
            try {
                Thread.sleep(timeoutCalls);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
