class Stack
{
    int top,size;
    char []ch;

    public Stack(int size)
    {
        this.size = size;
        this.top = -1;
        this.ch = new char[size];
    }
}
public class IsBalancedAllPara 
{
    public static void main(String[] args)
    {
        String str = "{a+[b*(c+d)-e]}";
        Stack s = new Stack(str.length());   
    }
    
}
