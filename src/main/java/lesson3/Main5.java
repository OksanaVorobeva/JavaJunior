package lesson3;

import java.io.*;
import java.util.ArrayList;

public class Main5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyFCs myFCs = new MyFCs("Ivanov", "Ivan", "Ivanovich");
        serialObj(myFCs, "test.txt");

       MyFCs myFCs1= (MyFCs) deSerialObj("test.txt");
        System.out.println(myFCs1);

    }

    public static void serialObj(Object o, String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }

    public static Object deSerialObj(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }

    static class MyFCs implements Serializable{
        private String lName;
        private String fName;
        private String patronymic;

        private static final long serialVersionUID=1L;

        public MyFCs(String lName, String fName, String patronymic) {
            this.lName = lName;
            this.fName = fName;
            this.patronymic = patronymic;
        }

        @Override
        public String toString() {
            return "MyFCs{" +
                    "lName='" + lName + '\'' +
                    ", fName='" + fName + '\'' +
                    ", patronymic='" + patronymic + '\'' +
                    '}';
        }
    }
}
