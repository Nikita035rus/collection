package interview.сollection.website.repository;

import interview.сollection.website.entity.Login;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LoginRepository {
    private static final Set<Login> accounts = new HashSet<>();

    static {
        accounts.add(new Login("admin", "admin"));
    }

    public boolean contains(Login login) {
        return accounts.contains(login);
    }

    public void add(Login login) {
        accounts.add(login);
    }

    public void allUser() {
    accounts.forEach(System.out::println);
    }

    public void allRequestUser() {
        accounts.stream().filter(x->
                (x.getLogin().length()<10
                        && x.getLogin().length()>2
                && x.getLogin().matches("(?=.*[0-9])[A-Za-z0-9]+$")))
                .collect(Collectors.toSet()).forEach(System.out::println);
    }
    public void allLoginEmail(){
        String format = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+.(ru|com)";
        accounts.stream().filter(x->
                x.getLogin().matches(format))
                    .collect(Collectors.toSet()).forEach(System.out::println);
    }
}
