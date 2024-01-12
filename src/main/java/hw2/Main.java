package hw2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal cat1=new Cat("Whiskers", 2, "Tabby");
        Animal cat2= new Cat("Mittens", 1, "White");
        Animal dog1=new Dog("Buddy", 3, "Golden Retriever");
        Animal dog2=new Dog("Max", 5, "German Shepherd");


        List<Animal> animalList=new ArrayList<>();
        animalList.add(cat1);
        animalList.add(cat2);
        animalList.add(dog1);
        animalList.add(dog2);

        System.out.println(animalList);

        for (Animal animals:
             animalList) {
            System.out.println(animals.name+" " +animals.makeSound());
        }





    }
}



