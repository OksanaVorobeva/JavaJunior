package hw2;

public class Cat extends Animal{
    String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public String makeSound() {
        return "Meow! Meow!";
    }

    public void purr() {
        System.out.println(name + "is purring.");
    }

}
