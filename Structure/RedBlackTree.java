package com.tuling.tree;

public class RedBlackTree {
	
	private final int R = 0;	//��ɫ
	private final int B = 1;
	
	private Node root;		//���ĸ��ڵ�
	
	class Node{
		
		int data;
		int color = R;		//ÿ�β���һ���Ǻ�ɫ
		Node left;
		Node right;
		Node parent;
		
		public Node(int data) {
			this.data = data;
		}
	}
	//root������Ĭ�ϵ�һ���������
	public void insert(Node root,int data) {
		if(root.data < data) {		//���뵽������
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
	
	public void leftRotate(Node node) {		//���� ˵���˾���ȥ�޸ĸ����ڵ��ָ����� �����������node��ָ��
		//���������
		//1 ���Ǹ��ڵ�ת ��һ�㣬��Ϊ����û�е��� �ٲ���һ��ָ�� ��ʾ����root�ڵ���
		if(node.parent == null) {
			Node right = root.right;	
			root.right = right.left;//�������������� E����������任ΪS��������
			right.left.parent = root;		//�ļӽ�����S�����������E���ϣ���������parent�任ΪR
			root.parent = right;		//S���ϸ�������µĸ��ڵ�
			right.parent = null;		//������¸��ڵ� û��parent
		}else {	//�����ҵ��Ǹ�ͼ��һĨһ�� �и��ڵ�
			//1.�жϵ�ǰ���ڸ���������������������
			if(node == node.parent.left) {
				node.parent.left = node.right;//���ǰ�S������������µ�������
			}else {
				node.parent.right = node.right;
			}
			node.right.left.parent = node;		//S��ԭ������������ҵ�E����
			node.right.parent = node.parent;		//S���ϸ� ���E�ĸ����		
			node.parent = node.right;			//E���Parent����ԭ����S��
			
			node.right = node.right.left;		//S������ָ��ҵ���E������ȥ
			node.parent.left = node;			//�޸ĸ��ڵ��ָ��
			
		}
	}
	
}
