package aoaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

public class GraphColoring {
	// A string array to store colors (10�colorable graph)
    private static String COLORS[] = {"", "BLUE", "GREEN", "RED", "YELLOW",
            "ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE"};
 
    // Function to check if it is safe to assign color `c` to vertex `v`
    private static boolean isSafe(Graph graph, int[] color, int v, int c)
    {
        // check the color of every adjacent vertex of `v`
        for (int u: graph.adjList.get(v)) {
            if (color[u] == c) {
                return false;
            }
        }
        return true;
    }
 
    public static void kColorable(Graph g, int[] color, int k, int v, int N)
    {
        // if all colors are assigned, print the solution
        if (v == N)
        {
        	System.out.println();
            for (v = 0; v < N; v++) {
                System.out.printf("%-8s" , COLORS[color[v]]);
            }
 
            System.out.println();
 
            return;
        }
 
        // try all possible combinations of available colors
        for (int c = 1; c <= k; c++)
        {
            // if it is safe to assign color `c` to vertex `v`
            if (isSafe(g, color, v, c))
            {
                // assign color `c` to vertex `v`
                color[v] = c;
 
                // recur for the next vertex
                kColorable(g, color, k, v + 1, N);
 
                // backtrack
                color[v] = 0;
            }
        }
    }
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 4),
                new Edge(0, 5), new Edge(4, 5),
                new Edge(1, 4), new Edge(1, 3),
                new Edge(2, 3), new Edge(2, 4)
        );
 
        // Set number of vertices in the graph
        final int N = 6;
 
        // build a graph from the given edges
        Graph g = new Graph(edges, N);
 
        int k = 3;
 
        int[] color = new int[N];
 
        System.out.println("1\t2\t3\t4\t5\t6\t");
        // print all k�colorable configurations of the graph
        kColorable(g, color, k, 0, N);
    }
}
