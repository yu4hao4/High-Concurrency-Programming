/**
 * @author 喻浩
 * @create 2020-01-11-下午9:25
 */
public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}

// holder
// 枚举
// DCL