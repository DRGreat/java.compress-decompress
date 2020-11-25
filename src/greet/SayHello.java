package greet;


public class SayHello {
    private String name;
    private static int nextid=21;
    public class No
    {
        public void kk()
        {
            System.out.println(name);
        }
    }
    private int id=setid();
    {
        System.out.println(this.name+" "+id+" "+nextid);
        this.name="unknown";
        id=nextid;
        nextid++;
        System.out.println(this.name+" "+id+" "+nextid);
    }
    public SayHello(){
        this("ly");
        System.out.printf("my name is %s,my id is %d\n",name,id);
    }
    public SayHello(String name){
        System.out.println(this.name+" "+id+" "+nextid);
        this.name=name;
        id=nextid;
        nextid++;
        System.out.println(this.name+" "+id+" "+nextid);
    }
    private static int setid(){
        int r=nextid;
        nextid++;
        System.out.println("already set the id");
        return r;
    }
    public void sayBye()
    {
        System.out.println("nothing to say");
    }
}
