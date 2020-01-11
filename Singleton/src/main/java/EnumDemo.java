/**
 * @author 喻浩
 * @create 2020-01-11-下午9:21
 */
public enum EnumDemo {
    //常量，在加载的时候实例化一次，
    A,B,C,D;
    
    public static void m1(){
        System.out.println("method ");
    }

    public static void main(String[] args) {
        A.m1();
        B.m1();
        C.m1();
        D.m1();
        System.out.println(A.getClass().getName());
    }
}
