package compare;
import java.util.*;

public class Sort {
    public  void rank(String[] a)
    {
        Arrays.sort(a,new Comp());
    }
    public class Comp implements Comparator<String>
    {
        public int compare(String a,String b)
        {
            return a.length()-b.length();
        }
    }
}
