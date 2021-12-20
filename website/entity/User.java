package interview.сollection.website.entity;

import java.util.Objects;

public class User {
    private final String login;
    private final String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;

    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
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
        User login1 = (User) o;
        return Objects.equals(login, login1.login) && Objects.equals(password, login1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
