import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Equals {
    public static void run() {
        String one = "hello world!";
//        String two = "hello world!";
        String two = new String("hello world!");
        System.out.println( one == two);
        System.out.println(one.equals(two));

        Object o = one;
        Object t = two;
        System.out.println(one.equals(t));
    }
}
