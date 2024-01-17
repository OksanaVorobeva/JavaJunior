package lesson3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String str ="Всем привет!";
        FileOutputStream fileOutputStream=new FileOutputStream("test.txt");
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(str);
        objectOutputStream.close();

    }
}
