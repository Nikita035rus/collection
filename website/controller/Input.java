package interview.сollection.website.controller;

import interview.сollection.website.entity.User;
import interview.сollection.website.exception.IncorrectLogin;
import interview.сollection.website.repository.LoginRepository;

import java.util.Scanner;

public class Input {
    static Scanner scn = new Scanner(System.in);
    private final User login;
    private final LoginRepository loginRepository = new LoginRepository();
    private String firstPassword;
    private String secondPassword;

    public Input(String name, String password) {
        login = new User(name, password);
        logIn();
    }

    public Input(String name, String password, String doublePassword) {
        login = new User(name, password);
        firstPassword=password;
        secondPassword=doublePassword;
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
    private void correctPassword(){
        boolean temp =true;
        while (temp){
            System.out.println("Please re-enter the password and double password");
            firstPassword=scn.nextLine();
            secondPassword =scn.nextLine();
            if(firstPassword.equals(secondPassword)) temp=false;
        }
    }

    private void correctLogin() {
        if (login.getLogin().length() < 3 ||
            login.getPassword().length() < 3 ||
            !firstPassword.equals(secondPassword)) {
            correctPassword();
        }
    }

    private void admin() {
        System.out.println("""
                1)all user\s
                2)all reliable users\s
                3)all login = email""");
        String request = scn.nextLine();
        switch (request) {
            case "1" -> loginRepository.allUser();
            case "2" -> loginRepository.allRequestUser();
            case "3" -> loginRepository.allLoginEmail();
            default -> throw new IncorrectLogin("IncorrectRequestException");
        }
    }
}
