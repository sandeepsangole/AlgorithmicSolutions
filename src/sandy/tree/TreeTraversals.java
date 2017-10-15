package sandy.tree;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Stack;

/*

				1
			 /   \
		   2	   3
       /   \     \
     4       6    7

 */

import java.util.*;

public class TreeTraversals {


	public void sumOfPath(BTNode root) {
		int total = 0;
		System.out.println(sumOfPath(root, total));
	}

	public int sumOfPath(BTNode root, int val) {

		if (root == null) {
			return 0;
		}

		val = val * 10 + root.data;
		if (root.left == null && root.right == null) {
			return val;
		}
		return sumOfPath(root.left, val) +
				sumOfPath(root.right, val);

	}

	public boolean hasPathSum(BTNode root, int sum) {

		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null && sum == root.data) {
			return true;
		}

		return hasPathSum(root.left, sum - root.data) ||
				hasPathSum(root.right, sum - root.data);
	}

	public boolean hasPathSumIterative(BTNode root, int sum) {

		Queue<BTNode>  nodes = new LinkedList<BTNode>();
		Queue<Integer> value = new LinkedList<Integer>();

		nodes.offer(root);
		value.offer(root.data);

		while (!nodes.isEmpty()) {

			BTNode temp = nodes.poll();
			int    val  = value.poll();

			if (temp.left == null && temp.right == null && val == sum) {
				return true;
			}

			if (temp.left != null) {
				nodes.offer(temp.left);
				value.offer(val + temp.left.data);
			}

			if (temp.right != null) {
				nodes.offer(temp.right);
				value.offer(val + temp.right.data);
			}
		}

		return false;


	}

	public void printAllPaths(BTNode node) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		List<Integer>                 lst    = new ArrayList<Integer>();
		if (node == null) {
			return;
		}
		lst.add(node.data);
		printAllPathsFinal(node, result, lst);
		System.out.println(result);

	}

	public void printAllPathsFinal(BTNode node, ArrayList<ArrayList<Integer>> result, List<Integer> lst) {

		if (node.left == null && node.right == null) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(lst);
			result.add(temp);

		}

		if (node.left != null) {
			lst.add(node.left.data);
			printAllPathsFinal(node.left, result, lst);
			lst.remove(lst.size() - 1);
		}

		if (node.right != null) {
			lst.add(node.right.data);
			printAllPathsFinal(node.right, result, lst);
			lst.remove(lst.size() - 1);

		}


	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(BTNode node) {

		ArrayList<ArrayList<Integer>>    result = new ArrayList<ArrayList<Integer>>();
		Map<Integer, ArrayList<Integer>> map    = new HashMap<Integer, ArrayList<Integer>>();
		Queue<BTNode>                    nodes  = new LinkedList<BTNode>();
		Queue<Integer>                   level  = new LinkedList<Integer>();

		//Iterate
		int minLevel = 0;
		int maxLevel = 0;

		nodes.offer(node);
		level.offer(0);
		while (!nodes.isEmpty()) {

			BTNode temp = nodes.poll();
			int    l    = level.poll();

			if (map.containsKey(l)) {
				map.get(l).add(temp.data);
				//map.put(l, map.get(l).add(temp.data));
			} else {
				ArrayList<Integer> lst = new ArrayList<Integer>();
				lst.add(temp.data);
				map.put(l, lst);
			}

			minLevel = Math.min(minLevel, l);
			maxLevel = Math.max(maxLevel, l);

			if (temp.left != null) {
				nodes.offer(temp.left);
				level.offer(l - 1);
			}

			if (temp.right != null) {
				nodes.offer(temp.right);
				level.offer(l + 1);
			}

		}

		for (int i = minLevel; i <= maxLevel; i++) {
			result.add(map.get(i));
		}

		return result;

	}

	public List<Integer> postOrderTraversal(BTNode root) {
		Stack<BTNode> stack1 = new Stack<BTNode>();
		Stack<BTNode> stack2 = new Stack<BTNode>();
		List<Integer> result = new ArrayList<Integer>();

		BTNode current = root;
		stack1.push(current);
		while (!stack1.isEmpty()) {
			if (!stack1.isEmpty()) {
				BTNode temp = stack1.pop();
				if (temp.left != null) {
					stack1.push(temp.left);
				}
				if (temp.right != null) {
					stack1.push(temp.right);
				}

				stack2.push(temp);
			}
		}

		while (!stack2.isEmpty()) {
			result.add((stack2.pop()).data);
		}

		return result;
	}

	public List<Integer> inOrderTraversal(BTNode root) {

		BTNode        current = root;
		Stack<BTNode> stack   = new Stack<BTNode>();
		List<Integer> result  = new ArrayList<Integer>();

		while (current != null || !stack.isEmpty()) {

			if (current != null) {
				stack.push(current);
				current = current.left;

			} else {
				BTNode temp = stack.pop();
				result.add(temp.data);
				current = temp.right;

			}

		}
		return result;

	}

	// 1 2 4 6 3 7
	public List<Integer> preOrderTraversal(BTNode node) {

		BTNode        current = node;
		List<Integer> res     = new ArrayList<Integer>();

		Stack<BTNode> stack = new Stack<BTNode>();
		stack.push(current);

		while (!stack.isEmpty()) {

			BTNode temp = stack.pop();
			res.add(temp.data);

			if (temp != null) {
				if (temp.right != null) {
					stack.push(temp.right);
				}
				if (temp.left != null) {
					stack.push(temp.left);
				}
			}

		}

		return res;

	}

	//LevelOrder traversal Tree
	public ArrayList<ArrayList<Integer>> levelOrderTraversal(BTNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}

		ArrayList<Integer> lst   = new ArrayList<Integer>();
		Queue<BTNode>      queue = new LinkedList<BTNode>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			BTNode temp = queue.poll();

			if (temp != null) {
				lst.add(temp.data);

				if (temp.left != null) {
					queue.offer(temp.left);

				}
				if (temp.right != null) {
					queue.offer(temp.right);

				}
			} else {
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
				ArrayList<Integer> t = new ArrayList<Integer>(lst);
				result.add(t);
				lst.clear();
			}
		}
		return result;
	}

}
