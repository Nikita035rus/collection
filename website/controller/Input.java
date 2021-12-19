package interview.сollection.website.controller;

import interview.сollection.website.entity.Login;
import interview.сollection.website.exception.IncorrectLogin;
import interview.сollection.website.repository.LoginRepository;

import java.util.Scanner;

public class Input {
    private final Login login;

    public Input(String name, String password) {
        login = new Login(name, password);
        logIn();
    }

    public Input(String name, String password, String doublePassword) {
        login = new Login(name, password, doublePassword);
        registration();
    }

    static Scanner scn = new Scanner(System.in);
    private final LoginRepository loginRepository = new LoginRepository();

    private void registration() {
     correctLogin();
     loginRepository.add(login);
    }

    private void logIn() {
        if (login.getLogin().equals("admin") && login.getPassword().equals("admin")) {
            admin();
        } else {
            correctLogin();
            if (loginRepository.contains(login)) {
                System.out.println("Login completed");
            } else {
                throw new IncorrectLogin("YouAreNotRegisteredException");
            }
        }
    }

    private void correctLogin() {
        if (login.getLogin().length() < 3 || login.getPassword().length() < 3) {
            throw new IncorrectLogin("IncorrectLengthLoginException");
        }
        if(login.getDoublePassword()!=null){
            if(!login.getPassword().equals(login.getDoublePassword())){
                throw new IncorrectLogin("PasswordAndDoublePasswordNotEqualException");
            }
        }
    }

    private void admin() {
        System.out.println("""
                1)all user\s
                2)all reliable users\s
                3)all login = email""");
        String request = scn.nextLine();
        switch (request){
            case "1" -> loginRepository.allUser();
            case "2" -> loginRepository.allRequestUser();
            case "3" -> loginRepository.allLoginEmail();
            default -> throw new IncorrectLogin("IncorrectRequestException");
        }
    }
}
