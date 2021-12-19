package interview.сollection.website.entity;

import java.util.Objects;

public class Login {
    private final String login;
    private final String password;
    private String doublePassword;

    public Login(String login, String password, String doublePassword) {
        this.login = login;
        this.password = password;
        this.doublePassword = doublePassword;
    }

    public Login(String login, String password) {

        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDoublePassword() {
        return doublePassword;
    }

    @Override
    public String toString() {
        return  "login='" + login + '\'' +
                " password='" + password + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login1 = (Login) o;
        return Objects.equals(login, login1.login) && Objects.equals(password, login1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
