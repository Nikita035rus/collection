package interview.сollection.hashinsorthash;

import java.util.*;

public class SortHash {
    static Set<Integer> hashSet = new HashSet<>
            (Arrays.asList(12, 1000, 0, 45, -25, -100));

    static HashSet<Integer> sort(Set<Integer> hash) {
        HashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        hash.stream().sorted().forEach(linkedHashSet::add);
        return linkedHashSet;
    }

    public static void main(String[] args) {
        sort(hashSet).forEach(System.out::println);
    }
}
