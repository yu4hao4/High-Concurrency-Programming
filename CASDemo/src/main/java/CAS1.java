import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 喻浩
 * @create 2020-01-13-下午4:45
 */
public class CAS1 {
    private static volatile int m = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void increase(){
        m++;
    }
    
    public static void increase2(){
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[20];
        for (int i = 0; i < 20; i++) {
            t[i] = new Thread( () -> {
                CAS1.increase();
            } );
            t[i].start();
            // join 方法，加入的意思　　group　　　join　有了交互性
            t[i].join();
        }
        System.out.println(m);

        Thread[] tf = new Thread[20];
        
        for (int i = 0; i < 20; i++) {
            tf[i] = new Thread( () -> {
                CAS1.increase2();
            } );
            tf[i].start();
            tf[i].join();
        }
        System.out.println("atomic:"+atomicInteger.get());

        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 2){
                    flag = true;
                }
            }
            if(flag){
                flag = false;
                break;
            }
        }
    }
}
