package greet;

interface Person
{
    default String getName()
    {
        return "";
    }
}
