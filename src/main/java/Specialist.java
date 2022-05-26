import java.util.concurrent.ConcurrentLinkedQueue;

public class Specialist implements Runnable{
    private ConcurrentLinkedQueue<String> callQueue;
    final private int timeForQuest = 3000;
    public Specialist(ConcurrentLinkedQueue<String> callQueue){
        this.callQueue = callQueue;
    }

    @Override
    public void run() {
        while (callQueue.size() > 0){
            String call;
            if ((call = callQueue.poll()) != null) {

                System.out.println("Сотрудник " + Thread.currentThread().getName() + " начал работу над вопросом по звонку " + call);
                try {
                    Thread.sleep(timeForQuest);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Сотрудник " + Thread.currentThread().getName() + " завершил работу над вопросом "  + call);
            }

        }
    }
}
