import java.util.concurrent.ConcurrentLinkedQueue;

public class ATC implements Runnable{
    private ConcurrentLinkedQueue<String> callQueue;

    public ATC(ConcurrentLinkedQueue<String> callQueue){
        this.callQueue = callQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i++){
            this.callQueue.add(Integer.toString(i));
            System.out.println("Вызов..."  + Integer.toString(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
