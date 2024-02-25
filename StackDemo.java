class Stack
{
    int top;
    int []s;
    int maxsize;

    public Stack(int maxsize)
    {
        this.top = -1;
        this.maxsize = maxsize;
        s = new int[maxsize];
    }
    
    public void push(int data)
    {
        if(isFull())
        {
            //System.out.println("Sorry, Stack is Full.");
            return;
        }
        else
        {
            top++;
            s[top] = data;
        }
    }

    public int pop()
    {
        int n;
        if(isEmpty())
        {
            //System.out.println("Sorry, Stack is Empty.");
            return -1;
        }
        else
        {
            n = s[top--];
            return n;
        }
    }

    public int peek()
    {
        if(!isEmpty())
        {
            return s[top];
        }
        return -1;
    }

    public boolean isFull()
    {
        if(top==maxsize-1)
        {
            return true;
        }
        return false;
    }

    public boolean isEmpty()
    {
        if(top==-1)
        {
            return true;
        }
        return false;
    }

    public void display()
    {
        if(!isEmpty())
        {
            for(int i=top;i>=0;i--)
            {
                System.out.println(s[i]);
            }
        }
    }
}

class StackDemo 
{
    public static void main(String[] args)
    {
        Stack s = new Stack(10);
        // System.out.println(s.maxsize);
        // System.out.println(s.top);

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        s.pop();


        s.display();
        System.out.println("------------------------");
        System.out.println(s.peek());

    }
    
}
