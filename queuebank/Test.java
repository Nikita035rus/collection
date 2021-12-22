package interview.сollection.queuebank;

import java.util.concurrent.TimeUnit;



public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            ATMQueue atmQueue = new ATMQueue();
            Person person;
            for (int i = 0; i < 100; i++) {
                person = new Person();
                ATMQueue.countPerson.incrementAndGet();
                atmQueue.add(person);
                try {
                    TimeUnit.MILLISECONDS.sleep(atmQueue.getTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            ATMQueue atmQueue = new ATMQueue();
            while (ATMQueue.countPerson.get() < 100) {
                try {
                    TimeUnit.MILLISECONDS.sleep(atmQueue.getServiceTime());
                    atmQueue.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("People funny: " + ATMQueue.funny);
        System.out.println("People upset: " + ATMQueue.upset);
    }
}
