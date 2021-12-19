package interview.сollection.queueBank;

import java.util.Deque;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;


public class ATMQueue {
    private static final Deque<Person> ATMDeque1 = new ConcurrentLinkedDeque<>();
    private static final Deque<Person> ATMDeque2 = new ConcurrentLinkedDeque<>();
    public static final AtomicInteger countPerson = new AtomicInteger(0);

    private final int workingTimeOf1Person = 3 + (int) (Math.random() * 3);

    public int getWorkingTimeOf1Person() {
        return workingTimeOf1Person;
    }

    public void add(Person person) {
        if (ATMDeque1.size() == 8 && ATMDeque2.size() == 8) {
            Person.upset++;
        } else {
            Person.funny++;
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
        if (ATMDeque1.size() == 8) {
            ATMDeque1.removeFirst();
        }
        if (ATMDeque2.size() == 8) {
            ATMDeque2.removeFirst();
        }
    }
}

class Person {
    private final int time;
    static int funny;
    static int upset;

    Person() {
        time = 1 + (int) (Math.random() * 5);
    }

    public int getTime() {
        return time;
    }
}
