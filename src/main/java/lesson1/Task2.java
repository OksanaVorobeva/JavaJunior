package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Привет", "Мир", "!", "Я", "родился");

        list.stream()
                .filter(str -> str.length() > 1)
                .filter(str -> str.contains("и"))
                .forEach(System.out::println);

        Arrays.asList(1,2,3,4,5).stream().map(e->e*e).forEach(System.out::println);


    }
}
