package interview.сollection.queuebank;

import java.util.Deque;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;


public class ATMQueue {
    private static final Deque<Person> ATMDeque1 = new ConcurrentLinkedDeque<>();
    private static final Deque<Person> ATMDeque2 = new ConcurrentLinkedDeque<>();
    public static final AtomicInteger countPerson = new AtomicInteger(0);
    private final int time = 1 + (int) (Math.random() * 5);
    static int funny;
    static int upset;

    private final int serviceTime = 3 + (int) (Math.random() * 3);

    public int getServiceTime() {
        return serviceTime;
    }

    public int getTime() {
        return time;
    }

    public void add(Person person) {
        if (ATMDeque1.size() == 8 && ATMDeque2.size() == 8) {
            upset++;
        } else {
            funny++;
            if (ATMDeque1.size() == ATMDeque2.size()) {
                int x = new Random().nextInt(2);
                if (x == 0) {
                    ATMDeque1.add(person);
                } else {
                    ATMDeque2.add(person);
                }
            } else if (ATMDeque1.size() < ATMDeque2.size()) {
                ATMDeque1.addLast(person);
            } else {
                ATMDeque2.addLast(person);
            }
        }
    }

    public void remove() {
        ATMDeque1.removeFirst();
        ATMDeque2.removeFirst();
    }
}
class Person {
}

