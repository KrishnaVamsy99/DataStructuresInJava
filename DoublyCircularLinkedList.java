class DoubleCircularNode
{
    DoubleCircularNode previous;
    int data;
    DoubleCircularNode next;

    public DoubleCircularNode(int data)
    {
        this.previous = next;
        this.data = data;
        this.next = previous;
    }
}

class DoublyCircularDemo
{
    DoubleCircularNode head = null;
    DoubleCircularNode tail = null;

    public void addNode(int data)
    {
        DoubleCircularNode dc1 = new DoubleCircularNode(data);
        
        if(head==null)
        {
            head = tail = dc1;
            dc1.next = dc1;
            dc1.previous = dc1;
            
        }
        else
        {
            dc1.previous = tail;
            tail.next = dc1;
            dc1.next = head;
            tail = dc1;
            head.previous = tail;
        }
    }

    public void insertFirst(int data)
    {
        DoubleCircularNode dc1 = new DoubleCircularNode(data);
        if(head==null)
        {
            head = tail = dc1;
            dc1.next = dc1;
            dc1.previous = dc1;
        }
        else
        {
            dc1.next = head;
            head.previous = dc1;
            tail.next = dc1;
            dc1.previous = tail;
            head = dc1;            
        }
    }

    public void insertLast(int data)
    {
        DoubleCircularNode dc1 = new DoubleCircularNode(data);
        if(head==null)
        {
            head = tail = dc1;
            dc1.next = dc1;
            dc1.previous = dc1;
        }
        else
        {
            dc1.previous = tail;
            tail.next = dc1;
            dc1.next = head;
            tail = dc1;
            head.previous = tail;
        }
    }

    public int countNodes()
    {
        if(head==null)
        {
            return -1;
        }
        else
        {
            int count = 1;
            DoubleCircularNode t = head;
            do
            {
                count = count+1;
                t = t.next;
            }while(t!=head);
            return count;
        }
    }

    public void insertMiddle(int data)
    {
        DoubleCircularNode dc1 = new DoubleCircularNode(data);
        
        if(head==null)
        {
            head = tail = dc1;
            dc1.next = dc1;
            dc1.previous = dc1;
        }
        else
        {
            int mid = (countNodes()%2==0)?(countNodes()/2):((countNodes()+1)/2);
            DoubleCircularNode t = head;
            for(int i=0;i<mid-2;i++)
            {
                t = t.next;
            }
            t.next.previous = dc1;
            dc1.next = t.next;
            dc1.previous = t;
            t.next = dc1;
        }
    }

    public int deleteHead()
    {
        int data;
        if(head==null)
        {
            return -1;
        }
        else if(head.next==head)
        {
            data = head.data;
            head = tail = null;
            return data;
        }
        else
        {
            tail.next = head.next;
            head.next.previous = tail;
            data = head.data;
            head.next = head.previous = null;
            head = tail.next;
            return data;
        }
    }

    public int deleteMiddleNode()
    {
        int data;
        if(head==null)
        {
            return -1;
        }
        else if(head==head.next)
        {
            data = head.data;
            head = tail = null;
            return data;
        }
        else
        {
            DoubleCircularNode t = head;
            DoubleCircularNode t1 = null;
            int mid = (countNodes()%2==0)?(countNodes()/2):((countNodes()+1)/2);
            for(int i=0;i<mid-2;i++)
            {
                t = t.next;
            }
            t1 = t.next;
            t.next = t1.next;
            t1.next.previous = t;
            data = t1.data;
            t1.previous = t1.next = null;
            return data;
        }
    }

    public int deleteTail()
    {
        int data;
        if(head==null)
        {
            return -1;
        }
        else if(head==head.next)
        {
            data = head.data;
            head = tail = null;
            return data;
        }
        else
        {
            head.previous = tail.previous;
            tail.previous.next = head;
            data = tail.data;
            tail.previous = tail.next = null;
            tail = head.previous;
            return data;
        }
    }

    public void sort()
    {
        DoubleCircularNode c = head;
        do
        {
            DoubleCircularNode t = c.next;
            do
            {
                if(c.data>t.data)
                {
                    c.data = c.data + t.data;           // a = 5, b = 3 // a = 8
                    t.data = c.data -  t.data;          // b = a-b -> 8-3 = 5
                    c.data = c.data - t.data;           // a = 8-5 = 3
                }
                t = t.next;

            }while(t!=head);
            c = c.next;
        }while(c.next!=head);
    }

    public int search(int key)
    {
        if(head==null)
        {
            return -1;
        }
        else
        {
            int count = 0;
            DoubleCircularNode t = head;
            do
            {
                count =  count+1;
                if(t.data==key)
                {
                    return count;
                }
                t = t.next;
            }while(t!=head);
            return -1;
        }
    }
    public void headDisplay()
    {
        if(head==null)
        {
            System.out.println("sorry, there are no nodes");
        }
        else if(head.next==head)
        {
            System.out.println(head.data);
        }
        else
        {
            DoubleCircularNode t = head;
            do{
                System.out.println(t.data);
                t = t.next;
            }while(t!=head);
        }

    }

    public void taildDisplay()
    {
        if(head==null)
        {
            System.out.println("sorry, there are no nodes");
        }
        else
        {
            DoubleCircularNode t = tail;
            do
            {  
                System.out.println(t.data);
                t = t.previous;

            }while(t!=tail);
        } 
    }
}
class DoublyCircularLinkedList 
{
    public static void main(String[] args)
    {
        DoublyCircularDemo dc1 = new DoublyCircularDemo();
        dc1.addNode(50);
        dc1.addNode(20);
        dc1.addNode(40);
        dc1.addNode(30);
        dc1.addNode(10);

        dc1.headDisplay();
        System.out.println("---------------------------");
        dc1.taildDisplay();
        System.out.println("---------------------------");
        dc1.insertFirst(60);
        dc1.headDisplay();
        System.out.println("---------------------------");
        dc1.insertLast(70);
        dc1.headDisplay();
        System.out.println("---------------------------");
        dc1.insertMiddle(80);
        dc1.headDisplay();
        System.out.println("---------------------------");
        int d = dc1.deleteHead();
        if(d==-1)
        {
            System.out.println("Sorry no data available.");
        }
        else
        {
            System.out.println("The deleted head element is "+d);
        }
        System.out.println("---------------------------");
        dc1.headDisplay();
        System.out.println("---------------------------");
        d = dc1.deleteMiddleNode();
        if(d==-1)
        {
            System.out.println("Sorry no data available");
        }
        else
        {
            System.out.println("The deleted middle element is "+d);
        }
        System.out.println("---------------------------");
        dc1.headDisplay();
        System.out.println("---------------------------");

        dc1.sort();
        dc1.headDisplay();

        System.out.println("---------------------------");
        int search1 = dc1.search(20);
        if(search1==-1)
        {
            System.out.println("Key is not found");
        }
        else
        {
            System.out.println("THe key found at node: "+search1);
        }


    }
    
}
