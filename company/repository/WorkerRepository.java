package interview.сollection.company.repository;

import interview.сollection.company.entity.Worker;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WorkerRepository {
    private static final Map<Worker, Double> workerMap = new HashMap<>();

    public static Map<Worker, Double> getWorkerMap() {
        return workerMap;
    }

    public void add(Worker worker, double balls) {
        workerMap.put(worker, balls);
    }

    //принятые
    public Map<Worker, Double> success(boolean success) {
        Predicate<Map.Entry<Worker, Double>> predicate;
        if (success) predicate = x -> x.getValue() >= 65;
        else predicate = x -> x.getValue() < 65;
        return workerMap
                .entrySet()
                .stream()
                .filter(predicate)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    //Определить средний возраст всех принятых на работу
    public double averageAgeSuccessFull() {
        return success(true)
                .keySet()
                .stream()
                .mapToInt(Worker::getAge)
                .average()
                .orElse(0.0);
    }

    //Определить средний возраст всех непринятых на работу
    public double averageAgeUnSuccessFull() {
        return success(false)
                .keySet()
                .stream()
                .mapToInt(Worker::getAge)
                .average()
                .orElse(0.0);
    }

    //Определить самого сильного сотрудника из каждого отдела.
    public Worker getTheBestWorkerInHR() {
        return success(true)
                .entrySet()
                .stream()
                .filter(x -> x.getKey().getProfession().equals(Worker.Profession.HR))
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    public Worker getTheBestWorkerInAnalise() {
        return success(true)
                .entrySet()
                .stream()
                .filter(x -> x.getKey().getProfession().equals(Worker.Profession.ANALYST))
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    public Worker getTheBestWorkerInProgrammer() {
        return success(true)
                .entrySet()
                .stream()
                .filter(x -> x.getKey().getProfession().equals(Worker.Profession.PROGRAMMING))
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    public Map<Worker, Double> getAllHR() {
        return getWorkerMap().entrySet().stream()
                .filter(x -> x.getKey().getProfession().equals(Worker.Profession.HR))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    public Map<Worker, Double> getAllAnalise() {
        return getWorkerMap()
                .entrySet()
                .stream()
                .filter(x -> x.getKey().getProfession().equals(Worker.Profession.ANALYST))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    public Map<Worker, Double> getAnaliseAndProgrammer() {
        return getWorkerMap()
                .entrySet()
                .stream()
                .filter(x -> x.getKey().getProfession().equals(Worker.Profession.ANALYST) ||
                        x.getKey().getProfession().equals(Worker.Profession.PROGRAMMING))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    public Map<Worker, Double> getAnaliseAndHR() {
        return getWorkerMap()
                .entrySet()
                .stream()
                .filter(x -> x.getKey().getProfession().equals(Worker.Profession.ANALYST) ||
                        x.getKey().getProfession().equals(Worker.Profession.HR))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    public Map<Worker,Double> getHRandProgrammer() {
        return getWorkerMap()
                .entrySet()
                .stream()
                .filter(x->x.getKey().getProfession().equals(Worker.Profession.HR)||
                        x.getKey().getProfession().equals(Worker.Profession.PROGRAMMING))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }
}
