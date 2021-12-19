package interview.сollection.company;

import interview.сollection.company.controller.WorkerController;
import interview.сollection.company.repository.WorkerRepository;

public class Test {
    public static void main(String[] args) {
        WorkerController workerController = new WorkerController();

        for (int i = 0; i < 20; i++) {
            new WorkerController();
        }

        WorkerRepository workerRepository = new WorkerRepository();

        System.out.println(workerRepository.averageAgeSuccessFull());
        System.out.println(workerRepository.getTheBestWorkerInHR());
    }
}
