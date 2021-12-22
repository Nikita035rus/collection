package interview.сollection.queueshop;

import java.util.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        PriorityQueue<Person> myList = new PriorityQueue<>();
        for (int i = 0; i < 20; i++) {
            Person person = new Person();
            System.out.print(person.getAge()+" ");
            myList.add(person);
        }
        System.out.println(" ");
        for(Person person : myList){
            System.out.print(person.getAge()+" ");
        }




    }
}