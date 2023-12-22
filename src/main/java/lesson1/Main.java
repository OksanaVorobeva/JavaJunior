package lesson1;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> list = Arrays.asList(
                new User("Pavel", 25),
                new User("Petya", 40),
                new User("hhh", 30));
        list.stream()
                .map(user -> new User(user.name, user.age - 5))
                .filter(u->u.age<+25)
                .forEach(System.out::println);
    }

}
