package hw2;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


/*Задача 1:
        Создайте абстрактный класс "Animal" с полями "name" и "age".
        Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
        Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
        Выведите на экран информацию о каждом объекте.
        Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.*/
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {

        Class<?> cat = Class.forName("hw2.Cat");
        Class<?> dog = Class.forName("hw2.Dog");
        Class<?> animal = Class.forName("hw2.Animal");


        Constructor constructor1 = cat.getConstructor(String.class,
                int.class, String.class);
        Constructor constructor2 = dog.getConstructor(String.class,
                int.class, String.class);

        Object cat1 = constructor1.newInstance("Whiskers", 2, "Tabby");
        Object cat2 = constructor1.newInstance("Mittens", 1, "White");
        Object dog1 = constructor2.newInstance("Buddy", 3, "Golden Retriever");
        Object dog2 = constructor2.newInstance("Max", 5, "German Shepherd");


        Object[] animalsList = new Object[4];

        animalsList[0] = cat1;
        animalsList[1] = cat2;
        animalsList[2] = dog1;
        animalsList[3] = dog2;
        System.out.println(Arrays.toString(animalsList));


        Method displayInfoMethod = animal.getDeclaredMethod("makeSound");

        for (int i = 0; i < animalsList.length; i++) {
            System.out.println(displayInfoMethod.invoke(animalsList[i]));
        }
    }
}










