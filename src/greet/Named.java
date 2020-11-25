package greet;

interface Named
{
    default String getName()
    {
        return getClass().getName()+"_"+hashCode();
        // return "asdasd";
    }
}

