package hw2;

public class Dog extends Animal{
    String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }


    @Override
    public String makeSound() {
        return "Woof! Woof!";
    }

    public void wagtail(){
        System.out.println(name + "is wagging its tail.");
    }

    }

