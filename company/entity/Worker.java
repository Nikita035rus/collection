package interview.сollection.company.entity;

import java.util.Objects;

public class Worker {
    private final int age;
    private final int experience;
    private final Profession profession;


    public enum Profession {
        HR, ANALYST, PROGRAMMING
    }

    public Worker(int age, int experience, Profession profession) {
        this.age = age;
        this.experience = experience;
        this.profession = profession;

    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }
    public Profession getProfession() {
        return profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return age == worker.age && experience == worker.experience && profession == worker.profession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, experience, profession);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "age=" + age +
                ", experience=" + experience +
                ", profession=" + profession +
                '}';
    }
}
