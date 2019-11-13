import java.lang.Math; // headers MUST be above the first class
import java.io.*; 
import java.util.*; 


public class Graph 
{ 
	private int V;                          // No. of vertices 
	private LinkedList<Integer>[] adj;      // ** Implementing Graph as Adjacency Lists  ***************************************

	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList<Integer>(); 
	} 

	void addEdge(int v,int w) 
	{ 
		adj[v].add(w); 
	} 

	// prints BFS traversal from a given source s 
	void BFS(int s) 
	{ 
		// Mark all the vertices as not visited(By default  set as false) 
		boolean visited[] = new boolean[V]; 

		// Create a queue for BFS 
		LinkedList<Integer> queue = new LinkedList<Integer>(); 

		// Mark the current node as visited and enqueue it 
		visited[s]=true; 
		queue.add(s); 

		while (queue.size() != 0) 
		{ 
			// Dequeue a vertex from queue and print it 
			s = queue.poll(); 
			System.out.print(s+" "); 

			// Get all adjacent vertices of the dequeued vertex s. 
			Iterator<Integer> i = adj[s].listIterator(); 
			while (i.hasNext()) 
			{ 
				int n = i.next(); 
				if (!visited[n]) 		
				{ 				// If not visited then mark it visited and add it to queue
					visited[n] = true; 
					queue.add(n); 
				} 
			} 
		} 
	} 

	// Driver method to 
	public static void main(String args[]) 
	{ 
	    Integer numOfVertices = 4;
		Graph g = new Graph(numOfVertices+1);   // ********** DIRECTED *************** Graph

		g.addEdge(0, 3); 			// vertex 0 points to vertex 3      0 ----> 3
		g.addEdge(0, 4); 
		g.addEdge(0, 1); 
		g.addEdge(2, 4); 
		g.addEdge(3, 4); 
		g.addEdge(4, 2); 
		
		System.out.println("Following is Breadth First Traversal of DIRECTED Graph "+ "(starting from vertex 2)"); 

		g.BFS(0); 
	} 
} 

