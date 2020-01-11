/**
 * @author 喻浩
 * @create 2020-01-11-下午7:45
 */
public class HoonSynSingleton {
    private static HoonSynSingleton instance = null;

    private HoonSynSingleton(){

    }

    public static HoonSynSingleton getInstance(){
        if (instance == null){
            synchronized (HoonSynSingleton.class){
                instance = new HoonSynSingleton();
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
