package greet;

public class Main
{
    public static void printArgs(String... args){
        System.out.println(args);
        for(String a:args){
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args)
    {
        Main.printArgs("javac","--jar","cdr.jar");

    }
}
