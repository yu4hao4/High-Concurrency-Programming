import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author 喻浩
 * @create 2020-01-13-下午5:46
 */
public class CAS2 {
    AbstractQueuedSynchronizer aqs;
    private static volatile int m = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static AtomicStampedReference asr = new AtomicStampedReference(100,1);

    public static void main(String[] args) {
        Thread t1 = new Thread( () -> {
            System.out.println(atomicInteger.compareAndSet(100,110));
            System.out.println(atomicInteger.get());
        });

        Thread t2 = new Thread( () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicInteger.compareAndSet(110,100));
            System.out.println(atomicInteger.get());
        });

        
        Thread t3 = new Thread( () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicInteger.compareAndSet(100,120));
            System.out.println(atomicInteger.get());
        });

        System.out.println("=======================================++++++++++");

        Thread tf1 = new Thread( () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(asr.compareAndSet(100,110,
                    asr.getStamp(),asr.getStamp()+1));
            System.out.println(asr.compareAndSet(110,100,
                    asr.getStamp(),asr.getStamp()+1));
        });
        tf1.start();

        Thread tf2 = new Thread( () -> {
            int stamp = asr.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    asr.compareAndSet(110,120,
                            stamp,stamp+1)
            );
        });
        tf2.start();
    }
}
