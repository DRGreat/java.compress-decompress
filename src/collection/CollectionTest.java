package collection;
import java.util.*;
import java.util.function.Predicate;

public class CollectionTest {
    public static void main(String[] args)
    {
        var a=new ArrayList<String>();
        a.add("nosdfd");
        a.add("yes");
        a.add("acsaas");
        a.add("a");
        Object[] d=a.toArray();
        for(Object e:d)
        {
            System.out.println(e.getClass().getName());
        }
        String[] b=new String[3];
        String[] c=a.toArray(b);
        for(String e:b)
            System.out.println(e);
        for(String e:c)
            System.out.println(e);
        System.out.println(Objects.hash(Objects.hashCode("asasa"),324132));
        Comparator<String> cmp=(a0,b0)->a0.length()-b0.length();

        Arrays.sort(c,cmp);
        for(String e:c)
            System.out.println(e);
    }
}
