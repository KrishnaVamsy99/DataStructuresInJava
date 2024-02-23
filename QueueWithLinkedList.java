class QueueNode 
{
    QueueNode previous;
    int data;
    QueueNode next;
    int size;
    int maxsize;

    public QueueNode(int data)
    {
        this.previous= null;
        this.data = data;
        this.next = null;

    }
}
class QueueLinkedList
{
    QueueNode front;  // Front is Head here
    QueueNode rear; // Tail is Rear here
    int size;
    int maxsize;

    public QueueLinkedList(int maxsize)
    {
        this.front = this.rear = null;
        this.size=0;
        this.maxsize = maxsize;
    }

    public void enqueue(int data)
    {
        QueueNode q1 = new QueueNode(data);
        
        if(front==null) // front is empty, then queue is null
        {
            front= rear = q1; // q1 will be the head becuase this node is the first node
            size++;
        }
        else
        {
            rear.next = q1;
            q1.previous = rear;
            rear = q1;
            size++;
        }
    }

    public int dequeue()
    {
        if(isEmpty())return -1;

        QueueNode t = front;
        int n = t.data;
        
        if(size==1)
        {
            t = front = rear = null;
            size--;
            return n;
        }
        else
        {
            front = t.next;
            t.next = null;
            front.previous = null;
            size--;
            return n;
        }
    }

    public boolean isEmpty()
    {
        if(size==0)
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
        if(isEmpty())
        {
            System.out.println("Queue is empty");
        }
        else
        {
            QueueNode t = front;
            while(t!=null)
            {
                System.out.println(t.data);
                t = t.next;
            }
        }
    }
}
public class QueueWithLinkedList 
{
    public static void main(String[] args)
    {
        QueueLinkedList q1 = new QueueLinkedList(5);
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);
        q1.enqueue(50);

        System.out.println("------------------------------");

        System.out.println("deleted element is: "+q1.dequeue());
        q1.display();

        System.out.println("Current SIze: "+q1.size);
        System.out.println("max SIze: "+q1.maxsize);

        if(q1.isEmpty()) System.out.println("Queue is empty");
        else System.out.println("Queue is not empty");

        if(q1.isFull()) System.out.println("Queue is full");
        else System.out.println("Queue is not full");

    }   
}
