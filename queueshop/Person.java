package interview.сollection.queueshop;

public class Person implements Comparable<Person> {
    private final PersonAge personAge;
    private final int age;
    private final int products;
    private final int time;

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.getPersonAge().ordinal(),
                o.getPersonAge().ordinal());
    }

    public enum PersonAge {
        OLD, YANG, NORMAL
    }

    public PersonAge getPersonAge() {
        return personAge;
    }

    Person() {
        age = getRandom(10, 65);
        products = getRandom(5, 30);
        time = getRandom(3, 6);
        personAge = getAgeGroup();
    }

    private int getRandom(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    private PersonAge getAgeGroup() {
        if (age > 49) return PersonAge.OLD;
        else if (age < 17) return PersonAge.YANG;
        else return PersonAge.NORMAL;
    }

    public int getAge() {
        return this.age;
    }

    public int getProducts() {
        return products;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
