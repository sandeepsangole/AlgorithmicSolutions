package bytebybyte;

import java.util.*;

public class Autocomplete {

	// Trie node class
	private class Node {
		String                   prefix;
		HashMap<Character, Node> children;

		// Does this node represent the last character in a word?
		boolean isWord;

		private Node(String prefix) {
			this.prefix = prefix;
			this.children = new HashMap<Character, Node>();
		}
	}

	// The trie
	private Node trie;

	// Construct the trie from the dictionary
	public Autocomplete(String[] dict) {
		trie = new Node("");
		for (String s : dict) insertWord(s);
	}

	// Insert a word into the trie
	private void insertWord(String s) {
		// Iterate through each character in the string. If the character is not
		// already in the trie then add it
		Node curr = trie;
		for (int i = 0; i < s.length(); i++) {
			if (!curr.children.containsKey(s.charAt(i))) {
				curr.children.put(s.charAt(i), new Node(s.substring(0, i + 1)));
			}
			curr = curr.children.get(s.charAt(i));
			if (i == s.length() - 1) curr.isWord = true;
		}
	}

	// Find all words in trie that start with prefix
	public List<String> getWordsForPrefix(String pre) {
		List<String> results = new LinkedList<String>();

		// Iterate to the end of the prefix
		Node curr = trie;
		for (char c : pre.toCharArray()) {
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return results;
			}
		}

		// At the end of the prefix, find all child words
		findAllChildWords(curr, results);
		return results;
	}

	// Recursively find every child word
	private void findAllChildWords(Node n, List<String> results) {
		if (n.isWord) {
			results.add(n.prefix);
		}

		for (Character c : n.children.keySet()) {
			findAllChildWords(n.children.get(c), results);
		}
	}

	public static void main(String args[]) {
		Autocomplete ac     = new Autocomplete(new String[] { "hire", "hiro", "hello", "ant", "bye" });
		List<String> result = new ArrayList<>();
		ac.findAllChildWords(ac.trie, result);

		for (String s : result) {
			System.out.println(s);
		}

		System.out.println("=========================================");

		List<String> result1 = ac.getWordsForPrefix("ab");
		for (String s : result1) {
			System.out.println(s);
		}
	}

}
