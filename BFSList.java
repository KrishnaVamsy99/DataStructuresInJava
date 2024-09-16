import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;


class Graph
{
   List<List<Integer>> adjacencyList;
    int nodes;
   public Graph(int nodes)
   {
     this.nodes = nodes;
       adjacencyList = new ArrayList<>(nodes);
       for(int i = 0; i < nodes; i++)
       {
         adjacencyList.add(new ArrayList<>());
       }
   }

   public void addEdge(int u, int v)
   {
     adjacencyList.get(u).add(v);
     adjacencyList.get(v).add(u); // remove if it directed graph
   }

   public void removeEdge(int u, int v)
   {
        List<Integer> adjacentVertices = adjacencyList.get(u);
        if(adjacentVertices !=null)
        {
            adjacentVertices.remove(Integer.valueOf(v));
        }

        adjacentVertices = adjacencyList.get(v);
        if(adjacentVertices!=null)
        {
            adjacentVertices.remove(Integer.valueOf(u));
        }
   }

   public void BFS(int source)
   {
        Queue<Integer> queue = new LinkedList<>();
        boolean []visited = new boolean[nodes];
        visited[source] = true;
        queue.add(source);
        int current;
        while(!queue.isEmpty())
        {
            current = queue.poll();
            System.out.print(current + "");
            for(int neighbor: adjacencyList.get(current))
            {
                if(!visited[neighbor])
                {
                    visited[neighbor] = true;
                    queue.add(neighbor);                }
            }

        }
    }

}
public class BFSList {

    public static void main(String[] args) {
    Graph graph = new Graph(5); 

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        System.out.println("BFS starting from vertex 0:");
        graph.BFS(2);
    }
}
