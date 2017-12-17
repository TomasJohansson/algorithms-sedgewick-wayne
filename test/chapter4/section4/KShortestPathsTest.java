package chapter4.section4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import chapter4.section4.KShortestPaths.Path;

/**
 * @author Tomas Johansson (but only author of this test class and NOT author of the code being tested)
 */
public class KShortestPathsTest {

	private final KShortestPaths kShortestPaths = new KShortestPaths();
	
	private EdgeWeightedDigraph graph; // constructed in setUp method
	
	@Before
	public void setUp() throws Exception {
		final int numberOfVertices = 5; // vertices named 0,1,2,3,4,
		graph = new EdgeWeightedDigraph(numberOfVertices);
		addEdgeToGraph(0, 1, 1); // edge from vertex 0 to vertex 1 with weight 1
		addEdgeToGraph(0, 2, 7); // edge from vertex 0 to vertex 2 with weight 7
		addEdgeToGraph(1, 2, 1); // and so on ... (i.e. with similar comments as above)
		addEdgeToGraph(2, 1, 1);
		addEdgeToGraph(1, 3, 3);
		addEdgeToGraph(1, 4, 2);
		addEdgeToGraph(2, 4, 4);
		addEdgeToGraph(3, 4, 1);
	}
	
	private void addEdgeToGraph(int fromVertex, int toVertex, double weight) {
		graph.addEdge(new DirectedEdge(fromVertex, toVertex, weight));
	}
	
	// the test input data and expected result in this test class is based on test data from here:
	// "/adapters-shortest-paths-test/src/test/resources/test_graphs/origin_yanqi/test_5.xml" ) 
	//	3 0 1 4
	//	5 0 1 3 4
	//	6 0 1 2 4
	//	10 0 2 1 4
	//	11 0 2 4
	//	12 0 2 1 3 4

	@Test
	public void testGetKShortestPaths() {
		// the below tested method will try to find the 10 shortest paths (sorted by total weight, with shortest first)
		// from vertex 0 to vertex 4 (though there are only 6 possible paths which can be found) 
		final List<Path> paths = kShortestPaths.getKShortestPaths(graph, 0, 4, 10);
		
		assertEquals(6,  paths.size());
		// the first path (i.e. THE shortest path) has total weight 3, and the path is the vertices 0,1,4
		// i.e. from vertex 0 to vertex 1 and then to vertex 4 ( 0-->1 , 1-->4 )
		assertPath(paths.get(0), 3, 	0, 1, 4);    // expected total weight 3, and expected path: 0-->1 , 1-->4
		assertPath(paths.get(1), 5, 	0, 1, 3, 4); // expected total weight 5, and expected path: 0-->1 , 1-->3 , 3-->4 
		assertPath(paths.get(2), 6, 	0, 1, 2, 4); // and so on ... (i.e. with similar comments as above)
		assertPath(paths.get(3), 10, 	0, 2, 1, 4);
		assertPath(paths.get(4), 11, 	0, 2, 4);
		assertPath(paths.get(5), 12, 	0, 2, 1, 3, 4);		
	}

	private void assertPath(Path actualPath, double expectedTotalWeight, int... expectedSequenceOfVertices) {
		assertEquals(expectedTotalWeight, actualPath.weight(), DELTA_VALUE_FOR_COMPARISONS_WITH_TYPE_DOUBLE);
		
		final Iterable<DirectedEdge> iterableEdges = actualPath.getPath();
		final List<DirectedEdge> edges = getAsList(iterableEdges);

		// In a path sequence (i.e. the list of edges), the start vertex of an 
		// edge is the same as the end vertex of the previous edge,
		// but except from the first edge which does not have a previous edge.
		// Therefore, the number of edges and number of vertices are almost equal, 
		// but one more vertex than there are edges:
		assertEquals(expectedSequenceOfVertices.length, edges.size() + 1);
		for (int i = 0; i < edges.size(); i++) {
			final DirectedEdge edge = edges.get(i);
			assertEquals(expectedSequenceOfVertices[i], edge.from());
			assertEquals(expectedSequenceOfVertices[i+1], edge.to());
		}
	}

	private List<DirectedEdge> getAsList(final Iterable<DirectedEdge> iterableEdges) {
		// there are better ways (with less code) to do this in Java 8
		final List<DirectedEdge> edges = new ArrayList<DirectedEdge>();
		for (DirectedEdge directedEdge : iterableEdges) {
			edges.add(directedEdge);
		}
		return edges;
	}

	private final static double DELTA_VALUE_FOR_COMPARISONS_WITH_TYPE_DOUBLE = 0.0000001;
}