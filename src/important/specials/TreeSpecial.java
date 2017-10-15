package important.specials;



import java.util.*;

public class TreeSpecial {

	public static void main(String args[]) {
		TreeSpecial obj  = new TreeSpecial();
		Node        root = obj.buildBinaryTree();



		System.out.println(" == " +obj.getHeight(root));
		System.out.println(" == " +obj.heightofBT(root));

		//1. Pre Order Traversal
		List<Node> preOder = obj.preOrderTraversal(root);
		obj.printList(preOder);

		//2. In Order Traversal
		List<Node> inorder = obj.inOrderTraversal(root);
		obj.printList(inorder);

		//3. Post Order Traversal
		List<Node> postOrder = obj.postOrderTraversal(root);
		obj.printList(postOrder);

		//4. Level Order Traversal
		ArrayList<ArrayList<Integer>> levelOrder = obj.levelOrderTraversal(root);
		obj.printListLevelOrder(levelOrder);

		//5. Vertical Order Traversal
		ArrayList<ArrayList<Integer>> verticalOrder = obj.verticalOrderTraversal(root);
		obj.printListLevelOrder(verticalOrder);

		//6. Print all paths
		ArrayList<ArrayList<Integer>> printPaths = obj.printAllPath(root);
		obj.printListLevelOrder(printPaths);

		//7.Has Path sum - recursion
		boolean res = obj.hasPathSum(root, 55);
		System.out.println(res);

		//8.Has Path sum - Iterative
		boolean res1 = obj.hasPathSumIterative(root, 55);
		System.out.println(res1);

		//9.Sum of Path
		int sum = obj.sumOfPaths(root);
		System.out.println(sum);

		//10. Height of Binary Tree
		System.out.println(obj.heightofBT(root));

		//11. Count total number of nodes
		System.out.println(obj.countNodes(root));

		//12.Find max node value
		System.out.println("Max Node : " +obj.maxNodeValue(root));
		System.out.println("Max Node : "+obj.findMaxNode(root));

		//13.Find Element in BST
		System.out.println("Find Element :" + obj.findElementInBST(root, 100));

		//14.Find Element in BT
		System.out.println("Find Element :" + obj.findElementInBT(root, 100));

		//15.Find Kth Smallest element in BST
		System.out.println("Find Element :" + obj.findKthSmallestElementInBST(root, 5));

		//16.BST Iterator
		BSTIterator bt = new BSTIterator(root);
		System.out.println(bt.next());
		System.out.println(bt.next());
		System.out.println(bt.next());

		//27. Print all Ancestors of Binary tree
		System.out.println("Print Ancestors --- >");
		obj.printAllAncestors(root,100);


		 //17.Serialise Deseriaze tree
			System.out.println("Serialization Start *********** ");
			SerializeDeserializeTree se = new SerializeDeserializeTree();
			String data = se.serialize(root);
			Node node = se.deserialize(data);
			obj.printList(obj.inOrderTraversal(node));
		System.out.println("Serialization end ************ ");

		//18.LCA BST

		//19.LCA BT

		//20.Sorted Array to BST
		Node n = obj.sortedListtoBST(new int[]{10,20,30,40,50,60,70,80,90,100});
		List<Node> lst = obj.preOrderTraversal(n);
		obj.printList(lst);

		//21.Sorted List to BST


		//22. Flatten Tree
		obj.flattenBinaryTree(root);
		List<Node> l = obj.preOrderTraversal(root);
		obj.printList(l);

		//23
		/* Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
		(e.g., if you have a treewith depth D, you'll have D linked lists). */

	//24. Construct tree from preoder and inorder


	//25. Construct tree from postorder and inorder

		// 26.Covert BT to it mirror

	//27. Invert Binary Tree
		System.out.println("-------------------");
		List<Node> tmplst = obj.preOrderTraversal(root);
		obj.printList(tmplst);

		Node inverted = obj.invertBT(root);
		List<Node> tmplst1 = obj.preOrderTraversal(inverted);
		obj.printList(tmplst1);
		System.out.println("-------------------");

	}




	public int getHeight(Node node){

		if(node == null)
			return 0;

		return 1 + Math.max(getHeight(node.left), getHeight(node.right));

	}

	public Node invertBT(Node root){

		if(root == null){
			return null;
		}

		Node tmpLeft = root.left;
		root.left = root.right;
		root.right = tmpLeft;

		invertBT(root.left);
		invertBT(root.right);

		return root;

	}



