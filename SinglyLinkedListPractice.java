import java.util.Scanner;

class Node1
{
    int data;
    Node next;

    public Node1(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class LinkedListPractice
{
    Node head = null;
    Node tail = null;

    public void addNode(int data)
    {
        Node n1 = new Node(data);
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
        int n;
        Node t=head;
        Node t1=null;
        if(head == null)
        {
            return -1;
        }
        while(t.next!=null)
        {
            t1 = t;
            t = t.next;
        }
        if(t==head)
        {
            n = t.data;
            head = null;
            tail = null;
            t = null;
            return n;
        }
        else{
            n = t.data;
            t1.next = null;
            tail = t1;
            t =null;
            return n;
        }
    }

    public void reverseList()
    {
        if(head == null)
        {
            System.out.println("Nothing to reverse in list");
        }
        else
        {
            Node c = head;
            Node p = null;
            Node n = null;
            
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

    public int countNodes()
    {
        if(head == null)
        {
            return 0;
        }
        else{
            int count=0;
            Node t = head;
            while(t!=null)
            {
                count = count+1;
                t = t.next;
            }
            return count;
        }
    }

    public int searchElement(int key)
    {
        if(head==null)
        {
            return 0;
        }
        else
        {
            Node t = head;
            int count=1;
            // key -> 80
            // 50, 40, 30, 20, 10, 60
            while(key!=t.data && t.next!=null)
            {
                count = count+1;
                t = t.next;
            }
            if(key==t.data)
            {
                return count;
            }
            else
            {
                return -1;

            }

        }
    }

    public void insertAtFirst(int data)
    {
        Node n1 = new Node(data);
        if(head == null)
        {
            head = n1;
        }
        else
        {
            n1.next = head;
            head = n1;
        }
    }

    public void insertAtMiddle(int data)
    {
        Node n1 = new Node(data);
        if(head == null)
        {
            head = n1;
        }
        else
        {
            int i=0;
            Node t = head;
            int count = countNodes();
            int midval = (int)Math.floor(count/2);
            while(i<midval-1)
            {
                i++;
                t = t.next;
            }
            n1.next = t.next;
            t.next = n1;
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
            

            while(c!=null)
            {
                Node t = c;
                Node i = c.next;
                while(i!=null)
                {
                    if(c.data!=i.data)
                    {
                        t = i;
                    }
                    else
                    {
                        t.next = i.next;
                        if(i==tail && i.next==null)
                        {
                            tail = t;
                        }
                    }
                    i = i.next;
                }
                c = c.next;
            }

        }
    }

    public boolean isPalindrome()
    {
        if(head == null)
        {
            return false;
        }
        else
        {
            Node c = head;
            boolean flag = true;
            int mid = (countNodes()%2==0)?(countNodes()/2):((countNodes()+1)/2);

            for(int i=0;i<mid;i++)
            {
                c = c.next;
            }

            Node revhead = reverseList(c.next);

            while (head!=null && revhead!=null)
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

    public Node reverseList(Node temp)
    {
        Node c = temp;
        Node p = null;
        Node n = null;

        if(temp == null)
        {
            return null;
        }

        while(c!=null) 
        {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    public void display()
    {
        Node t=head;
        while(t!=null)
        {
            System.out.println(t.data);
            t = t.next;
        }
    }
}
class SinglyLinkedListPractice
{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        LinkedListPractice llp1 = new LinkedListPractice();
        llp1.addNode(10);
        llp1.addNode(20);
        llp1.addNode(30);
        llp1.addNode(10);
        llp1.addNode(50);
        llp1.addNode(20);
        llp1.addNode(40);
        llp1.addNode(10);
        //llp1.display();
        
        /*llp1.reverseList();
        System.out.println("after reversing links...");
        llp1.display();
        llp1.addNode(60);
        System.out.println("Added new node to see my reversed linking is working...");
        llp1.display();

        System.out.println("No of nodes are: "+llp1.countNodes());
        System.out.println("Enter key element to find...");
        int key =  s.nextInt();
        int find = llp1.searchElement(key);
        if(find==0)
        {
            System.out.println("Sorry. Your List is empty and Head is pointing to null...");
        }
        else if(find==-1)
        {
            System.out.println(key+" is not found in the list...");
        }
        else
        {
            System.out.println(key+" is found at index "+find);

        }*/
        //llp1.insertAtFirst(70);
        /*llp1.insertAtMiddle(100);
        llp1.display();*/

        /*llp1.removeDuplicates();
        System.out.println();
        llp1.display();*/

        if(llp1.isPalindrome())
        {
            System.out.println("The Singly linked list is palindrome.");
        }
        else
        {
            System.out.println("The singly linked list is not palindrome.");
        }

       
        s.close();

    }
    
}
