/**
 * 饿汉式单例模式
 * @author 喻浩
 * @create 2020-01-11-下午6:13
 * 
 * 
 * 线程安全性：在加载的时候已经被实例化，所以只有这一次，线程安全的（因为只产生了一个对象）
 * 
 * 懒加载：延迟加载　　　明显不符合，假如很长时间不使用此对象，就会浪费内存空间，影响性能
 */
public class HungerySingleton {
    //加载的时候就产生的实例对象
    private static HungerySingleton instance = new HungerySingleton();
    
    private HungerySingleton(){
        
    }
    
    //返回实例对象
    public static HungerySingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
//        HungerySingleton hungerySingleton = HungerySingleton.getInstance();
//        System.out.println(hungerySingleton);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(HungerySingleton.getInstance());
            }).start();
        }
    }
}