	//50 25 10 30 75 60 80 100
	/*
		1. Push Root to stack
		2. Pop while iterating an add to result
		3. Iterate stack - add right and then left
	 */
	public List<Node> preOrderTraversal(Node root) {

		if (root == null) {
			return null;
		}

		List<Node>  result = new ArrayList<Node>();
		Stack<Node> stack  = new Stack<Node>();
		stack.push(root);

		while (!stack.isEmpty()) {

			Node current = stack.pop();
			result.add(current);

			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
		return result;

	}

	//10 25 30 50 60 75 80 100
	/*
			1.Set current to root
			2.Iterate stack ..push all left to stack until null
			3.pop and move to right
	 */
	public List<Node> inOrderTraversal(Node root) {
		if (root == null) {
			return null;
		}

		Stack<Node> stack   = new Stack<Node>();
		List<Node>  res     = new ArrayList<Node>();
		Node        current = root;

		while (current != null || !stack.isEmpty()) {

			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				Node temp = stack.pop();
				res.add(temp);
				current = temp.right;
			}
		}
		return res;
	}
	/*
		1. Create 2 Stacks and push root into stack1
		2. pop from stack 1 and push its left and childern into stack 1 if not null
		3.push element pooped from stack 1 to stack 2
		4.pop stack 2 and add to result.
   */

	public List<Node> postOrderTraversal(Node root) {

		if (root == null) {
			return null;
		}

		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		List<Node>  res    = new ArrayList<Node>();
		stack1.push(root);

		while (!stack1.isEmpty()) {

			Node temp = stack1.pop();
			if (temp.left != null) {
				stack1.push(temp.left);
			}
			if (temp.right != null) {
				stack1.push(temp.right);
			}

			stack2.push(temp);
		}

		while (!stack2.isEmpty()) {
			res.add(stack2.pop());
		}

		return res;
	}
/*
	1. Create Queue and offer root and null . Null is for identifying level
	2. Iterate through Queue , poll , if its not null , add current elements left and right child back to queue
	3.If current element is null, check if queue is not empty then push null and add while lst to final result.
 */

