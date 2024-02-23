// Queue implementation using arrays



class Queue
{
    int front,rear,size,maxsize;
    int []queue;

    public Queue(int maxsize)
    {
        this.queue = new int[maxsize];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.maxsize = maxsize;
    }

    public void enqueue(int data) 
    {
        if(maxsize!=0)
        {
            if(isEmpty())
            {
                front = front + 1;
                rear = rear + 1;
                queue[rear] = data;
                size = size+1;
            }
            else
            {
                if(!isFull())
                {
                    rear = rear + 1;
                    queue[rear] = data;
                    size = size+1;
                }
                else{
                    System.out.println("Your queue is full.");
                }

             }
        }
    }

    public int dequeue()
    {
        int n;

        // First check whether queue is empty because, if queue is empty then you cannnot delete any elements
        if(isEmpty())
        {
            return -1;
        }
        else if(front==rear) // if front and rear are equal then it means only one element is present
        {
            n = queue[rear];
            queue[rear] = 0;
            front = front-1;
            rear = rear-1;
            size = size-1;
            return n;
        }
        else
        {
            n = queue[front];
            for(int i=0;i<size-1;i++)
            {
                queue[i] = queue[i+1];
            }
            queue[rear] = 0;
            rear = rear-1;
            size = size-1;
            return n;
        }
    }

    public boolean isEmpty()
    {
        if(rear==-1)
        {
            return true;
        }
        return false;
    }

    public boolean isFull()
    {
        if(size==maxsize)
        {
            return true;
        }
        return false;
    }
    public void display()
    {
        if(rear==-1)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            for(int i=front;i<=rear;i++)
            {
                System.out.println(queue[i]);
            }
        }
    }
}

class QueueDemo
{
    
    public static void main(String[] args) 
    {
        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        //q.enqueue(60);

        System.out.println("deleted element is: "+q.dequeue());
        System.out.println("-------------------------------");
        q.display();
        //q.enqueue(60);
        System.out.println("-------------------------------");
        q.display();
        System.out.println("Checking queue is empty or not");
        if(q.isEmpty())System.out.println("Queue is empty");
        else System.out.println("Queue is not empty");
        System.out.println("Checking Queue is full or not");
        if(q.isFull()) System.out.println("Queue is full");
        else System.out.println("Queue is not full.");
        System.out.println("Max size of queue is: "+q.maxsize);
        System.out.println("Current size of queue is: "+q.size);
    }
    
}
