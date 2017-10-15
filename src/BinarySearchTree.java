import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BinarySearchTree {

	Node root;

	public void addNode(int key, String name) {
		Node node = new Node(key, name);
		if (root == null) {
			root = node;
		} else {
			Node focusNode = root;
			Node parent;

			while (true) {
				parent = focusNode;
				if (key < focusNode.getKey()) {
					focusNode = focusNode.getLeftChild();
					if (focusNode == null) {
						parent.leftChild = node;
						return;
					}
				} else {
					focusNode = focusNode.getRightChild();
					if (focusNode == null) {
						parent.rightChild = node;
						return;
					}
				}
			}
		}
	}
	
	static Node Insert(Node root, int value) {
		
		Node newNode = new Node(value,"Root");
		if(root == null)
		{
			return newNode;
		}
		
		
		Node currentNode = root;
		
		while(true)
		{
			Node parentNode = currentNode;
			if(value <= currentNode.key)
			{
				currentNode = currentNode.leftChild;
				if(currentNode == null)
				{
					parentNode.setLeftChild(newNode);
					return root;
					
				}
				
			}
			else if(value > currentNode.key)
			{
				currentNode = currentNode.rightChild;
				if(currentNode == null)
				{
					parentNode.setRightChild(newNode);
					return root;
					
				}	
				
					
			}
		}
	}

	

	public boolean remove(int key) {
		Node parent = root;
		Node focusNode = root;
		boolean isLeftNode = false;
		String s="323";
		while (focusNode.getKey() != key) {
			parent = focusNode;
			if (focusNode.getKey() < key) {
				focusNode = focusNode.getLeftChild();
				isLeftNode = true;
			} else {
				focusNode = focusNode.getRightChild();
				isLeftNode = false;
			}
			
			if(focusNode == null)
			return false;
		}
		
		//if both left and right child of deleting node is null
		if(focusNode.getLeftChild() == null && focusNode.getRightChild() == null)
		{
			if(focusNode == root)
			{
				root = null;
				
			}
			
			if (isLeftNode)
				parent.setLeftChild(null);
			else
				parent.setRightChild(null);
		}
		//One child is not null
		else if(focusNode.getLeftChild() != null && focusNode.getRightChild() == null)
		{
			parent.setLeftChild(focusNode.getLeftChild());
			
		}
		else if(focusNode.getLeftChild() == null && focusNode.getRightChild() != null)
		{
			parent.setLeftChild(focusNode.getRightChild());
			
		}
		//both nodes are not null
		else if(focusNode.getLeftChild() != null && focusNode.getRightChild() != null)
		{
			
			Node replacement = null;//(focusNode);
			if(focusNode == root)
			{
				root = replacement;
			}
			else if(isLeftNode)
			{
				parent.setLeftChild(replacement);
			}
			else
			{
				parent.setRightChild(replacement);
				
			}
			replacement.setLeftChild(focusNode.getLeftChild());
				
		}
		
		return isLeftNode;
		

	}

	/*public Node getReplacementNode(Node node)
	{
		Node replacementNode = node;
		Node replacementParent = node;
		
		Node focusNode = node.getRightChild();
		while(focusNode != null)
		{
			replacementParent = replacementNode;
			replacementNode = focusNode;
			
			focusNode = focusNode.getLeftChild();
			
		}
		if(replacementNode != node.getRightChild())
		{
			//replacementParent.leftChild = 
		}
	}*/
	
	
	public void getDepthofTree(Node parentNode)
	{
		if(parentNode != null)
 		getDepthofTree(parentNode.getLeftChild());
		
	}
	
	public void inOrderTraverseTree(Node parentNode) {
		if(parentNode == null)
			System.out.println("Before If : "+"NULL");
		else
		System.out.println("Before If : "+parentNode.getKey());
		
		if (parentNode != null) {
			inOrderTraverseTree(parentNode.getLeftChild());
		//	System.out.println("Finial Output ----> "parentNode.getKey());
			inOrderTraverseTree(parentNode.getRightChild());
		}
		if(parentNode == null)
			System.out.println("After If : "+"NULL");
		else
		System.out.println("After If : "+parentNode.getKey());
	}

	public void preOrderTraverseTree(Node parentNode) {
		
		//System.out.println(""+parentNode.getKey());
		if (parentNode != null) {
			System.out.println(parentNode.getKey());
			preOrderTraverseTree(parentNode.getLeftChild());
			preOrderTraverseTree(parentNode.getRightChild());

		}

	}

	public void postOrderTraverseTree(Node parentNode) {
		if (parentNode != null) {
			postOrderTraverseTree(parentNode.getLeftChild());
			postOrderTraverseTree(parentNode.getRightChild());
			System.out.println(parentNode);

		}

	}
	
	

	public Node findNode(int key) {
		Node focusNode = root;

		while (key != focusNode.getKey()) {
			if (key < focusNode.getKey()) {
				focusNode = focusNode.getLeftChild();
			} else

			{
				focusNode = focusNode.getRightChild();
			}

			if (focusNode == null)
				return null;
		}

		return focusNode;
	}

	
	public ArrayList<Integer> postOrderTraversal(Node root) {
		
		return null;
		
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.addNode(50, "Boss-Root");
		tree.addNode(25, "VP");
		tree.addNode(70, "Office Manager");
		tree.addNode(80, "Office Manager");
		/*tree.addNode(30, "Secretary");
		tree.addNode(18, "Secretary");
		tree.addNode(32, "Secretary");
		tree.addNode(75, "Sales Manager");
		tree.addNode(85, "Sales Man");*/
		tree.inOrderTraverseTree(tree.root);
		
		//tree.inOrderTraverseTree(tree.root);
		//levelOrderTraverseTree(tree.root);
		
		//System.out.println("Max depth " + maxDepthLevelOrderQueue(tree.root));
		//System.out.println("Max depth " + maxDepthIterativeUsingStack(tree.root));
	//	System.out.println("Max depth " + maxDepthRecursive(tree.root));
		/*System.out.println("Search For 30 ");

		System.out.println(tree.findNode(30));

		System.out.println("In Order --- ");
		tree.inOrderTraverseTree(tree.root);
		System.out.println("Pre Order --- ");
		tree.preOrderTraverseTree(tree.root);
		System.out.println("POST Order --- ");
		tree.postOrderTraverseTree(tree.root);*/

	}

	public static int  maxDepthLevelOrderQueue(Node root){
    	if(root == null)
            return 0;
        int maxDepth = 1;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        System.out.println(q.toString());
        q.offer(null);
        System.out.println(q.toString());
        while(!q.isEmpty()){
        	Node tmp = q.poll();
        	 System.out.println(q.toString());
            if(tmp != null){
                if(tmp.getLeftChild() != null)
                    q.offer(tmp.getLeftChild());
                if(tmp.rightChild != null)
                    q.offer(tmp.rightChild);
                
                System.out.println(q.toString());
            }else{
                if(!q.isEmpty()){
                    ++maxDepth;
                    q.offer(null);
                    System.out.println(q.toString());
                    System.out.println("maxDepth "+maxDepth);
                }
            }
        }
        return maxDepth;
    }
	
	public static void levelOrderTraverseTree(Node parentNode)
	{
		ArrayList arrayLst = new ArrayList();
		Queue<Node> que = new LinkedList<Node>();
		que.offer(parentNode);	
		que.offer(null);
		
		while(!que.isEmpty()) {
			
			Node tmp = que.poll();	
			
			if(tmp != null)
			{
				arrayLst.add(tmp.getKey());
				if(tmp.getLeftChild() != null)
				{
					que.offer(tmp.getLeftChild());
				}
			   if(tmp.getRightChild() != null )
				{
					que.offer(tmp.getRightChild());
				}
					
				
			}
			else
			{
				if(!que.isEmpty())
				{
					que.offer(null);
					
					//System.out.println(que.toString());
					//System.out.println(arrayLst.toString());
				}
				
			}
			
			
		}
		
		System.out.println("Lever Order "+arrayLst.toString());
		
	}
	
	public static int maxDepthIterativeUsingStack(Node root){
        if(root == null) return 0;
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        int maxDepth = 0;
        Node prev = null;
        while(!s.isEmpty()){
        	Node curr = s.peek();
            if(prev == null || prev.getLeftChild() == curr || prev.rightChild == curr){
                if(curr.getLeftChild() != null) s.push(curr.getLeftChild());
                else if(curr.rightChild != null) s.push(curr.rightChild);
            }else if(curr.getLeftChild() == prev){
                if(curr.rightChild != null) s.push(curr.rightChild);
            }else
                s.pop();
            prev = curr;
            if(s.size() > maxDepth)
                maxDepth = s.size();
        }
        return maxDepth;
    }
	
	public static int maxDepthRecursive(Node root) {
        if(root == null) return 0;
        /* compute the depth of each subtree */
        int leftDepth = maxDepthRecursive(root.getLeftChild());
        System.out.println("leftDepth --: "+leftDepth);
        int rightDepth = maxDepthRecursive(root.rightChild);
        System.out.println("rightDepth --: "+leftDepth);
        int finalDepth = (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
        System.out.println("leftDepth :: "+leftDepth);
        System.out.println("rightDepth :: "+leftDepth);
        return finalDepth;
    }
}

class Node {

	int key;
	String value;
	Node leftChild;
	Node rightChild;

	Node(int key, String str) {
		this.key = key;
		this.value = str;

	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	/*public String toString() {

		return value + " has a key " + key;
	}*/

}