package greet;
import java.util.Arrays;
import java.util.Comparator;


public class LambdaTest
{
    public static void main(String[] args)
    {

        String[] s=new String[]{"sdasdsad","asdsa","ads","s"};
        Arrays.sort(s,String::compareTo);
        System.out.println(Arrays.toString(s));
        Sit.show();

        Sit sit=(int id)->System.out.println("i sit the"+id+"chair");
        sit.anction(1);
        sit.announce();

    }
}
