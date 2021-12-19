package interview.сollection.dictionary;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
    private String russianWord;
    private String englishWord;
    private static final Map<String, String> interpreter = new TreeMap<>();
    /* выбрад TreeMap только для дальнейшего использования,
     * если нам больше ничего делать с коллекцией не нужно,
     * то тогда HashMap*/

    static {
        interpreter.put("один", "one");
        interpreter.put("два", "two");
        interpreter.put("три", "three");
        interpreter.put("четыре", "four");
        interpreter.put("пять", "five");
        interpreter.put("шесть", "six");
        interpreter.put("семь", "seven");
        interpreter.put("восемь", "eight");
        interpreter.put("девять", "nine");
        interpreter.put("десять", "ten");
        interpreter.put("одиннадцать", "eleven");
        interpreter.put("двенадцать", "twelve");
        interpreter.put("тринадцать", "thirteen");
        interpreter.put("четырнадцать", "fourteen");
        interpreter.put("пятнадцать", "fifteen");
        interpreter.put("шестнадцать", "sixteen");
        interpreter.put("семьнадцать", "seventeen");
        interpreter.put("весемнадцать", "eighteen");
        interpreter.put("девятнадцать", "nineteen");
        interpreter.put("двадцать", "twenty");
        interpreter.put("тридцать", "thirty");
        interpreter.put("сорок", "forty");
        interpreter.put("пятьдесят", "fifty");
        interpreter.put("шестьдесят", "sixty");
        interpreter.put("семьдесят", "seventy");
        interpreter.put("восемьдесят", "eighty");
        interpreter.put("девяносто", "ninety");
        interpreter.put("сто", "one hundred");
        interpreter.put("двести", "two hundred");
        interpreter.put("триста", "three hundred");
        interpreter.put("четыреста", "four hundred");
        interpreter.put("пятьсот", "five hundred");
        interpreter.put("шестьсот", "six hundred");
        interpreter.put("семьсот", "seven hundred");
        interpreter.put("восемьсот", "eight hundred");
        interpreter.put("девятьсот", "nine hundred");
        interpreter.put("тысяча", "one thousand");
    }

    public static Map<String, String> getInterpreter() {
        return interpreter;
    }

    private void add(String russianWord, String englishWord) {
        interpreter.put(russianWord, englishWord);
    }

    private void translate(String russianWord) {
        if (interpreter.containsKey(russianWord)) {
            System.out.println();
        } else {
            System.out.println("Translate is not found," +
                    " enter the translation " + russianWord);
            add(russianWord, new Scanner(System.in).nextLine());
        }

    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.translate("оди");
        Dictionary.getInterpreter().forEach((x, y) -> System.out.println(x + "-" + y));
    }
}
