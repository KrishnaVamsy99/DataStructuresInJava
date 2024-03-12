import java.util.EmptyStackException;
import java.util.Scanner;

class Stack
{
    int size,top;
    char []st;

    public Stack(int size)
    {
        this.size=size;
        this.top=-1;
        this.st = new char[size];
    }

    public void push(char ch)
    {
       if(isFull())return;

        top = top+1;
        st[top] = ch;
    }

    public char pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            
            char x = st[top];
            top--;
            return x;
        }
    }

    public boolean isFull()
    {
        return top==size-1;
    }
    
    public boolean isEmpty()
    {
        return top==-1;
    }

    public boolean IsBalanced(String str)
    {
        if (str == null || str.equals("")) // Return true if the string is empty
            return false;
        char ch;
        for(int i=0;i<str.length();i++)
        {
            ch = str.charAt(i);

            if(ch=='(')
            {
                push(ch);
            }
            else
            {
                if(ch==')')
                {
                    if(isEmpty())
                    {
                        return false;
                    }
                    pop();
                }
            }
        }
        
        return isEmpty();
    }
}
class IsBalancedPara
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string:");
        String str = sc.nextLine();
        Stack st = new Stack(str.length());
      
        if(st.IsBalanced(str))System.out.println("The paranthesis is matching...");
        else System.out.println("The paranthesis is not matching...");

        sc.close();
    }
}