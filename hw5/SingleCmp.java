import java.util.concurrent.CountDownLatch;

public class SingleCmp {
    public static void main(String[] args) throws Exception{
    long start = System.currentTimeMillis();
    int totalTime= 0;

    int totalThread = 15;
    final CountDownLatch countDownLatch = new CountDownLatch(totalThread);
    for (int k = 0; k <= 2; k++) {
        for (int i = 0; i < totalThread; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        //Singleton_Eager instance = Singleton_Eager.getInstance();//22
                        //Singleton_Lazy instance2 = Singleton_Lazy.getInstance();//108
                        Singleton_Inner instance3 = Singleton_Inner.getInstance();//40
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        totalTime+=(end - start);
    }
        int avgTime = totalTime/3;
        System.out.println(avgTime);
    }
}

//eager loading
class Singleton_Eager {
    private static Singleton_Eager instance = new Singleton_Eager();
    private Singleton_Eager() {

    }
    public static Singleton_Eager getInstance() {
        return instance;
    }
}

//lazy loading
class Singleton_Lazy {
    private static Singleton_Lazy instance;
    private Singleton_Lazy() {

    }
    public static synchronized Singleton_Lazy getInstance() {
        if (instance == null) {
            instance = new Singleton_Lazy();

        }
        return instance;
    }
}

//static inner class
class Singleton_Inner {
    private static class Singleton_InnerInstance {
        private static final Singleton_Inner instance = new Singleton_Inner();
    }
    public static Singleton_Inner getInstance() {
        return Singleton_InnerInstance.instance;
    }
    private Singleton_Inner() {

    }
}

//Conclusion: EagerLoading cost the lowest because when calling is frequent, it it more efficient to load beforehand