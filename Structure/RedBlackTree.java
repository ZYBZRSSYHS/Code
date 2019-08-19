package com.tuling.tree;

public class RedBlackTree {
	
	private final int R = 0;	//红色
	private final int B = 1;
	
	private Node root;		//树的根节点
	
	class Node{
		
		int data;
		int color = R;		//每次插入一定是红色
		Node left;
		Node right;
		Node parent;
		
		public Node(int data) {
			this.data = data;
		}
	}
	//root我们先默认第一个点就行了
	public void insert(Node root,int data) {
		if(root.data < data) {		//插入到右子树
			if(root.right == null) {
				root.right = new Node(data);
			}else {
				insert(root.right, data);
			}
		}else {
			if(root.left == null) {
				root.left = new Node(data);
			}else {
				insert(root.left, data);
			}
		}
	}
	
	public void leftRotate(Node node) {		//左旋 说白了就是去修改各个节点的指针而已 归根就是三个node的指针
		//分两种情况
		//1 就是根节点转 简单一点，因为上面没有点了 少操作一个指针 表示就是root节点了
		if(node.parent == null) {
			Node right = root.right;	
			root.right = right.left;//根据左旋的性质 E点的右子树变换为S的左子树
			right.left.parent = root;		//心加进来的S左子树会挂在E点上，所以他的parent变换为R
			root.parent = right;		//S点上浮变成了新的根节点
			right.parent = null;		//变成了新跟节点 没有parent
		}else {	//就是我的那个图形一抹一样 有根节点
			//1.判断当前点在父结点的左子树还是右子树
			if(node == node.parent.left) {
				node.parent.left = node.right;//就是把S浮上来变成了新的左子树
			}else {
				node.parent.right = node.right;
			}
			node.right.left.parent = node;		//S点原来的左子树会挂到E上面
			node.right.parent = node.parent;		//S点上浮 变成E的父结点		
			node.parent = node.right;			//E点的Parent会变成原来的S点
			
			node.right = node.right.left;		//S点子树指针挂到了E点上面去
			node.parent.left = node;			//修改根节点的指针
			
		}
	}
	
}
