import java.util.concurrent.TimeUnit;

/**
 * @author 喻浩
 * @create 2020-01-09-上午11:31
 */
public class ReaderAndUpdater {
    final static int      MAX=2;
    static volatile int init_value=0;

    public static void main(String[] args) {
        new Thread(()->{
           int localValue = init_value;
           while (localValue < MAX){
               if (localValue < MAX){
                   System.out.println("Reader:"+init_value);
                   localValue = init_value;
               }
           }
        },"Reader").start();
        
        new Thread(() -> {
          int localValue = init_value;
          while (localValue < MAX){
              System.out.println("update:"+(++localValue));
              init_value = localValue;
              try {
                  TimeUnit.SECONDS.sleep(2);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }              
        },"Updater").start();
    }
}
