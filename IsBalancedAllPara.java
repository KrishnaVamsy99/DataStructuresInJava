import java.util.EmptyStackException;

class Stack
{
    int top,size;
    char []s;

    public Stack()
    {
        this.size = size;
        this.top = -1;
        this.s = new char[size];
    }

    public void push(char ch)
    {
        if(isFull()) return;
        top = top+1;
        s[top]=ch;
    }

    public char pop()
    {
        if(isEmpty()) throw new EmptyStackException();
        char x = s[top];
        top = top-1;
        return x;
    }

    public boolean isFull()
    {
        return top==size-1;
    }

    public boolean isEmpty()
    {
        return top==-1;
    }

    public boolean IsBalancedPara(String str)
    {
        if(str==null || str.equals("")) return false;

        char ch;
        for(int i=0;i<str.length();i++)
        {
            ch = str.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{')
            {
                push(ch);
            }
            else if(ch==')' || ch==']' || ch=='}')
            {
                if(isEmpty()) return false;
                char mytop = s[top];
                pop();
                if((ch==')' && mytop!='(') || (ch==']' && mytop!='[') || (ch=='}' && mytop!='{'))
                {
                    return false;
                }
                
            }
        }
        return isEmpty();
    }
}
public class IsBalancedAllPara 
{
    public static void main(String[] args)
    {
        String str = "";
        Stack s = new Stack(str.length());
        if(s.IsBalancedPara(str)){
            System.out.println("Paranthesis matching...");
        }
        else{
            System.out.println("Paranthesis Not Matching...");
        }
    }
    
}
