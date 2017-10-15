package important.specials;

import important.specials.TreeSpecial.*;
import important.specials.Node;

import java.util.*;

/*
		 50
	  /    \
	 25     75
	/  \    /  \
  10  30  60  80
					  \
						100
  */


public class SerializeDeserializeTree {

	//Level Order Traversal

	public String serialize(Node root) {

		if (root == null) return "";

		StringBuilder sb    = new StringBuilder();
		Queue<Node>   queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			Node tmp = queue.poll();

			if (tmp != null) {
				sb.append(tmp.data + ",");
				queue.offer(tmp.left);
				queue.offer(tmp.right);
			} else {
				sb.append("#,");
			}

		}
		System.out.println(sb.toString());

		return sb.toString();

	}

	public Node deserialize(String data) {

		if (data == null || data.length() == 0) {
			return null;
		}

		String[] nodes = data.split(",");
		Node     root  = new Node(Integer.parseInt(nodes[ 0 ]));

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		int i = 1;
		while (!queue.isEmpty()) {

			Node tmp = queue.poll();
			if (tmp == null)
				continue;

			if (!nodes[ i ].equals("#")) {
				tmp.left = new Node(Integer.parseInt(nodes[ i ]));
				queue.offer(tmp.left);
			} else {
				tmp.left = null;
				queue.offer(null);

			}
			i++;

			if (!nodes[ i ].equals("#")) {
				tmp.right = new Node(Integer.parseInt(nodes[ i ]));
				queue.offer(tmp.right);
			} else {
				tmp.right = null;
				queue.offer(null);

			}
			i++;
		}

		return root;
	}
}
