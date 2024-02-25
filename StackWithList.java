class StackNode
{
    StackNode previous;
    int data;
    StackNode next;

    public StackNode(int data)
    {
        this.previous = null;
        this.data = data;
        this.next = null;
    }
}

class Stack
{
    StackNode top;
    int maxsize;
    int size;

    public Stack(int maxsize)
    {
        this.top = null;
        this.maxsize = maxsize;
        this.size = 0;
    }

    public void push(int data)
    {
        StackNode s = new StackNode(data);
        if(isEmpty())
        {
            top = s;
            size++;
        }
        else
        {
            top.next = s;
            s.previous = top;
            top = s;
            size++;
        }
        

    }

    public int  pop()
    {

        if(!isEmpty())
        {
            int n = top.data;
            top = top.previous;
            top.next = null;
            size--;
            return n;
        }
        return -1;
    }

    public int peek()
    {
        if(!isEmpty())
        {
            return top.data;
        }
        return -1;

    }

    public boolean isEmpty()
    {
        if(top==null) return true;
        return false;
    }
    public boolean isFull()
    {
        if(size==maxsize) return true;
        return false;
    }

    public void display()
    {
        if(!isEmpty())
        {
            StackNode temp = top;
            while (temp!=null) 
            {
                System.out.println(temp.data);
                temp = temp.previous;
            }
        }
    }
}

class StackWithList
{
    public static void main(String[] args) 
    {
        
        Stack stk = new Stack(10);
        
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);

        System.out.println(stk.peek());

        System.out.println("-----------------");

        stk.display();
    }
}
