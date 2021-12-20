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
    public double averageAge(boolean success) {
        return success(success)
                .keySet()
                .stream()
                .mapToInt(Worker::getAge)
                .average()
                .orElse(0.0);
    }
    //Определить самого сильного сотрудника из каждого отдела.

    public Worker getTheBestWorkerInProgrammer(Worker.Profession profession) {
        return success(true)
                .entrySet()
                .stream()
                .filter(x -> x.getKey().getProfession().equals(profession))
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    public Map<Worker, Double> getAll(Worker.Profession profession) {
        return getWorkerMap().entrySet().stream()
                .filter(x -> x.getKey().getProfession().equals(profession))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    public Map<Worker, Double> getAnaliseAndProgrammer(Worker.Profession first, Worker.Profession second) {
        return getWorkerMap()
                .entrySet()
                .stream()
                .filter(x -> x.getKey().getProfession().equals(first) ||
                        x.getKey().getProfession().equals(second))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }


}