	public ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root) {

		if (root == null) {
			return null;
		}

		Queue<Node>                   queue  = new LinkedList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer>            lst    = new ArrayList<Integer>();
		queue.offer(root);
		queue.offer(null); // to identify level

		while (!queue.isEmpty()) {

			Node temp = queue.poll();

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

	/*
			1.Create 2 Queues, one to hold nodes and another for levels
			2.maintain min and max value as it will be negative...positive for iteration

	 */
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<Node>                      nodes    = new LinkedList<>();
		Queue<Integer>                   levels   = new LinkedList<>();
		ArrayList<Integer>               lst      = new ArrayList<>();
		int                              minLevel = 0;
		int                              maxLevel = 0;
		Map<Integer, ArrayList<Integer>> map      = new HashMap<>();
		nodes.offer(root);
		levels.offer(0);

		while (!nodes.isEmpty()) {
			Node tmp   = nodes.poll();
			int  level = levels.poll();

			if (map.containsKey(level)) {
				map.get(level).add(tmp.data);
			} else {
				ArrayList<Integer> tlst = new ArrayList<>();
				tlst.add(tmp.data);
				map.put(level, tlst);
			}

			minLevel = Math.min(minLevel, level);
			maxLevel = Math.max(maxLevel, level);

			if (tmp != null) {

				if (tmp.left != null) {
					nodes.offer(tmp.left);
					levels.offer(level - 1);
				}

				if (tmp.right != null) {
					nodes.offer(tmp.right);
					levels.offer(level + 1);
				}
			}

		}

		for (int i = minLevel; i <= maxLevel; i++) {
			result.add(map.get(i));
		}

		return result;
	}


/*
		1. Recusively iterate tree , when node with no leaf's encounterd , add it to the list.
		2. After leaf node is processing , remove last element from list
 */

	public ArrayList<ArrayList<Integer>> printAllPath(Node node) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (node == null) {
			return result;
		}

		ArrayList<Integer> res = new ArrayList<>();
		res.add(node.data);
		printAllPathUtil(node, res, result);
		return result;
	}

	public void printAllPathUtil(Node node, List<Integer> res, ArrayList<ArrayList<Integer>> result) {

		if (node.left == null && node.right == null) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(res);
			result.add(temp);
		}

		if (node.left != null) {
			res.add(node.left.data);
			printAllPathUtil(node.left, res, result);
			res.remove(res.size() - 1);
		}

		if (node.right != null) {
			res.add(node.right.data);
			printAllPathUtil(node.right, res, result);
			res.remove(res.size() - 1);
		}
	}

	/*
			Has path Sum - Recursion
	*/

	public boolean hasPathSum(Node node, int target) {

		if (node == null) {
			return false;
		}

		if (node.left == null && node.right == null && node.data == target) {
			return true;
		}

		return hasPathSum(node.left, target - node.data) ||
				hasPathSum(node.right, target - node.data);
	}

	/*
			Has Path sum Iterative
   */

	public boolean hasPathSumIterative(Node node, int target) {

		if (node == null)
			return false;

		Queue<Node>    nodes = new LinkedList<Node>();
		Queue<Integer> sums  = new LinkedList<Integer>();

		nodes.offer(node);
		sums.offer(node.data);

		while (!nodes.isEmpty()) {
			Node temp = nodes.poll();
			int  sum  = sums.poll();
			if (temp.left == null && temp.right == null && sum == target) {
				return true;
			}

			if (temp.left != null) {
				sums.offer(sum + temp.left.data);
				nodes.offer(temp.left);
			}

			if (temp.right != null) {
				sums.offer(sum + temp.right.data);
				nodes.offer(temp.right);
			}
		}

		return false;
	}

	public int sumOfPaths(Node node) {

		if (node == null) {
			return 0;
		}

		return sumPathsUtil(node, 0);

	}

	public int sumPathsUtil(Node node, int sum) {

		if (node == null) {
			return 0;
		}

		sum = sum * 10 + node.data;
		if (node.left == null && node.right == null) {
			return sum;
		}

		return sumPathsUtil(node.left, sum) + sumPathsUtil(node.right, sum);
	}

	/*
			Find Leaves in Binary tree.


	 */

	/*
			Height of Binary Tree
	 */

	public int heightofBT(Node root) {

		int maxHeight = Integer.MIN_VALUE;

		if (root == null) {
			return 0;
		}

		int leftHeight  = heightofBT(root.left);
		int rightHeight = heightofBT(root.right);

		if (leftHeight < rightHeight) {
			maxHeight = rightHeight;
		} else {
			maxHeight = leftHeight;
		}
		return maxHeight + 1;
	}

	//Count total number of nodes
	public int countNodes(Node node) {

		if (node == null) {
			return 0;
		}

		return countNodes(node.left) + countNodes(node.right) + 1;
	}

	//Find max node

	public int findMaxNode(Node root){

		if(root == null){
			return 0;
		}
		int max = Math.max(findMaxNode(root.left),findMaxNode(root.right));

		if(max > root.data) {
			return max;
		}
			else {

				return root.data;

			}
	}


	public int maxNodeValue(Node root) {

		int maxValue = Integer.MIN_VALUE;
		if (root == null) {
			return 0;
		}

		int leftMax  = maxNodeValue(root.left);
		int rightMax = maxNodeValue(root.right);

		if (leftMax > rightMax) {
			maxValue = leftMax;
		} else {
			maxValue = rightMax;
		}

		if (maxValue > root.data) {
			return maxValue;
		} else {
			return root.data;
		}
	}

	//Find element in BST
	public boolean findElementInBST(Node root, int target) {

		if (root != null) {

			if (root.data == target) {
				return true;
			}

			if (target < root.data) {
				return findElementInBST(root.left, target);
			} else {
				return findElementInBST(root.right, target);
			}
		}

		return false;
	}

	//Find element in BT
	public boolean findElementInBT(Node root, int target) {

		if (root != null) {

			if (root.data == target) {
				return true;
			} else {
				return findElementInBT(root.left, target) || findElementInBT(root.right, target);
			}

		}

		return false;
	}
	/*
			Find kth smallest element in BST.
			This is inorder traversal
	 */

	public int findKthSmallestElementInBST(Node node, int k) {

		Stack<Node> stack   = new Stack<>();
		int         result  = 0;
		Node        current = node;
		while (current != null || !stack.isEmpty()) {

			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {

				Node tmp = stack.pop();
				k--;

				if (k == 0) {
					result = tmp.data;
				}

				if (tmp.right != null)
					current = tmp.right;
			}
		}

		return result;
	}


	//21. Flatten Binary Tree

		public void flattenBinaryTree(Node node){

			if(node == null)
				return ;

			Stack<Node> stack = new Stack<>();
			Node current = node;
			while(current != null || !stack.isEmpty()){

				if(current.right != null){
					stack.push(current.right);
				}

				if(current.left != null){
					current.right = current.left;
					current.left = null;
				}
				else {
					if(!stack.isEmpty()) {
						Node tmp = stack.pop();
						current.right = tmp;
					}
				}

				current = current.right;

			}


		}

		public Node sortedListtoBST(int[] arr){

			if(arr == null || arr.length == 0){
				return null;
			}

			return sortedListtoBST(arr,0,arr.length - 1);

		}

		public Node sortedListtoBST(int[] arr,int start,int end){

			if(start > end){
				return null;
			}

			int mid = (start + end) / 2;

			Node root = new Node(arr[mid]);
			root.left = sortedListtoBST(arr,start,mid -1 );
			root.right = sortedListtoBST(arr,mid+1,end);

			return root;
		}



	/* Construct tree from inorder and preorder traversal
		in-order:   4 2 5 (1) 6 7 3 8
		pre-order: (1) 2 4 5  3 7 6 8
	 */

	static int index = 0;

	public Node buildTreeInOrderPreOrder(int[] inOrder,int[] preOrder){

		return buildTreeInOrderPreOrder(inOrder,preOrder,0,inOrder.length - 1);
		//in order start /end which will build the tree

	}

	Node buildTreeInOrderPreOrder(int[] inOrder,int[] preOrder,int start,int end){

			if(start > end){
				return null;
			}

			int i;

			for(i =0;i<inOrder.length -1;i++){
				if(inOrder[i] == preOrder[index]){
					break;
				}
			}

			Node root = new Node(preOrder[index]);
			index++;


			root.left = buildTreeInOrderPreOrder(inOrder,preOrder,start, i - 1);
			root.right = buildTreeInOrderPreOrder(inOrder,preOrder,i+1, end);

			return root;

	}

	/*
			Construct tree from Inorder and post order
			in-order:   4 2 5  (1)  6 7 3 8
			post-order: 4 5 2  6 7 8 3  (1)

			1. last element in post order is root
			2. Find it in inorder and its root


	 */

	public Node buildTreeInOrderPostOrder(int[] inOrder,int[] postOrder){

			return buildTreeInOrderPostOrder(inOrder,postOrder,0,inOrder.length - 1 ,postOrder.length - 1);

	}

	private Node buildTreeInOrderPostOrder(int[] inOrder,int[] postOrder,int start , int end , int index){

		if(start > end ){
			return null;
		}

		int i;
		for(i = 0;i <inOrder.length - 1;i++){
			if(inOrder[i] == postOrder[index]){
				break;
			}
		}

		Node root = new Node(postOrder[index]);

		root.left  = buildTreeInOrderPostOrder(inOrder,postOrder,start,i - 1,index-(end - i + 1));
		root.right = buildTreeInOrderPostOrder(inOrder,postOrder,i +1 ,end,index - 1);

		return root;
	}

	//26.Covert BT to it mirror

	public Node convertToMirror(Node node){

		Node tmp;
		if(node != null){

			convertToMirror(node.left);
			convertToMirror(node.right);

			tmp = node.left;
			node.left = node.right;
			node.right = tmp;

		}

		return node;
	}

	//27. Are two trees mirror of each Other

	public boolean areMirrors(Node node1, Node node2){

		if(node1 == null && node2 == null)
			return true;

		if(node1 == null || node2 == null) {
			return false;
		}

		if(node1.data == node2.data)
			return true;

		else return areMirrors(node1.left,node2.right) ||
					areMirrors(node1.right,node2.left);

	}

	//28. Print all ancestors of node in BT
	/*
		for eg ; 80 - > 75,50
	 */

	public boolean  printAllAncestors(Node root, int target){

		if(root == null) return false;

		if(root.data == target){
			return true;
		}
		if(printAllAncestors(root.left,target) || printAllAncestors(root.right, target)){
			System.out.print(root.data +" ");
			return true;
		}

		return false;

	}

	//29.LCA Binary Tree

	public Node findLCAinBT(Node root , Node n1 , Node n2){

		Node left,right;

		if(root == null ) return root;

		if(root == n1 || root == n2) return root;

		left = findLCAinBT(root.left,n1,n2);
		right = findLCAinBT(root.right,n1,n2);

		if(left != null && right != null){
			return root;
		}
		else
			return left != null ? left : right;

	}

	public Node findLCAinBST(Node root, Node n1 , Node n2){

			if(root == null) return  root;

			if(root == n1 || root == n2) return root;

		  if(n1.data <root.data && n2.data < root.data){
			  return findLCAinBST(root.left , n1 ,n2);
		  }
		  else if(n1.data > root.data && n2.data > root.data){
			  return findLCAinBST(root.right,n1,n2);
		  }
		  else
		  	return root;

	}


	/*
			 50
		  /    \
		 25     75
		/  \    /  \
	  10  30  60  80
	                 \
	                  100
	  */
	public Node buildBinaryTree() {

		Node root  = new Node(50);
		Node node2 = new Node(25);
		Node node3 = new Node(75);
		Node node4 = new Node(10);

		Node node6  = new Node(30);
		Node node7  = new Node(60);
		Node node8  = new Node(80);
		Node node9  = new Node(100);
		Node node10 = new Node(101);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node6;

		node3.left = node7;
		node3.right = node8;

		node8.right = node9;

			node9.right = node10;

		return root;
	}



	void printList(List<Node> res) {
		for (Node n : res) {
			System.out.print(n.data + " ");
		}
		System.out.println();
	}

	void printListLevelOrder(ArrayList<ArrayList<Integer>> res) {
		for (List<Integer> n : res) {

			for (Integer t : n)
				System.out.print(t + " ");

			System.out.print(",");

		}
		System.out.println();
	}

}


class Node {
	int  data;
	Node left;
	Node right;

	Node(int d) {
		this.data = d;
	}
}