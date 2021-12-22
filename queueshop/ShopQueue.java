package interview.сollection.queueshop;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ShopQueue {

    private final Deque<Person> PersonOther = new ConcurrentLinkedDeque<>();
    private final Deque<Person> PersonOld = new ConcurrentLinkedDeque<>();
    private final Deque<Person> PersonYoung = new ConcurrentLinkedDeque<>();

    private final List<Person> PersonOldStatic = new LinkedList<>();
    private final List<Person> PersonYoungStatic = new LinkedList<>();
    private final List<Person> PersonOtherStatic = new LinkedList<>();

    public static final PriorityQueue<Person> myList = new PriorityQueue<>();



    public Deque<Person> getPersonOther() {
        return PersonOther;
    }

    public Deque<Person> getPersonOld() {
        return PersonOld;
    }

    public Deque<Person> getPersonYoung() {
        return PersonYoung;
    }

    public List<Person> getPersonOldStatic() {
        return PersonOldStatic;
    }

    public List<Person> getPersonYoungStatic() {
        return PersonYoungStatic;
    }

    public List<Person> getPersonOtherStatic() {
        return PersonOtherStatic;
    }

    public static int countPersonInQueue;

    public void addPerson(Person person) {
        countPersonInQueue++;
        myList.add(person);
        if (person.getAge() > 49) {
            PersonOld.add(person);
            PersonOldStatic.add(person);
        } else if (person.getAge() < 17) {
            PersonYoung.add(person);
            PersonYoungStatic.add(person);
        } else {
            PersonOther.add(person);
            PersonOtherStatic.add(person);
        }
    }

    public int getPersonInQueue() {
        if (PersonOld.size() != 0) {
            return PersonOld.poll().getProducts();
        } else if (PersonYoung.size() != 0) {
            return PersonYoung.poll().getProducts();
        } else if (PersonOther.size() != 0) {
            return PersonOther.poll().getProducts();
        }
        return 1;
    }

    public boolean listNull(){
        return PersonOther.size() != 0
                || PersonOld.size() != 0
                || PersonYoung.size() != 0;
    }

    public void printStatistic() {
        System.out.println(PersonOld.size());
        System.out.println(PersonYoung.size());
        System.out.println(PersonOther.size());
        String format = "%-3s| %-10s| %-10s\n";
        System.out.format(format, "Category", "Quantity", "Average time");
        String format1 = "%-8s| %-10d| %-10f\n";

        System.out.format(format1, "elderly", PersonOldStatic.size(), averageTime(PersonOldStatic));
        System.out.format(format1, "young", PersonYoungStatic.size(), averageTime(PersonYoungStatic));
        System.out.format(format1, "other", PersonOtherStatic.size(), averageTime(PersonOtherStatic));
    }
    private double averageTime(List<Person> deque){
        return deque.stream()
                .mapToInt(Person::getTime)
                .average()
                .orElse(0);
    }

}

