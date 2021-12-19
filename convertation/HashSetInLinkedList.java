package interview.сollection.convertation;

import java.util.*;

public class HashSetInLinkedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(12, 1000, 0, 45, -25, -100));
        List<Integer> list = new LinkedList<>(set);
        System.out.println(list);
    }
}
