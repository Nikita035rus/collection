package interview.сollection.company.controller;

import interview.сollection.company.entity.Worker;
import interview.сollection.company.repository.WorkerRepository;

import java.util.*;


public class WorkerController {
    private final Worker worker;
    private static final List<Worker.Profession> list = List.of(Worker.Profession.values());
    private static final int size = Worker.Profession.values().length;
    private static final Random random = new Random();


    public WorkerController() {
        int age = 18 + (int) (Math.random()*32);
        int experience = (int) (Math.random() * (age - 18));
        Worker.Profession getEnum = list.get(random.nextInt(size));
        worker = new Worker(age, experience,getEnum);
        add();
    }

    public Worker getWorker() {
        return worker;
    }

    private double scoresAge(){
        return  (double) 40/50* worker.getAge();
        //на каждый год приходится колличество баллов = 40/50
    }
    private double scoresProfession(){
        return  (double) 40/( worker.getProfession().ordinal()+1);
        /*баллы распределяются по приоритету
         40=программист
         40/2 = аналитик
         40/3 = HR
         */
    }
    private double scoreExperience(){
        return  (double) 40/32* worker.getExperience();
    }
    //устный экзамен
    private double scoreOralInterview(){
        return (double) 10+Math.random()*30;
    }

    public double getAllScore(){
        return scoresAge()
                +scoresProfession()
                +scoreExperience()
                +scoreOralInterview();
    }
    WorkerRepository workerRepository = new WorkerRepository();
    public void add(){
        workerRepository.add(worker, getAllScore());
    }
}
