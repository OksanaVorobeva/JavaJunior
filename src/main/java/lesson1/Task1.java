package lesson1;

public class Task1 {
    public static void main(String[] args) {
       /* PlainInterface plainInterface=new PlainInterface() {
            @Override
            public String action(int x, int y) {
                return String.valueOf(x+y);
            }
        };*/

        PlainInterface plainInterface = (x, y) -> x + y;
        PlainInterface plainInterface1=(x,y)->Integer.compare(x,y);
        PlainInterface plainInterface2=Integer::compare;


        System.out.println(plainInterface.action(5, 3));
        System.out.println(plainInterface1.action(1,5));
        System.out.println(plainInterface2.action(1,5));
    }
}
