package greet;
import java.util.Date;

public class Student implements Person,Named,Cloneable
{
    private Date birthday=new Date(100000000L);
    public void show()
    {
        System.out.println(birthday);
    }
    public void modify(long days)
    {
        birthday.setTime(days);
    }
    public String getName()
    {
        return Person.super.getName();
    }
//    public Student clone() throws CloneNotSupportedException {
//        var a=(Student)super.clone();
//        a.birthday=(Date)birthday.clone();
//        return a;
//    }
    public static void main(String[] args) throws CloneNotSupportedException {
        var a=new Student();
        Student b=(Student)a.clone();
        a.show();
        b.show();
        a.modify(1000000L);
        a.show();
        b.show();
        System.out.println(a.getName());
    }
}