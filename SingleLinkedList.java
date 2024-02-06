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
                head = t1.next;
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

    public int search(int key)
    {
        int count=0;
        Node t = head;
        if(head==null)
        {
            return -1;
        }
        else{
            while(t!=null)
            {
                count=count+1;
                if(t.data==key)
                {
                    return count;
                }
                t = t.next;
            }
            return -1;
        }
    }

    public void addNodeAtLast(int newdata)
    {
        Node n1 = new Node(newdata);
        Node t1 = head;
        if(head==null)
        {
            head = n1;
        }
        else{
            while (t1.next!=null) 
            {
                t1=t1.next;    
            }
            t1.next = n1;
        }
    }

    public void insertFirst(int newdata)
    {
        Node n1 = new Node(newdata);
        if(head==null)
        {
            head = n1;
        }
        else{
            n1.next = head;
            head = n1;
        }
    }

    void reverse()
    {
        Node c = head;
        Node p = null;
        Node n = null;

        if(head==null)
        {
            System.out.println("Nothing to reverse");
        }
        else{
            while(c!=null)
            {
                n = c.next;
                c.next = p;
                p = c;
                c = n;
            }
            head = p;
            while(p.next!=null)
            {
                p = p.next;
            }
            tail = p;
        }
    }

    public void insertMiddle(int newdata)
    {
        int count = countNodes();
        Node n1 = new Node(newdata);
        Node t1 = head;
        int i=0;
        if(head == null)
        {
            head = n1;
        }

        else{ 
           
            count = (int)Math.floor(count/2);
            while(i<count-1)
            {
                t1 = t1.next;
                i++;
            }
            n1.next = t1.next;
            t1.next = n1;
           
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

        /*System.out.println("Deleting Node");

        int deldata = s1.deleteNode(10);
        System.out.println("Deleted Node data is "+deldata);
        s1.display();

        System.out.println("Displaying nodes again");
        s1.display();

        System.out.println("Counting nodes...");
        System.out.println(s1.countNodes());

        int m = s1.search(40);

        if(m==-1)
        {
            System.out.println("Key is not found");
        }
        else{
            System.out.println("Key is found at "+m);
        }*/

        /*System.out.println("Adding Node at Last...");
        s1.addNodeAtLast(70);
        s1.display();*/

        /*System.out.println("Adding Node at First...");
        s1.insertFirst(70);
        s1.display();*/

        //System.out.println("Reversing the elements in the list.");

        //s1.reverse();

        System.out.println("Insert a node at middle");
        s1.insertMiddle(100);
        System.out.println("After inserting at middle...");
        s1.display();


        
    }
    
}