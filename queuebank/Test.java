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
                    TimeUnit.MILLISECONDS.sleep(person.getTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            ATMQueue atmQueue = new ATMQueue();
            while (ATMQueue.countPerson.get() < 100) {
                atmQueue.remove();
                try {
                    TimeUnit.MILLISECONDS.sleep(atmQueue.getWorkingTimeOf1Person());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("People funny: " + Person.funny);
        System.out.println("People upset: " + Person.upset);
    }
}
