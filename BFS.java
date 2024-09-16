import java.util.LinkedList;
import java.util.Queue;

class Graph
{
    private int[][] adjacencyMatrix;
    private int vertices;

    public Graph(int vertices)
    {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination)
    {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public void removeEdge(int source, int destination)
    {
        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0;
    }
    
    public void breadthFirstSearch(int source)
    {
        boolean []visted = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        int u;
        // System.out.println(source);
        visted[source] = true;
        queue.add(source);

        while(!queue.isEmpty())
        {
            u = queue.poll();
            System.out.println(u);
            for(int i=0; i<vertices; i++)
            {
                if(adjacencyMatrix[u][i]==1 && !visted[i])
                {
                    queue.add(i);
                    visted[i] = true;
                }
            }
        }

        System.out.println();
    }
}
class BFS
{
    public static void main(String[] args)
    {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4); // Edge
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.breadthFirstSearch(0);

        g.removeEdge(1,4 );

        g.breadthFirstSearch(0);
    }
}