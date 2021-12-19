package interview.сollection.website.exception;

public class IncorrectLogin extends RuntimeException{
    public IncorrectLogin(String massage){
        super(massage, null, false, false);
    }
}
