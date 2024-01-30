class Node
{
    int data;
    Node next;

    public Node(int newdata)
    {
        this.data = newdata;
        this.next = null;
    }

}

class SingleExample
{
    Node head = null;
    Node tail = null;

    public void addNode(int newdata)
    {
        Node  n1 = new Node(newdata);
        if(head == null)
        {
            head = n1;
            tail = n1;
        }
        else{
            tail.next = n1;
            tail = n1;
        }
    }

    public int deleteLastNode()
    {
        Node t1 = head;
        Node t2 = null;
        int n;

        while(t1.next!=null)
        {
            t2 = t1;
            t1 = t1.next;
        }
        if(head==null)
        {
            return -1;
        }
        else if(t1==head)
        {
            n = head.data;
            head = t1.next;
            return n;
        }
        else{
            n = t1.data;
            t2.next = tail.next;
            tail = t2;
            return n;
        }
    }

    public int deleteNode(int key)
    {
        int n;
        Node t1 = head;
        Node t2 = null;

        if(head==null)
        {
            return -1;
        }

        else{
            while(t1!=null && t1.data!=key) 
            {
                t2 = t1;
                t1 = t1.next;
            }
            if(t1==null)
            {
                return -1;
            }
            else if(t1==head)
            {
                
                n = t1.data;
                head.next = t1.next;
                t1 = t1.next;
                return n;
            }
            else{
                n = t1.data;
                t2.next = t1.next;
                t1.next = null;
                return n;
            }
        }
    }

    public int countNodes()
    {
        int count = 0;
        Node t1 = head;
        if(head==null)
        {
            return -1;
        }
        else{
            while(t1!=null)
            {
                count=count+1;
                t1 = t1.next;
            }
            return count;
        }

    }

    public void display()
    {
        Node t1 = head;
        while(t1!=null)
        {
            System.out.println(t1.data);
            t1 = t1.next;
        }
    }
}
class SingleLinkedList
{
    public static void main(String[] args) 
    {
        SingleExample s1 = new SingleExample();

        System.out.println("Adding Nodes");
        s1.addNode(10);
        s1.addNode(20);
        s1.addNode(30);
        s1.addNode(40);
        s1.addNode(50);
        s1.addNode(60);
        
        System.out.println("Added Nodes Successfully");
        
        
        System.out.println("Displaying nodes when nodes are added.");
        s1.display();

        System.out.println("Deleting Node");

        int deldata = s1.deleteNode(40);
        System.out.println("Deleted Node data is "+deldata);

        System.out.println("Displaying nodes again");
        s1.display();

        System.out.println("Counting nodes...");
        System.out.println(s1.countNodes());


        
    }
    
}