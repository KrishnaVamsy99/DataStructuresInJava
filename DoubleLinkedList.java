class DoubleNode
{
    DoubleNode previous;
    int data;
    DoubleNode next;

    public DoubleNode(int data)
    {
        this.previous = null;
        this.data = data;
        this.next = null;
    }

}
class DoubleLinkedListDemo
{
    DoubleNode head = null;
    DoubleNode tail = null;

    public void addNode(int data)
    {
        DoubleNode d1 =  new DoubleNode(data);
        

        if(head==null)
        {
            head = d1;
            tail = d1;
        }
        else
        {
            tail.next = d1;
            d1.previous = tail;
            tail = d1;
        }
    }

    public void reverseDisplay()
    {
        if(head==null)
        {
            return;
        }
        else
        {
            DoubleNode t = tail;
            while(t!=null)
            {
                System.out.println(t.data);
                t = t.previous;
            }
        }
    }

    public int deleteLastNode()
    {
        if(head == null)
        {
            return -1;
        }
        else
        {
            int n;
            n = tail.data;
            DoubleNode t = tail.previous;
            tail.previous = null;
            t.next = null;
            tail = t;
            return n;
        }
    }

    public int deleteFirstNode()
    {
        if(head==null)
        {
            return -1;
        }
        else
        {
            int n = head.data;
            head = head.next;
            head.previous.next = null;
            head.previous = null;
            return n;
        }
    }

    public int deleteMiddleNode()
    {
        if(head==null)
        {
            return -1;
        }
        else
        {
            DoubleNode t = head;
            int mid = (countNodes()%2==0)?(countNodes()/2):((countNodes()+1)/2);
            for(int i=0;i<mid-1;i++)
            {
                t = t.next;
            }
            int n = t.data;
            t.previous.next = t.next;
            t.next.previous = t.previous;
            t.previous = null;
            t.next = null;
            return n;
        }
    }

    public void insertFirst(int data)
    {
        DoubleNode d1 = new DoubleNode(data);
        if(head==null)
        {
            head = d1;
            tail = d1;
        }
        else
        {
            d1.next = head;
            head.previous = d1;
            head = d1;
        }
    }

    public void insertLast(int data)
    {
        DoubleNode d1 = new DoubleNode(data);

        if(head==null)
        {
            head = d1;
            tail = d1;
        }
        else
        {
            tail.next = d1;
            d1.previous = tail;
            tail = d1;
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
            DoubleNode t = head;
            while(t!=null)
            {
                count = count+1;
                t = t.next;
            }
            return count;
        }
    }

    public void insertMiddle(int data)
    {
        DoubleNode d1 = new DoubleNode(data);
        if(head==null)
        {
            head = d1;
            tail = d1;
        }
        else
        {
            int count = countNodes(); //5
            int mid = (int)Math.floor(count/2); //2
            DoubleNode t = head;
            int i=0;
            while(i<mid)
            {
                t = t.next;
                i++;
            }
            d1.previous = t.previous;
            t.previous.next = d1;
            d1.next = t;
            t.previous = d1;
        }
    }

    public void sort()
    {
        if(head==null)
        {
            return;
        }
        else
        {
            DoubleNode c = head;
            while (c!=null)
            {
                DoubleNode i = c.next;
                while(i!=null)
                {
                    if(c.data>i.data)
                    {
                        int temp = i.data;
                        i.data = c.data;
                        c.data = temp;
                    }
                    i = i.next;
                }
                c = c.next;   
            }
        }
    }

    public void removeDuplicates()
    {
        if(head==null || head.next == null)
        {
            return;
        }
        else
        {
            DoubleNode c = head;
            while(c!=null)
            {
                DoubleNode i = c.next;
                while(i!=null)
                {
                    if(c.data==i.data)
                    {
                        if(i!=tail)
                        {
                            i.next.previous = i.previous;
                            i.previous.next = i.next;
                        }
                        else
                        {   
                            tail = i.previous;
                            tail.next = null;
                            i.previous = null;
                        }
                    }
                   i = i.next;
                }
                c = c.next;
            }
        }
    }

    public void swapNodes(int fnum, int snum)
    {
        if(head==null || head.next == null)
        {
            return;
        }
        else
        {
            DoubleNode c = head;
            DoubleNode i = head;

            for(int j=0;j<fnum-2;j++)
            {
                c = c.next;
            }
            for(int j=0;j<snum-2;j++)
            {
                i = i.next;
            }
            DoubleNode ct = c.next;
            DoubleNode it = i.next;

            ct.previous = it.previous;
            i.next = ct;
            c.next =it;
            it.previous = c;

            if(it!=tail)
            {
                i.previous = it.next.previous;
                it.next.previous = ct;
                ct.next = it.next;
                it.next = i;
            }
            else
            {
                it.next = i;
                i.previous = it;
                ct.next = null;

            }
        }
    }

