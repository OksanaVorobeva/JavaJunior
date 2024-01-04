package lesson2;

public class Car {
    public String name;
    private String prise;
    private String engType;
    private String engPower;
    public int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.engType="V8";
        this.engPower="123";
        this.maxSpeed=100;
        this.prise="1000000";
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
