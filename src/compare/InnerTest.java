package compare;

import java.util.Arrays;

public class InnerTest {
    public static void main(String[] args)
    {
        Sort s=new Sort();
        String[] a=new String[]{"safaddfac","sadasd","sadaczcdsad","sad"};
        s.rank(a);
        System.out.println(Arrays.toString(a));
    }
}
