class CircularNode
{
    int data;
    CircularNode next;

    public CircularNode(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class SingleCircularLinkedListDemo
{
    CircularNode head = null;
    CircularNode tail = null;

    public void addNode(int data)
    {
        CircularNode n1 = new CircularNode(data);

        if(head==null)
        {
           head = tail = n1;
           n1.next = head; 
        }
        else
        {
            tail.next = n1;
            tail = tail.next;
            tail.next = head;
        }
    }

    public void insertFirst(int data)
    {
        CircularNode n1 = new CircularNode(data);
        if(head==null)
        {
            head = tail = n1;
            n1.next = head;
        }
        else
        {
            n1.next = head;
            tail.next = n1;
            head = n1;
        }
    }

    public void insertLast(int data)
    {
        CircularNode n1 = new CircularNode(data);
        
        if(head==null)
        {
            head = tail = n1;
            n1.next = head;
        }
        else
        {
            tail.next = n1;
            n1.next = head;
            tail = n1;
        }
    }

    public int countNodes()
    {
        if(head==null)
        {
            return 0;
        }
        else
        {
            int count=0;
            CircularNode t = head;
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
        CircularNode n1 = new CircularNode(data);

        if(head==null)
        {
            head = tail = n1;
            n1.next = head;
        }
        else
        {
            int mid = (countNodes()%2==0)?(countNodes()/2):((countNodes()+1)/2);
            CircularNode  t = head;
            
            for(int i=0;i<mid-2;i++)
            {
                t = t.next;
            }

            n1.next = t.next;
            t.next = n1;

        }
    }

    public int deleteFirstNode()
    {
        if(head==null )
        {
            return -1;
        }
        else
        {
            CircularNode t = head;
            tail.next = t.next;
            head = head.next;
            t.next = null;
            return t.data;
        }

    }

    public int deleteLastNode()
    {
        if(head==null)
        {
            return -1;
        }
        else
        {
            CircularNode t = head;
            while(t.next!=tail)
            {
                t = t.next;
            }
            t.next = head;
            tail.next = null;
            return tail.data;
        }
    }

    public int deleteMiddleNode()
    {
        if(head==null)
        {
            return -1;
        }
        else{
            CircularNode t1 = null;
            CircularNode t = head;
            int mid = (countNodes()%2==0)?(countNodes()/2):((countNodes()+1)/2);
            for(int i=0;i<mid-2;i++)
            {
                t = t.next;
            }
            t1 = t.next;
            t.next = t1.next;
            t1.next =  null;
            return t1.data;
        }
    }

    public void sort()
    {
        if(head==null || head.next==head)
        {
            return;
        }
        else
        {
            CircularNode c = head;
            while(c.next!=head)
            {
                CircularNode t = c.next;
                while(t.next!=head)
                {
                    if(c.data>t.data)
                    {
                        int temp = c.data;
                        c.data = t.data;
                        t.data = temp;
                    }
                    t = t.next;
                }
                c = c.next;
            }
        }
    }

    public int search(int key)
    {
        if(head==null)
        {
            return -1;
        }
        else
        {
            CircularNode t = head;
            int count = 0;
            do
            {
                count = count + 1;
                if(t.data==key)
                {
                    return count;
                }
                t = t.next;

            }while(t.next!=head);
        }
        return -1;
    }

    public void display()
    {
        CircularNode t = head;

        do{
            System.out.println(t.data);
            t = t.next;
        }while(t!=head);
    }
}
class SingleCircularLinkedList
{
    public static void main(String[] args)
    {
        SingleCircularLinkedListDemo scld = new SingleCircularLinkedListDemo();
        scld.addNode(10);
        scld.addNode(20);
        scld.addNode(30);
        scld.addNode(40);
        scld.addNode(50);

        scld.display();
        System.out.println("------------------------");

        scld.insertFirst(60);
        scld.display();

        System.out.println("-------------------------");
        scld.insertLast(70);
        scld.display();
        System.out.println("-------------------------");
        System.out.println(scld.countNodes());
        System.out.println("----------------------------");
        scld.insertMiddle(80);
        scld.display();
        int headdata = scld.deleteFirstNode();
        if(headdata==-1)
        {
            System.out.println("Sorry there are no nodes");
        }
        else{
            System.out.println("The deleted head element is "+headdata);
        }
        System.out.println("---------------------------------------");
        scld.display();
        int taildata = scld.deleteLastNode();
        if(taildata==-1)
        {
            System.out.println("Sorry there are no nodes");
        }
        else
        {
            System.out.println("The deleted head element is "+taildata);
        }
        System.out.println("---------------------------------------");
        scld.display();
        System.out.println("---------------------------------------");
        int middledata = scld.deleteMiddleNode();
        if(middledata==-1)
        {
            System.out.println("Sorry, there are no nodes");
        }
        else{
            System.out.println("The deleted middle element is "+middledata);
        }
        System.out.println("---------------------------------------");
        scld.display();
        System.out.println("---------------------------------------");
        scld.sort();
        scld.display();
        System.out.println("-------------------");
        int key = scld.search(90);
        if(key==-1)
        {
            System.out.println("Sorry, key is not available");
        }
        else{
            System.out.println("The given key is available at "+ key);
        }



        
    }
    
}
