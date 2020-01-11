/**
 * @author 喻浩
 * @create 2020-01-11-下午9:26
 */
public class EnumSingletonDemo {
    private EnumSingletonDemo(){}
    
    private enum EnumHolder{
        INSTANCE;
        private EnumSingletonDemo instance;
        EnumHolder(){
            this.instance = new EnumSingletonDemo();
        }
        
        private EnumSingletonDemo getInstance(){
            return instance;
        }
    }
    
    public static EnumSingletonDemo getInstance(){
        return EnumHolder.INSTANCE.instance;
    }
}
