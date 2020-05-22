import java.util.concurrent.*;
public class SingletonPerformance {
    public static int numThread = 15;
    public static CountDownLatch countDownLatch = new CountDownLatch(numThread);
    public static void main(String[] args) throws InterruptedException {
        //int numThread = 15;
        //CountDownLatch countDownLatch = new CountDownLatch(numThread);
        long start = System.currentTimeMillis();
        for (int i = 0; i < numThread; i++) {
            Thread worker = new Thread(new Worker());
            worker.start();
        }

        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}

class Worker implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            Singleton1 instance = Singleton1.getInstance();
        }
        SingletonPerformance.countDownLatch.countDown();
    }
}

// Inner class, time = 11ms
class Singleton1 {
    private Singleton1() {

    }

    private static class SingletonHolder {
        private static final Singleton1 instance = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return SingletonHolder.instance;
    }
}


// lazy loading, Double check lock, synchronized block, time = 15ms
class Singleton2 {
    private static volatile Singleton2 instance;
    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) { //.class reference to a class object
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}


// lazy loading, synchronized method, time = 112ms
// much slower due to the synchronized method overhead
class Singleton3 {
    private static Singleton3 instance;
    private Singleton3() {

    }

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

// eager loading, time = 14ms
class Singleton4 {
    private static final Singleton4 instance = new Singleton4();
    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        return instance;
    }
}
