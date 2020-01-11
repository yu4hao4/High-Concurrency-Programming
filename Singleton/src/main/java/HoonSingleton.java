/**
 * @author 喻浩
 * @create 2020-01-11-下午6:38
 */
public class HoonSingleton {
    private static HoonSingleton instance = null;
    
    private HoonSingleton(){
        
    }
    
    public static HoonSingleton getInstance(){
        if (instance == null){
            instance = new HoonSingleton();
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