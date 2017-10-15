package graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph {
	private HashMap<String, Vertex> vertices;
	private HashMap<Integer, Edge> edges;

	public Graph() {
		this.vertices = new HashMap<String, Vertex>();
		this.edges = new HashMap<Integer, Edge>();
	}

	/*
	This constructor accepts an ArrayList<Vertex> and populates
	this.vertices. If multiple Vertex objects have the same label,
	then the last Vertex with the given label is used.
	@param vertices The initial Vertices to populate this Graph

*/
	     
	public Graph(ArrayList<Vertex> vrtices) {
		this.vertices = new HashMap<String, Vertex>();
		this.edges = new HashMap<Integer, Edge>();
		
		for(Vertex v:vrtices)
		{
			this.vertices.put(v.getLabel(),v);
		}
	}

	public boolean addEdge(Vertex one, Vertex two) {
  		return addEdge(one, two, 1);
	}
	
	/**

	     * Accepts two vertices and a weight, and adds the edge
	
	     * ({one, two}, weight) iff no Edge relating one and two

	     * exists in the Graph.
	
	     * @param one The first Vertex of the Edge

	     * @param two The second Vertex of the Edge

	     * @param weight The weight of the Edge
	
	     * @return true iff no Edge already exists in the Graph
	
	     */

	public boolean addEdge(Vertex one, Vertex two, int weight) {
		if (one.equals(two)) {
			return false;
		}
		// ensure edge is not in the graph
		Edge e = new Edge(one, two, weight);
		if (edges.containsKey(e.hashCode())) {
			return false;
		}
		// and that the Edge is not already incident to tone of the vertices
		else if (one.containsNeighbour(e) || two.containsNeighbour(e)) {
			return false;
		}

		edges.put(e.hashCode(), e);
		one.addNeighbour(e);
		two.addNeighbour(e);
		return true;
	}

	public boolean containsEdge(Edge e) {
		if (e.getOne() == null || e.getTwo() == null) {
			return false;
		}
		return this.edges.containsKey(e.hashCode());
	}

	public Edge removeEdge(Edge e) {
		e.getOne().removeNeighbour(e);
		e.getTwo().removeNeighbour(e);
		return this.edges.remove(e.hashCode());
	}

	public boolean containsVertex(Vertex vertex) {
		return this.vertices.get(vertex.getLabel()) != null;
	}

	public Vertex getVertex(String label) {
		return vertices.get(label);
	}

	/**
	 * 
	 * This method adds a Vertex to the graph. If a Vertex with the same label
	 * 
	 * as the parameter exists in the Graph, the existing Vertex is overwritten
	 * 
	 * only if overwriteExisting is true. If the existing Vertex is overwritten,
	 * 
	 * the Edges incident to it are all removed from the Graph.
	 *
	 * 
	 * 
	 * @param vertex
	 * 
	 * @param overwriteExisting
	 * 
	 * @return true iff vertex was added to the Graph
	 * 
	 */
	public boolean addVertex(Vertex vertex, boolean overwriteExisting) {
		Vertex current = this.vertices.get(vertex.getLabel());
		if (current != null) {
			if (!overwriteExisting) {
				return false;
			}
			while (current.getNeighbourCount() > 0) {
				this.removeEdge(current.getNeighbour(0));
			}
		}

		vertices.put(vertex.getLabel(), vertex);
		return true;
	}

	public Vertex removeVertex(String label) {
		Vertex v = vertices.remove(label);

		while (v.getNeighbourCount() > 0) {
			this.removeEdge(v.getNeighbour(0));
		}
		return v;
	}

	public Set<String> vertexKeys() {
		return this.vertices.keySet();
	}

	public Set<Edge> getEdges() {
		return new HashSet<Edge>(this.edges.values());
	}

}
