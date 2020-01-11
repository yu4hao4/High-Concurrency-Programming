/**
 * @author 喻浩
 * @create 2020-01-11-下午7:45
 * 
 * 问题：
 *      因为指令重排会引起空指针异常
 */
public class DCL {
    private volatile static DCL instance = null;

    private DCL(){
    }

    public static DCL getInstance(){
        if (instance == null){
            synchronized (DCL.class){
                if (instance == null){
                    instance = new DCL();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
                System.out.println(HoonSingleton.getInstance());
            }).start();
        }
    }
}
