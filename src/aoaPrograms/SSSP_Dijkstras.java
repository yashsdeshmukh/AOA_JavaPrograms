package aoaPrograms;


public class SSSP_Dijkstras {


	private static void dijkstra(int[][] adjacencyMatrix,
										int startVertex)
	{
		int nVertices = adjacencyMatrix[0].length;

		// shortestDistances[i] will hold the shortest distance from src to i
		int[] shortestDistances = new int[nVertices];

		// added[i] will true if vertex i is included in shortest path tree or shortest distance from src to i is finalized
		boolean[] added = new boolean[nVertices];

		//Initialize
		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
		{
			shortestDistances[vertexIndex] = Integer.MAX_VALUE;
			added[vertexIndex] = false;
		}
		
		shortestDistances[startVertex] = 0;

		// Parent array to store shortest path tree
		int[] parents = new int[nVertices];

		// The starting vertex does not have a parent hence put it as -1
		parents[startVertex] = -1;

		// Find shortest path for all vertices
		for (int i = 1; i < nVertices; i++)
		{

			// Pick the minimum distance vertex
			// from the set of vertices not yet
			// processed. nearestVertex is
			// always equal to startNode in
			// first iteration.
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0;vertexIndex < nVertices;vertexIndex++){
				if (!added[vertexIndex] &&shortestDistances[vertexIndex] <shortestDistance){
					nearestVertex = vertexIndex;
					shortestDistance = shortestDistances[vertexIndex];
				}
			}

			// Mark the picked vertex as
			// processed
			added[nearestVertex] = true;

			// Update dist value of the
			// adjacent vertices of the
			// picked vertex.
			for (int vertexIndex = 0;vertexIndex < nVertices;vertexIndex++){
				int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])){
					parents[vertexIndex] = nearestVertex;
					shortestDistances[vertexIndex] = shortestDistance +
													edgeDistance;
				}
			}
		}

		printSolution(startVertex, shortestDistances, parents);
	}

	// Function to print the constructed distances array and shortest paths
	private static void printSolution(int startVertex,int[] distances,int[] parents)
	{
		int nVertices = distances.length;
		System.out.print("Vertex\t Distance\tPath");
		
		for (int vertexIndex = 0;
				vertexIndex < nVertices;
				vertexIndex++)
		{
			if (vertexIndex != startVertex)
			{
				System.out.print("\n" + startVertex + " -> ");
				System.out.print(vertexIndex + " \t\t ");
				System.out.print(distances[vertexIndex] + "\t\t");
				printPath(vertexIndex, parents);
			}
		}
	}

	// Function to print shortest path
	// from source to currentVertex
	// using parents array
	private static void printPath(int currentVertex,
								int[] parents)
	{
		
		// Base case : Source node has
		// been processed
		if (currentVertex == -1)
		{
			return;
		}
		printPath(parents[currentVertex], parents);
		System.out.print(currentVertex + " ");
	}

		// Driver Code
	public static void main(String[] args)
	{
		int[][] adjacencyMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
									{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
									{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
									{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
									{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
									{ 0, 0, 4, 0, 10, 0, 2, 0, 0 },
									{ 0, 0, 0, 14, 0, 2, 0, 1, 6 },
									{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
									{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		dijkstra(adjacencyMatrix, 0);
	}
}