    public DoubleNode maxNode()
    {
        if(head==null || head.next==null)
        {
            return null;
        }
        else
        {
            int max = Integer.MIN_VALUE;
            DoubleNode t = head;
            DoubleNode maxinode = null;
            while(t!=null)
            {
                if(t.data>max)
                {
                    max = t.data;
                    maxinode = t;
                }
                t = t.next;
            }
            return maxinode;
        }
    }

    public DoubleNode minNode()
    {
        if(head==null || head.next==null)
        {
            return null;
        }
        else
        {
            int min = Integer.MAX_VALUE;
            DoubleNode t = head;
            DoubleNode mininode = null;
            while(t!=null)
            {
                if(t.data<min)
                {
                    min = t.data;
                    mininode = t;
                }
                t = t.next;
            }
            return mininode;
        }
    }

    public boolean isPalindrome()
    {
        if(head==null || head.next==null)
        {
            return false;
        }
        else
        {
            DoubleNode c = head;
            DoubleNode i = tail;

            while (c!=i)
            {
                if(c.data!=i.data)
                {
                    return false;
                }
                c = c.next;
                i = i.previous;
            }
            return true;
        }
    }

    public DoubleNode search(int key)
    {
        if(head==null || head.next == null)
        {
            return null;
        }
        else
        {
            DoubleNode t = head;
            while(t!=null)
            {
                if(t.data==key)
                {
                    return t;
                }
                t = t.next;   
            }
            return null;
        }
    }

    public void shiftNodes(int n)
    {
        if(head==null || head.next==null)
        {
            return;
        }
        else
        {
            DoubleNode t1;
            for(int i=0;i<n;i++)
            {
                t1 = tail.previous;
                head.previous = tail;
                tail.next = head;
                tail.previous = null;
                tail = t1;
                tail.next = null;
            }
        }
    }
    public void display()
    {
        if(head==null)
        {
            return;
        }
        else
        {
            DoubleNode t = head;
            while(t!=null)
            {
                System.out.println(t.data);
                t = t.next;
            }
        }
    }

}
class DoubleLinkedList 
{
    public static void main(String[] args) 
    {
        DoubleLinkedListDemo dl1 = new DoubleLinkedListDemo();
        dl1.addNode(10);
        dl1.addNode(20);
        dl1.addNode(30);
        dl1.addNode(40);
        dl1.addNode(50);

        dl1.display();
        /*System.out.println("----------------------");
        dl1.reverseDisplay(); 
        
        System.out.println("----------------------");
        int n = dl1.deleteLastNode();

        if(n==-1)
        {
            System.out.println("Sorry, there are no nodes in the list.");
        }
        else
        {
            System.out.println("The deleted last node data is "+n);

        }
        dl1.display();

        System.out.println("................................");
        dl1.insertFirst(60);
        dl1.display();
        System.out.println("................................");
        dl1.insertLast(70);
        dl1.display();
        System.out.println("................................"); */
        //System.out.println("................................");
        // dl1.insertMiddle(100);
        // dl1.display();
        //System.out.println(dl1.countNodes());
        /*System.out.println("................................");
        int deletedNode = dl1.deleteFirstNode();
        if(deletedNode==-1)
        {
            System.out.println("Sorry, there are no elements in the list");
        }
        else{
            System.out.println("The deleted node is "+deletedNode);
        }*/
        /*System.out.println("....................................");
        int deletedMiddleNode = dl1.deleteMiddleNode();
        if(deletedMiddleNode == -1)
        {
            System.out.println("Sorry, there are no elements in the list");
        }
        else{
            System.out.println("The deleted node is "+deletedMiddleNode);
        }*/
        //System.out.println(".....................................");
        //dl1.swapNodes(2,4);
        //dl1.display();
        //System.out.println("....................................");

        //System.out.println(dl1.maxNode().data);
        //System.out.println(dl1.minNode().data);

        System.out.println(".................................");
        
        /*if(dl1.isPalindrome())
        {
            System.out.println("The given list is palindrome.");
        }
        else
        {
            System.out.println("The given list is not palindrome.");
        }*/

        /*DoubleNode t = dl1.search(30);
        if(t==null)
        {
            System.out.println("Sorry, the key is not found");
        }
        else
        {
            System.out.println("The node of the key is: "+t+" and its data is "+t.data);
        }*/

        dl1.shiftNodes(2);
        dl1.display();



    }
    
}
