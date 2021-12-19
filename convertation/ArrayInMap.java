package interview.сollection.convertation;

import java.util.*;

public class ArrayInMap {
    private static Map<Integer,Integer> convert(List<Integer> arrayList){
            Map<Integer, Integer> map = new HashMap<>();
            for(Integer arr : arrayList){
                map.merge(arr,1, (x,y)-> x+1);
            }
        return map;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,1,1,3,4,5,1,2,3,5,5));
        convert(list).forEach((x,y)-> System.out.println(x+": "+y));
    }
}
