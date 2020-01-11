/**
 * @author 喻浩
 * @create 2020-01-11-下午9:07
 */
public class HolderDemo {
    private HolderDemo(){}
    
    private static class Holder{
        private static HolderDemo instance = new HolderDemo();
    }//实现懒加载
    
    public static HolderDemo getInstance(){
        return Holder.instance;
    }
}
