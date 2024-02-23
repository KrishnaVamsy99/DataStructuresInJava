// Queue implementation using arrays



class Queue
{
    int front,rear;

    public Queue()
    {
        this.front=-1;
        this.rear=-1;
    }

    public void insertRear(int data, int []arr) 
    {
        if(arr.length!=0)
        {
                // Checking if array length is not empty. if it is empty then don't do anything. just add return
            if(front==-1 && rear==-1)
            {
                // Checking if array is empty.
                // if front and rear is equal to -1 then queue is empty
                // when we are adding first element both front and rear will be -1
                // So, we have to move both pointers to first index of array and add the data into the array

                front = front + 1;
                rear = rear + 1;
                arr[rear] = data;
            }
            else
            {
                // If front and rear are not equeal to -1, then there one or more elements are presents in the array.
                // We have to check for the rear that if it is equal to length-1 of the list.
                   
                // if(rear<arr.length-1)
                // {
                //     rear = rear + 1;
                //     arr[rear] = data;
                // }
                // else
                // {
                //     System.out.println("Your queue is full.");    
                // }

                if(!isFull(arr))
                {
                    rear = rear + 1;
                    arr[rear] = data;
                }
                else{
                    System.out.println("Your queue is full.");
                }

             }
        }
    }

    public int deleteFront(int []arr)
    {
        int n;

        // First check whether queue is empty because, if queue is empty then you cannnot delete any elements
        if(front==-1 && rear==-1)
        {
            return -1;
        }
        else if(front==rear)
        {
            n = arr[rear];
            arr[rear] = 0;
            front = front-1;
            rear = rear-1;
            return n;
        }
        else
        {
            n = arr[front];
            for(int i=front;i<rear;i++)
            {
                arr[i] = arr[i+1];
            }
            arr[rear] = 0;
            rear = rear-1;
            return n;
        }
    }

    public boolean isEmpty(int []arr)
    {
        if(rear==-1)
        {
            return true;
        }
        return false;
    }

    public boolean isFull(int []arr)
    {
        if(rear==arr.length-1)
        {
            return true;
        }
        return false;
    }
    public void display(int []arr)
    {
        if(rear==-1)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            for(int i=front;i<=rear;i++)
            {
                System.out.println(arr[i]);
            }
        }
    }
}

class QueueDemo
{
    
    public static void main(String[] args) 
    {
        int []arr = new int[5]; // {0,0,0,0,0}

        Queue q1 = new Queue();

        if(q1.isEmpty(arr))
        {
            System.out.println("Queue is empty");
        }

        q1.insertRear(10, arr);
        q1.insertRear(20, arr);
        q1.insertRear(30, arr);
        q1.insertRear(40, arr);
        q1.insertRear(50, arr);
        q1.display(arr);

        if(q1.isFull(arr))
        {
            System.out.println("Queue is full");
        }
    }
    
}
