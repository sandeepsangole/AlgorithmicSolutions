package personal.temp;

import java.util.*;

class TriNode {
	char ch;
	Map<Character, TriNode> map = new HashMap<Character, TriNode>();
	boolean isLeaf;
	int count;
	TriNode(){}
	TriNode(char ch){
		this.ch = ch;
	}

}

public class Trie {

	TriNode root;

	Trie(){
		root = new TriNode();
	}

	public TriNode insertInTrie(String str) {
		if (str == null || str.length() == 0) {
			return root;
		}


		Map<Character, TriNode> children = root.map;
		for (int i = 0; i < str.length(); i++) {
			TriNode                 temp;
			char c = str.charAt(i);

			if (children.containsKey(c)) {
				temp = children.get(c);
			} else {
				temp = new TriNode(c);
				children.put(c, temp);
			}
			temp.count+=1;
			children = temp.map;

			if(i == str.length() -1){
				temp.isLeaf = true;
			}
		}

		return root;
	}

/*	public List<String> printUniquePrefixes(){
		Map<Character,TriNode> children = root.map;



	}*/

	public boolean findString(String str){
		if (str == null || str.length() == 0) {
			return false;
		}

		Map<Character,TriNode> children = root.map;
		for(int i =0;i<str.length();i++){
			TriNode                 temp;
			char c = str.charAt(i);
			if(children.containsKey(c)){
				temp = children.get(c);
				children = temp.map;
			}
			else
			{
					return false;
			}
		}
		return true;
	}

	public static void main(String args[]){
		Trie t = new Trie();
		TriNode root = t.insertInTrie("to");
		TriNode root1 = t.insertInTrie("top");
		System.out.println(root1);

	}

}