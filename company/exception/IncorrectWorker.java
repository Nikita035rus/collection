package interview.сollection.company.exception;

public class IncorrectWorker extends RuntimeException {
    public IncorrectWorker(String massage){
        super(massage,null,false,false);
    }
}
