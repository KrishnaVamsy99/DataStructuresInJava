import java.util.Scanner;

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
            return;
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

    public int deleteHead()
    {
        if(head == null)
        {
            return -1;
        }
        else{
            Node t = head.next;
            int n = head.data;
            head.next = null;
            head = t;
            return n;
        }
    }

    public void removeDuplicates()
    {
        if(head==null)
        {
            return;
        }
        else
        {
            Node c = head;
            

            while (c!=null)
            {
                Node t = c;
                Node i = c.next;
                while(i!=null)
                {
                    if(c.data==i.data)
                    {
                        t.next = i.next;
                        if(i==tail && i.next==null)
                        {
                            tail = t;
                        }
                    }
                    else{
                        t = i;
                    }
                    i = i.next;
                }
                c = c.next; 
            }
            //System.out.println("printint tail data: "+tail.data);

        }
    }

    public Node reverseList(Node temp)
    {
        Node c = temp;
        Node p = null;
        Node n = null;

        if(head==null)
        {
            return null;
        }
        while (c!=null) 
        {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    public boolean isPalindrome()
    {
        if(head==null)
        {
            return false;
        }
        else
        {
            boolean flag = true;
            Node c = head;
            int mid = (countNodes()%2==0)?(countNodes()/2):((countNodes()+1)/2);

            for(int i=0;i<mid;i++)
            {
                c = c.next;
            }

            Node revhead = reverseList(c.next);

            while(head!=null && revhead!=null)
            {
                if(head.data!=revhead.data)
                {
                    flag = false;
                    break;
                }
                head = head.next;
                revhead = revhead.next;
            }
            if(flag)
            {
                return true;
            }
            else{
                return false;
            }

        }
    }

    public void swapHeadTail()
    {
        if(head==null)
        {
            return;
        }
        else
        {
            Node c = head;
            Node i = c.next;
            while(i.next!=null)
            {
                i = i.next;
            }

            c.data = c.data + i.data;
            i.data = c.data - i.data;
            c.data = c.data - i.data;

        }
    }

    public Node maxNode()
    {
        if(head == null)
        {
            return null;
        }
        else
        {
            int maxi = Integer.MIN_VALUE;
            Node maxiNode = null;
            Node c = head;
            while(c!=null)
            {
                if(maxi<c.data)
                {
                    maxi = c.data;
                    maxiNode = c;
                }
                c = c.next;
            }
            return maxiNode;
        }
    }
    public Node minNode()
    {
        if(head == null)
        {
            return null;
        }
        else
        {
            int mini = Integer.MAX_VALUE;
            Node miniNode = null;
            Node c = head;
            while(c!=null)
            {
                if(mini>c.data)
                {
                    mini = c.data;
                    miniNode = c;
                }
                c = c.next;
            }
            return miniNode;
        }
    }

    public boolean swapTwoNodes(int fnum, int snum)
    {
        if(head == null)
        {
            return false;
        }
        else
        {
            if(fnum>countNodes() || snum>countNodes() || fnum==snum)
            {
                return false;
            }
            else
            {
                Node curent = head;
                Node index = head;

                for(int i=0;i<fnum-2;i++)
                {
                    curent = curent.next;
                }

                for(int j=0;j<snum-2;j++)
                {
                    index = index.next;
                }

                Node currentNext = curent.next;
                Node indexNext = index.next;

                if(indexNext.next!=null)
                {
                    curent.next = indexNext;
                    index.next = currentNext;
                    currentNext.next = indexNext.next;
                    indexNext.next = index;
                    
                }
                else
                {
                    curent.next = indexNext;
                    index.next = currentNext;
                    indexNext.next = currentNext.next;
                    currentNext.next = null;
                    tail  = currentNext;
                }
            }
        }
        return true;
    }

    public int removeMiddle()
    {
        if(head == null)
        {
            return -1;
        }
        else
        {
            Node current = head;
            int mid = (countNodes()%2==0)?(countNodes()/2):((countNodes()+1)/2);
            int n;
            for(int i=0;i<mid-2;i++)
            {
                current = current.next;
            }
            Node i = current.next;
            if(i!=null)
            {
                n=i.data;
                current.next = i.next;
                i.next = null;
            }
            else{
                n = current.data;
                current = head = null;
            }
            
            return n;
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
        Scanner scan = new Scanner(System.in);

        SingleExample s1 = new SingleExample();

        System.out.println("Adding Nodes");
        s1.addNode(10);
        s1.addNode(20);
        s1.addNode(30);
        s1.addNode(40);
        s1.addNode(50);
        
        
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

        /*System.out.println("Insert a node at middle");
        s1.insertMiddle(100);
        System.out.println("After inserting at middle...");
        s1.display();*/

        System.out.println();

        /*int n = s1.deleteHead();
        if(n==-1)
        {
            System.out.println("Sorry, there are no nodes in the single linked list.");
        }
        else{
            System.out.println(n+" is deleted from the single linked list.");
        }

        System.out.println();

        s1.display();*/


        //s1.removeDuplicates();

        //s1.display();

        /*if(s1.isPalindrome())
        {
            System.out.println("The single linked list is palindrome");
        }
        else
        {
            System.out.println("THe single linked list is not a palindrome");
        }*/

        //s1.swapHeadTail();
        //s1.display();
        /*Node maxi = s1.maxNode();
        System.out.println("Printing Max Node address: "+maxi);
        System.out.println("Printing Max Node data: "+ maxi.data);

        Node mini = s1.minNode();
        System.out.println("Printing Min Node address: "+mini);
        System.out.println("Printing Min Node data: "+ mini.data);*/
        /*System.out.println("Enter 1st postion");
        int m = scan.nextInt();
        System.out.println("Enter 2nd postion");
        int n = scan.nextInt();
        if(s1.swapTwoNodes(m,n))
        {
            s1.display();
        }
        else{
            System.out.println("Please enter different valid numbers");
        }*/

        int n = s1.removeMiddle();
        System.out.printf("The deleted element is %d\n",n);

        s1.display();

        scan.close();

        
    }
    
}