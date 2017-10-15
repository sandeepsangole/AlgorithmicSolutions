package important.specials;

import java.util.*;

/*


                     root  - map
                    /   \    \
                   t   a      b
                   |   |       |
                   h   n       y
                   |   |  \    |
                   e   s  y    e
                 /  |   |
                 i  r   w
                 |  |   |
                 r  e   e
                        |
                        r

   1. Iterate String - fetch Character by character
   2. Iterate TriNode until u find characters matching to String - then insert char and update isleaf = false;


 */
public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode('$');
	}

	public boolean search(String str) {

		if (str == null || str.length() == 0) {
			return false;
		}

		TrieNode                 tmp;
		Map<Character, TrieNode> children = root.children;

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);
			if (children.containsKey(c)) {
				tmp = children.get(c);
			} else {
				return false;
			}

			children = tmp.children;

			if (i == str.length() - 1) {
				return true;
			}
		}

		return true;

	}

	public TrieNode insert(String str) {

		if (str == null || str.length() == 0)
			return null;

		TrieNode                 tmp;
		int                      i   = 0;
		Map<Character, TrieNode> map = root.children;
		while (i < str.length()) {

			char c = str.charAt(i);

			if (map.containsKey(c)) {
				tmp = map.get(c);

			} else {
				tmp = new TrieNode(c);
				map.put(c, tmp);
			}

			map = tmp.children;

			if (i == str.length() - 1) {
				tmp.isLeaf = true;
			}
			i++;
		}

		return root;

	}

	class TrieNode {
		char                     c;
		Map<Character, TrieNode> children;
		boolean                  isLeaf;

		TrieNode(char c) {
			this.c = c;
			children = new HashMap<>();
			isLeaf = false;
		}
	}

	/*
	  root  - map
                    /   \    \
                   t   a      b
                   |   |       |
                   h   n       y
                   |   |  \    |
                   e   s  y    e
                 /  |   |
                 i  r   w
                 |  |   |
                 r  e   e
                        |
                        r
	 */

	// Find all words in trie that start with prefix
	public List<String> getWordsForPrefix(String pre) {
		List<String> results = new LinkedList<String>();

		// Iterate to the end of the prefix
		TrieNode curr = root;
		for (char c : pre.toCharArray()) {
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return results;
			}
		}

		// At the end of the prefix, find all child words
		findAllChildWords(curr, results,pre);
		return results;
	}

	// Recursively find every child word
	private void findAllChildWords(TrieNode n, List<String> results,String pre) {
		if (n.isLeaf) results.add(pre);
		for (Character c : n.children.keySet()) {
			findAllChildWords(n.children.get(c), results,pre+n.c);
		}



	}


	public static void main(String args[]) {
		Trie     t    = new Trie();
		TrieNode dic  = t.insert("ant");
		TrieNode dic1 = t.insert("and");
		TrieNode dic2 = t.insert("bye");

		List<String> result = new ArrayList<>();
		result = t.getWordsForPrefix("a");
		for(String s : result){
			System.out.println(s);
		}


	}

}
