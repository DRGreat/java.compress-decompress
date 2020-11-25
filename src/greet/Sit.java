package greet;

public interface Sit
{
    static int show()
    {
     return  12;
    }
    default void announce()
    {
        System.out.println("sit the 12 chair");
    }
    void anction(int id);
}
