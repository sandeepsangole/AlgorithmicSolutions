package graphtheory;

import java.util.ArrayList;

public class Vertex {

	private ArrayList<Edge> neighbourhood;
	private String label;
	
	public Vertex(String label)
	{
		this.label = label;
		this.neighbourhood = new ArrayList<Edge>();
	}
	
	public void addNeighbour(Edge edge)
	{
		if(this.neighbourhood.contains(edge))
		{
			return;
		}
		this.neighbourhood.add(edge);
	}
	
	public boolean containsNeighbour(Edge other)
	{
		return this.neighbourhood.contains(other);
	}
	
	public Edge getNeighbour(int index)
	{
		return this.neighbourhood.get(index);
	}
	
	//remove edge based on index
	Edge removeNeighbour(int index)
	{
		return this.neighbourhood.remove(index);
	}
	
	public boolean removeNeighbour(Edge edge)
	{
		return this.neighbourhood.remove(edge);
	}
	
	public int getNeighbourCount()
	{
		return this.neighbourhood.size();
	}
	
	//label of the vertex
	public String getLabel()
	{
		return this.label;
	}
	
	public String toString(){
		return "Vertex "+ label;
	}
	
	public int hashCode()
	{
		return this.label.hashCode();
	}
	
	public boolean equals(Object other)
	{
		if(!(other instanceof Vertex)){
			return false;
		}
		Vertex v =(Vertex) other;
		return this.label.equals(v.label);
	}
	
	
	public ArrayList<Edge> getNeighbours(){
		return new ArrayList<Edge>(this.neighbourhood);
	}
}

