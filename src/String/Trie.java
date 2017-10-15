package String;

import java.util.*;

class TriNode{
	boolean isLeaf ;
	Map<Character,TriNode> children;
	TriNode(){
		children = new HashMap<Character,TriNode>();
		isLeaf = false;

	}

}

public class Trie {

	TriNode root;

	Trie(){
		root = new TriNode();
	}

	public void insert(String word){

		TriNode current = root;

		for(int i =0;i<word.length();i++){
			char c = word.charAt(i);

			TriNode node = current.children.get(c);
			if(node == null) {
				node = new TriNode();
				node.children.put(c,new TriNode());
			}

			current = node;

		}

		current.isLeaf = true;

	}

	public boolean searchWord(String word){

		TriNode current = root;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			TriNode node = current.children.get(c);
			if(node == null){
				return false;
			}
			current = node;

		}
		return current.isLeaf;

	}

	public void deleteWord(String word){
		delete(root,word,0);
	}

	private boolean delete(TriNode current ,String word,int index){
		//when end of word is reached only delete if current.enofword is true
		if(index == word.length()){
			if(!current.isLeaf){
				return false;
			}
			current.isLeaf = false;
			//if current has no other mapping then return true
			return current.children.size() == 0;
		}

		char ch = word.charAt(index);
		TriNode node = current.children.get(ch);
		if(node == null){
			return false;
		}

		boolean shouldDeleteCurrentNode = delete(node,word,index+1);

		//if true is returned then delete mapping of character and
		// trinode reference map

		if(shouldDeleteCurrentNode){
			current.children.remove(ch);
			return current.children.size() == 0;

		}

		return false;

	}


}
