public class Singleton {
}
class s1{
    private static s1 ss = new s1();
    private s1(){

    }
    public static s1 getInstance(){
        return ss;
    }

}
class s2{
    private static s2 ss;
    private s2(){

    }
    public static synchronized s2 getInstance(){
        if(ss == null){
            ss = new s2();
        }
        return ss;

    }
}
class s3{
    private s3(){

    }
    private static class instance{
        private static final s3 ss = new s3();
    }
    public static s3 getInstance(){
        return instance.ss;
    }
}
